# Form Exercise with Sessions and Database Persistence

> **Starting point:** You should already have a working solution to the Lab Exercise 1 before you start this exercise.  
> This exercise asks you to **amend your existing application** rather than create a new application from scratch.
Objective
Modify your existing User Registration application so that registration details are stored in a relational database rather than a file.
You will also add a new page that allows all saved registrations to be viewed.
The existing form, session handling, confirmation pages and editing functionality should continue to operate as they did in the original exercise unless specifically changed below.


### 1.  Replace File Storage with Database Storage

The original application saved the user's details to a file. Remove this file-based persistence and replace it with database storage. When the user selects Save Details on the Details Confirmation Page, the application should:
- Retrieve the user's details from the session.
- Connect to the database using JDBC.
- Insert the user's details into the database.
- Display the existing Thank You page once the details have been successfully saved.

Each registration should be stored as a separate record in the database.

The application should not write the registration details to the file used in the original exercise.

### 2. Database

Execute the following SQL script on MySQL.

```sql
CREATE DATABASE user_registration;
use user_registration;

CREATE TABLE registrations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(200) NOT NULL,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    phone VARCHAR(30) NOT NULL,
    email VARCHAR(255) NOT NULL,
    eu_status VARCHAR(10) NOT NULL,
    how_heard VARCHAR(255),
    comments TEXT
);
```
This script will create a database called `user_registration` and a table called `registrations`.

The `id` field should uniquely identify each registration.
Your application should use JDBC to communicate with the database. The JDBC driver must be managed as a Maven dependency so add the following to the projects POM:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>
```

*You should configure the database connection details appropriately for your development environment.*

### 3. Database Insert
   
- Modify the existing Save Details functionality so that the registration is inserted into the `registrations` table.
- Use a `PreparedStatement` when inserting the user's details.
- Do not construct the SQL statement by concatenating values supplied by the user.
- The application should only display the Thank You page after the database operation has completed successfully.
- If an error occurs while saving the registration, the application should handle the error appropriately rather than displaying the Thank You page.

### 4. Existing Session Functionality
The existing use of the HTTP session should continue to work.
In particular:
- The user's details should continue to be held in the session while they move through the registration process.
- Edit Details should return the user to the registration form.
- The form should be populated with the user's existing details.
- Previously selected radio buttons and checkboxes should remain selected.
- The user should be able to modify their details.
- The updated details should be stored in the session.
- Save Details should save the current details held in the session to the database.


### 5. View All Registrations
- Add a new JSP page to the application which displays all registrations currently stored in the database.
- The page should retrieve the records from the `registrations` table using an appropriate SQL `SELECT` statement.
- Display the results in a suitable format, such as an HTML table.
- The following information should be displayed for each registration:
  
| Field | Description |
| --- | ----------- |
| Name	 | User's name |
| Address	| User's address |
| City	| User's city |
| Country |	User's country |
| Phone	| User's phone number |
| Email	| User's email address |
| EU Status | 	Whether the user selected EU or non-EU |
| How Did You Hear About Us?	| The selected source(s) |
| Comments |	User's comments |


The page should also provide a link to return to the HOME page.

### 6. Navigation
- Provide an appropriate way for a user to access the new View Registrations page.
- For example, a link or button could be added to the HOME page.


### 7. Resources and JDBC
- Use JDBC to perform the database operations required by the application.
- At a minimum, your amended application should demonstrate:
- Establishing a database connection.
- Executing an `INSERT` using a `PreparedStatement`.
- Executing a `SELECT` to retrieve registrations.
- Processing the returned records.
- Displaying the retrieved data in a JSP page.
- Make sure that database resources such as connections, statements and result sets are appropriately closed when they are no longer required.

---


### 8. Expected Result

When complete, your existing application should have the following overall behaviour:
```text
Existing Registration Form
          |
          v
   Submit Details
          |
          v
  Confirmation Page
          |
          v
   View Details
          |
          +------------------+
          |                  |
        Edit               Save
          |                  |
          v                  v
   Registration Form     Database
   (pre-populated)          |
                            v
                        Thank You
                             |
                             v
                           HOME
                             |
                             v
                    Empty Registration Form


HOME
 |
 v
View Registrations
 |
 v
SELECT from Database
 |
 v
Display All Records
```
The finished application should retain the functionality developed in Lab Exercise 1 while replacing file persistence with database persistence and adding the ability to retrieve and display all saved registrations.

> [!WARNING]
> **General consideration:** User-supplied information should not automatically be assumed to be valid or safe.
>
> You should have an awareness of common web application security issues such as **SQL injection** and **cross-site scripting (XSS)**.
>
> Appropriate validation and safe handling of user-supplied information should be need to be considered when developing any web application.
> 
> However, you are not required to implement validation or additional security measures as part of this exercise (but it will be a very important consideration going forward). These are mentioned only as general considerations when developing web applications.

