# 🔒 Authentication & Token Management in Spring Boot

In this source code, users log in by providing their email and password. The system verifies their credentials and then issues a short-lived access token (3 mins) and a long-lived refresh token (7 days). 
The access token is used to authenticate API requests, while the refresh token allows getting a new access token without logging in again. When a user logs out, their access token is blacklisted, 
and their refresh token is deleted from the database, preventing further use.

##  Overview of Token Flow

1. **User logs in** using `/authenticate` and receives:
   - ✅ **Access Token** (Valid for **3 minutes**)
   - ✅ **Refresh Token** (Valid for **7 days**)

_An **Access Token** is a short-lived credential used to authenticate API requests and grant access to protected resources.  
A **Refresh Token** is a long-lived credential used to obtain a new access token without requiring the user to re-authenticate._

2. **User accesses protected endpoints** using the **access token**.
   - If the access token is **valid**, access is granted.
   - If the access token is **expired** (`401 Unauthorized`), the user must **refresh the token**.

3. **User refreshes the access token** using `/refresh-token` (only if the refresh token is still valid).
   - ✅ If valid, a **new access token** is issued.
   - ❌ If expired or revoked, a `401 Unauthorized` error is returned.

4. **User logs out** using `/logout`:
   - ✅ **Refresh token is deleted from the database**.
   - ✅ **Access token is blacklisted (I have a SET to hold blacklisted access tokens)**.
   - ✅ User must log in again to get new tokens.
  
_Blacklisting is the process of marking tokens as invalid so they can no longer be used for authentication or access to protected resources. If you want to persist blacklisted tokens across server restarts, you should store them in a database._

5. **User cannot refresh tokens after logout or after the refresh token expires**.

---

## Token Expiration Rules

| Token Type | Expiry Time | Purpose |
|------------|------------|----------|
| **Access Token** | 3 minutes | Used for authenticating API requests |
| **Refresh Token** | 7 days | Used for obtaining a new access token after expiration |
| **Access Token (After Logout)** | Immediately blacklisted | Prevents use after logout |
| **Refresh Token (After Logout)** | Deleted | Cannot be used to refresh session |

 Consider setting the expiry time of your access token to 15 mins for your app to prevent having to refresh the access token or log back in again.


## 🔄 Token Lifecycle Diagram
(1) User Logs In  
      ⬇️   
(2) Can Access Protected Endpoint(s) (as long as the send the access token with each request)  
      ⬇️       
(3) Access Token Expires ➡️ ❌ 401 Unauthorized  
      ⬇️     
(4) Refresh Token Used  
       ⬇️    
(5) Access Token Refreshed  
       ⬇️      
(5.1) New Access Token Issued  
(5.2) Same Refresh Token (until expiry)  
       ⬇️   
(6) User Logs Out ➡️ (7) Refresh Token Deleted ➡️ (8) Must Log In Again



---

## What is an Access Token?
An **access token** is a **short-lived** token that is used to authenticate API requests.

### **Key Characteristics**
- Issued when the user **logs in**.
- Sent in the **`Authorization` header** with each request:
- Has a **short validity period** (e.g., **3 minutes**).
- Once expired, **a new access token must be obtained using the refresh token**.
- **Does NOT require storage in the database** (JWT tokens are stateless).

### **Example Usage**
#### **1️⃣ User Successfully Authenticates Themselves With a Username and Password**

| ![image](https://github.com/user-attachments/assets/7c7ca7a0-8aea-4ea8-bffb-e9c42951f064) |
|:--------------------------------------------------------------------------------------:|
| **Receives a short lived access token and longer lived refresh token in the response** |

<br>


#### **2️⃣ Authenticated User Can Access Restricted Resources by Sending The Access Token in the Authorisation Header**

| ![image](https://github.com/user-attachments/assets/2928c210-154d-42ba-a608-fa14362ada1c) |
|:--------------------------------------------------------------------------------------:|
| **Recieves the content and a status 200** |

<br>

#### **3️⃣ If the Access Token Expires (`403 Forbidden`)**

| ![image](https://github.com/user-attachments/assets/4afa7149-39f8-4745-a24a-4e8b31483353) |
|:--------------------------------------------------------------------------------------:|
| **I waited until the access token expired (3 mins) before making this request** |

_The client should now **use the refresh token to get a new access token**._

---

## 🔄 What is a Refresh Token?
A **refresh token** is a **long-lived** token that allows users to get a **new access token** **without re-entering their credentials**.

### ✅ **Key Characteristics**
- Issued along with the **access token** at login.
- **Stored securely** on the client (not sent with every request).
- Has a **longer validity period** (e.g., **7 days**).
- Used **only when the access token expires** to request a new one.
- **Stored in the database** to allow invalidation on logout.
- **Deleted from the database when the user logs out**.

### **Example Usage**
#### **1️⃣ Users Access Token has Expired so they must get Another By Refreshing the Token**

| ![image](https://github.com/user-attachments/assets/8a789603-e8c3-4d20-9c34-ae348f421c04) |
|:--------------------------------------------------------------------------------------:|
| **The refresh token is sent in the body of the request to `/refresh-token`. The response see's a new access token returned** |



### **When is the Refresh Token Deleted?**
- ✅ On **logout** (`POST /logout`).
- ✅ When it **expires naturally** (e.g., **after 7 days**).
- ✅ When the user **logs in again** (old refresh tokens are invalidated).


| ![image](https://github.com/user-attachments/assets/fdcdceaf-9e10-4cbd-a569-6d6b183e2fd4) |
|:--------------------------------------------------------------------------------------:|
| ![image](https://github.com/user-attachments/assets/f0c8368d-fce7-41f7-b964-ce432258c29b) |
| **To Logout Successfully, the User must send their access token in the Authorization Header ALONG WITH the Refresh Token** |


Attempting to use the access token or indeed using the refresh token in future requests will prove futile. E.G.


| ![image](https://github.com/user-attachments/assets/5a22b843-ef7d-4c4a-8551-5ce29bf45b3b)|
|:--------------------------------------------------------------------------------------:|
| **The refresh token cannot be used again as it has been deleted from the database** |

| ![image](https://github.com/user-attachments/assets/8bb2400e-4505-4484-87c2-ad56269388f7) |
|:--------------------------------------------------------------------------------------:|
| **The access token cannot be used again as it has been blacklisted** |



---

## 🛑 How Token Blacklisting Works
**Token blacklisting prevents logged-out users from using their old access tokens**.

### **Key Characteristics**
- When a user logs out, their **access token is added to a blacklist** (I'm using a Set)
- If an access token is blacklisted, requests **are immediately rejected** (`401 Unauthorized`).
- Prevents token reuse **before it naturally expires** (e.g., **stops attackers from using stolen tokens**).
- Implemented using **an in-memory store or a database**.

### **How Blacklisting Works**
1. User logs in → Gets an access token ✅.
2. User logs out (`POST /logout`) → Access token is **blacklisted** ✅.
3. User tries to use the blacklisted token (`GET /protected-resource`) ❌.
4. Request is rejected with `403 Forbidden` ✅.


---

## **Summary**
| Feature | Access Token | Refresh Token |
|---------|-------------|---------------|
| **Purpose** | Authenticate API requests | Issue new access tokens |
| **Validity** | 3 minutes | 7 days |
| **Stored in DB?** | ❌ No (Stateless JWT) | ✅ Yes |
| **Deleted on Logout?** | ⛔ Blacklisted | ✅ Deleted |
| **Can be refreshed?** | ❌ No | ✅ Yes |

 **This ensures secure and scalable authentication while preventing unauthorized access.**


