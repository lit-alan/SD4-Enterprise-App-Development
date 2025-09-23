## A guide for students who are using H2 for Lab Ex 2 (as a result of MYSQL not being installed on the machines in the lab)

### _H2 is a lightweight, fast, in-memory relational database often used for development, testing, and prototyping in Java applications._

### 1. Add a dependency for H2 to the POM

```xml
 <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
```


### 2. Add these settings to the .properties file (removing any of the MySQL settings)


```properties

# ===============================
# H2 Database Connection
# ===============================
spring.datasource.url=jdbc:h2:mem:jpa_example;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Show SQL in the console
spring.jpa.show-sql=true

# Hibernate dialect for H2
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Automatically create / update schema from JPA entities
spring.jpa.hibernate.ddl-auto=update

# Enable H2 web console (http://localhost:8888/h2-console)
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.defer-datasource-initialization=true

```


### 3. Create a file called data.sql and add it to the resources folder of your project. Add the following to it. 

_This script will execute on startup and will add a number of records to each of the tables. The database schema is auto-generated from the entity classes_

```sql
-- Customers (IDs auto-generated 1,2,…)
INSERT INTO customers (first_name, last_name, email, pwd, address, city)
VALUES ('Eoin', 'Murphy', 'eoin.murphy@hotmail.com', 'eoinpa$$', '13 Talbot Street', 'Dublin');

INSERT INTO customers (first_name, last_name, email, pwd, address, city)
VALUES ('Barry', 'Smith', 'barry.s@hotmail.com', 'brpa$$', '13 Talbot Street', 'Dublin');

-- Products (IDs auto-generated 1,2,…)
INSERT INTO products (product_name, description, price, colour)
VALUES ('Recycled Denim Jeans', 'Stylish jeans made from recycled denim material.', 79.99, 'Blue');

-- Reviews (use generated IDs: customer 1 = Eoin, product 1 = first product)
INSERT INTO reviews (customer_id, product_id, rating, review_text, review_date, flagged_as_spam)
VALUES (1, 1, 5, 'Great product! Excellent quality and eco-friendly materials.', '2023-05-15', 0);

```
### 4. Since password is a reserved word in H2, I renamed the column in the customer table to pwd; Now you need to update the Customer class by mapping the password field to pwd using @Column(name="pwd").


```java

    //@Column(name = "password") replace this with the following
    @Column(name = "pwd") 
    private String password;
```

### 5. If you need (want) to access the H2 console and view the data in the tables nativate to

`http://localhost:8888/h2-console`

For the JDBC URL use `jdbc:h2:mem:jpa_example`

For the User Name use `sa` and leave the password blank.

**For example:**   

<img width="484" height="333" alt="image" src="https://github.com/user-attachments/assets/5eb282d2-bd7d-4f22-9d7b-b64c9c4a3b68" />

