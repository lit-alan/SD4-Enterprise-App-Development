## Lab Exercise Three. Week :four:


### You must have completed [Lab Ex 2](Lab_Ex_Two.md) before attemtping this exercise.  


  
### 1. Remove all code from the `CustomerRepository` and replace it with the following:

```java
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

```
_`JpaRepository` in Spring Data is a generic interface that provides basic CRUD (Create, Read, Update, Delete) operations (out of the box) for a specific entity type without requiring boilerplate code (that you just removed from the `CustomerREpository`. It also provides pagination (as well as some other features). Pagination, allows you to handle lrge datasets efficiently—reducing memory load, speeding up queries, and improving user experience by showing results in smaller, manageable chunks_  


_Run your application again,and it should run as before_

### 2. Amend the 'displayAllCustomers' Feature from Lab Ex 2.

![image](https://github.com/user-attachments/assets/b7efe0e3-6c70-4a56-9226-3e71604db5ab)


_Displaying only data from the `customers` table for each customer_

```html
<tr th:each="customer : ${customerList}">
        <td th:text="${customer.customerId}"></td>
        <td th:text="${customer.firstName} + ' ' + ${customer.lastName}"></td>
        <td th:text="${customer.email}"></td>
        <td th:text="${customer.address}"></td>
        <td th:text="${customer.city}"></td>
    </tr>
```

_Ensure that each `customerID` appears as a [link](https://www.thymeleaf.org/doc/articles/standardurlsyntax.html) that when clicked on will provide further information for each `customer`. This is in effect a data drill down_


![image](https://github.com/user-attachments/assets/f85bff7f-9d2b-43b7-9eda-cfea82ae6091)

_In the drill down page, for each `review` that the customer has made; display the the `name` of the product, the review `rating` and the `reviewText`_

If end user enters an invalid customer id (via the url): `customers/drilldown/333333` for example, the controller should redirect to `/customers`





