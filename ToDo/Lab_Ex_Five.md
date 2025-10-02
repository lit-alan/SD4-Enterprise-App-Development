## Lab Exercise Five. Week :four:


### You must have completed [Lab Ex 4](Lab_Ex_Four.md) before attemtping this exercise.  

#### 1. Amend the `displayAllCustomers` template from Lab Ex 4.

Display each customer’s city in a different colour depending on the value.

Dublin → blue

Belfast → yellow

Limerick → green

Cork → red

Galway → maroon

Any other city → black

For example:

<img width="1338" height="618" alt="image" src="https://github.com/user-attachments/assets/d1919d3a-a741-4c92-8616-eae22b99146a" />


_This conditional formatting should be done in the view (the Thymeleaf template)_

----

#### 2. Append a warning symbol ⚠️ to customers who are not in Dublin.

<img width="1325" height="635" alt="image" src="https://github.com/user-attachments/assets/ca84a8b5-e090-4ca5-aa26-a02360cba850" />



_Again, this conditional formatting should be done in the view (the Thymeleaf template)_

----

#### 3. Permit a customer to leave a review.

- Add an “Add A Review” link beside each customer in the customer list.

- Clicking the link should display a "add a review page".

- On the review form page, display:

    - The customer’s name.

    - A dropdown list of all products (ordered in ascending order)

    - An input for the rating (1–5).

    - A textarea for the review text.

    - A submit button.
 
  - Display a success page after the review has been saved.

The flow is as follows:


<img width="1308" height="544" alt="image" src="https://github.com/user-attachments/assets/b25adc7d-5ef5-4dcc-a887-f0be02040f5b" />

  
<img width="519" height="670" alt="image" src="https://github.com/user-attachments/assets/f3a9f5a1-3e9f-4c41-aee8-483590f218c4" />  

  
<img width="527" height="229" alt="image" src="https://github.com/user-attachments/assets/856becdb-ebe7-42cd-a22e-6ef2f37f5d1a" />  


  
<img width="816" height="60" alt="image" src="https://github.com/user-attachments/assets/e45b0d81-8274-4eb2-8ed8-61cb83c44849" />


_A check of the reviews table will confirm that the review has been saved (notice how it has saved the customer and product ID's)_


### How Best to Approach This?

1. If you haven't already done so, add a Repository for the Review and Product entity classes:

```java
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByProductNameAsc(); //a derived query
}


```
```java
public interface ReviewRepository extends JpaRepository<Review, Long> {
}

```

2. Wrap both Repositorys with a Service Layer (you may have already added these classes).

```java

@Service
public class ProductService {

    @Autowired
    private  ProductRepository productRepository;

    //Get all products (for dropdowns, listings, etc.)
    public List<Product> getAllProducts() {
        return productRepository.findAllByOrderByProductNameAsc(); //I am calling the derived query from the repo here
    }

    //find a product by id
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    //Save or update product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    //Delete product
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
```

```java

/**
 * Service layer for managing product reviews.
 * <p>
 * Provides business logic for creating and saving reviews,
 * linking them to the correct customer and product entities.
 * Acts as an intermediary between the controller layer and the
 * data access layer (repositories).
 */
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Creates and saves a new review for a given customer and product.
     * <p>
     * This method looks up the customer and product by their IDs, then
     * populates a {@link Review} entity with the provided rating and text.
     * The review date is set automatically to the current date, and the
     * review is initially marked as not spam.
     *
     * @param customerId the ID of the customer writing the review
     * @param productId  the ID of the product being reviewed
     * @param rating     the rating value (e.g. 1–5)
     * @param reviewText the free-text review content
     * @return the saved {@link Review} entity
     * @throws IllegalArgumentException if either the customer or product is not found
     */
    public Review addReview(Long customerId, Long productId, Integer rating, String reviewText) {
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        Optional<Product> productOpt = productRepository.findById(productId);

        if (customerOpt.isEmpty() || productOpt.isEmpty()) {
            throw new IllegalArgumentException("Customer or Product not found");
        }

        Review review = new Review();
        review.setCustomer(customerOpt.get());
        review.setProduct(productOpt.get());
        review.setRating(rating);
        review.setReviewText(reviewText);
        review.setReviewDate(new Date());
        review.setFlaggedAsSpam(false);

        return reviewRepository.save(review);
    }
}

```

3. Add a revew controller

```java


/**
 * Controller for managing customer product reviews.
 * <p>
 * Provides endpoints to display the review form for a customer
 * and to handle submission of new reviews.
 */
@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;


    /**
     * Displays the review form for a given customer.
     * <p>
     * Loads the customer by ID and retrieves all available products
     * to populate the product dropdown in the form. A new {@link Review}
     * object is also added to the model to bind form fields.
     *
     * @param customerId the ID of the customer who is leaving a review
     * @param model      the Spring {@link Model} to pass data to the view
     * @return the name of the Thymeleaf template that renders the review form
     * @throws IllegalArgumentException if the customer is not found
     */
    @GetMapping("/new/{customerId}")
    public String showReviewForm(@PathVariable Long customerId, Model model) {
       //ToDO
    }

    /**
     * Handles submission of the review form.
     * <p>
     * Saves a new review for the given customer and product using the
     * {@link ReviewService}, and returns a success page confirming the submission.
     *
     * @param customerId the ID of the customer submitting the review (from the URL path)
     * @param productId  the ID of the product being reviewed (from the form dropdown)
     * @param review     the {@link Review} object containing rating and text from the form
     * @param model      the Spring {@link Model} to pass data to the view
     * @return the name of the Thymeleaf template that renders the success page
     */
    @PostMapping("/save/{customerId}")
    public String saveReview(@PathVariable Long customerId,
                             @RequestParam("productId") Long productId,
                             @ModelAttribute Review review,
                             Model model) {

       //ToDo
    }
}

```
Note that the above controller methods demonstrates how to use both @PathVariable and @RequestParam in Spring MVC:

`@PathVariable` is used for the `customerId` (in the `showReviewForm` method), which is passed as part of the URL path, e.g.

```ini
/reviews/new/1
/reviews/save/1

```

This makes the URL cleaner and ties the review action directly to a specific customer.

`@RequestParam` is what I used for the `productId` (in the `saveReview` method), which is submitted as part of the form data from the product dropdown.
Example:

```ìni
productId=5
rating=4
reviewText="Nice product!"
```


4. Create the views:

`review-form.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Leave a Review</title>
</head>
<body>
<h2>Leave a Review</h2>

<!-- TODO: Display the customer's name here using Thymeleaf -->

<form>
      <!-- TODO: Add the correct th:action here with the customerId -->
      method="post" 
      <!-- TODO: Bind the form to the Review object -->

    <label for="product">Product:</label>
    <select name="productId" id="product" required>
        <!-- TODO: Populate dropdown with product list -->
        <option>Example Product</option>
    </select>

    <label>Rating (1-5):</label>
    <!-- TODO: Bind this input to the rating field -->
    <input type="number" min="1" max="5" required>

    <label>Review:</label>
    <!-- TODO: Bind this textarea to the reviewText field -->
    <textarea rows="5" cols="40" required></textarea>

    <button type="submit">Submit</button>
</form>

</body>
</html>


```
`success.html`

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Review Submitted</title>
</head>
<body>
<h2 th:text="${message}"></h2>
<a th:href="@{/customers}">Back to Customers</a>
</body>
</html>

```

----

#### 4. Regulate Review Submission.
Assume that a new business requirement has been introduced: only customers who have not yet submitted a review are permitted to leave one. Firstly, Update the `displayAllCustomers` template so that the “Add a Review” link is displayed only for customers who have not yet submitted any reviews.


 <img width="1322" height="633" alt="image" src="https://github.com/user-attachments/assets/21fafaa5-cce8-447a-857a-c6c24e5f5cb5" />  

 Add a check in the controller so that if a customer who has already left a review (e.g. Customer 1) tries to navigate directly to  
 `/reviews/new/1`, they are prevented from leaving another review. Even though the “Add a Review” link is hidden for such customers, a user could still attempt to access the form directly by typing the URL into the browser (URL hacking). To handle this, ensure the controller redirects the user back to the home page (or another safe page) instead of displaying the review form.


#### 5. Add Pagination and Sorting.

Add pagination to the `displayAllCustomers` template so that you can display 12 customers at a time (per page). Consult [Lecture 6 on JPQL, Derived Queries, Paging and Sorting for more details](https://lit-main-mdl-euwest1.s3.eu-west-1.amazonaws.com/98/5c/985c7986733c5dc6541ee47208e83d47f21a8158?response-content-disposition=inline%3B%20filename%3D%22JPQL%20and%20Derived%20Query%20Methods.pdf%22&response-content-type=application%2Fpdf&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAWRN6GJFLXROXF4PK%2F20251002%2Feu-west-1%2Fs3%2Faws4_request&X-Amz-Date=20251002T183001Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3599&X-Amz-Signature=428ecbe93ad3a1d19fcf4b9cd26fe76184c694219c70ca69d717335c2ca5aaf1)  

Also modify the table headers in the `displayAllCustomers` template  to be clickable for sorting. Add pagination controls below the table.    

<img width="1176" height="621" alt="image" src="https://github.com/user-attachments/assets/b166052b-29a2-47a1-b4fb-68ceca327d80" />


_I implemented pagination slightly differently here than I did in the lecture. Either approach is acceptable._

What do you need to do? 

- No change is required in the repository as JpaRepository already extends PagingAndSortingRepository, so you don’t need to add anything special for paging/sorting here.
- Add the following to the `CustomerService`
  
```java
/**
     * Retrieves a paginated and sorted list of customers from the repository.
     *
     * <p>This method uses Spring Data JPA's {@link PageRequest} and {@link Sort} to
     * build a {@link Pageable} object that defines both the page size and the sorting order.
     * It delegates to the repository's {@code findAll(Pageable pageable)} method to execute
     * the query with pagination and sorting applied at the database level.</p>
     *
     * @param page         the zero-based page index (0 = first page)
     * @param size         the number of records per page
     * @param sortField    the entity field by which the results should be sorted (e.g. "lastName")
     * @param sortDirection the direction of sorting ("asc" for ascending, "desc" for descending)
     * @return a {@link Page} of {@link Customer} entities containing the requested slice of data
     */
    public Page<Customer> getCustomersPagedAndSorted(int page, int size, String sortField, String sortDirection) {
        //check if the sorting should be asc or desc
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortField).ascending()    
                : Sort.by(sortField).descending();  

        //create a Pageable object using the page index, page size, and sorting config
        Pageable pageable = PageRequest.of(page, size, sort);

        //query the repo with pagination and sorting applied
        return customerRepository.findAll(pageable);
    }
```

- Replace the endpoint in the customer controller that displays all customers with the following.

```java
 @GetMapping({"", "/"})
public String getAllCustomers(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "12") int size,
        @RequestParam(defaultValue = "customerId") String sortField,
        @RequestParam(defaultValue = "asc") String sortDir,
        Model model) {

    Page<Customer> customerPage = customerService.getCustomersPagedAndSorted(page, size, sortField, sortDir);

    model.addAttribute("customerList", customerPage.getContent());
    model.addAttribute("currentPage", page);
    model.addAttribute("totalPages", customerPage.getTotalPages());
    model.addAttribute("totalItems", customerPage.getTotalElements());
    model.addAttribute("sortField", sortField);
    model.addAttribute("sortDir", sortDir);
    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

    return "displayAllCustomers";
}

```
- In the view, enable the column headers so that they are clickable for sorting. EG:
  
```html
<th>
   <a th:href="@{/customers(page=${currentPage}, size=5, sortField='customerId', sortDir=${reverseSortDir})}">
        Customer ID
   </a>
 </th>
```
_enable the other headers too if you wish_

- Add pagination controls under the table.
  
```html

<!-- Pagination -->

<!-- Pagination controls -->
<div>
    <span th:text="'Page ' + ${currentPage + 1} + ' of ' + ${totalPages}"></span>
</div>

<div>
     <!-- just some inline CSS styling for the pagination, take it out to see what it does!-->
    <ul style="list-style:none; display:flex; gap:10px;">
        <li th:if="${currentPage > 0}">
            <a th:href="@{/customers(page=${currentPage - 1}, sortField=${sortField}, sortDir=${sortDir})}">Prev</a>
        </li>

        <li th:each="i : ${#numbers.sequence(0, totalPages-1)}">
            <a th:href="@{/customers(page=${i}, sortField=${sortField}, sortDir=${sortDir})}"
               th:text="${i + 1}"
               th:classappend="${i == currentPage} ? 'active' : ''"></a>
        </li>

        <li th:if="${currentPage < totalPages - 1}">
            <a th:href="@{/customers(page=${currentPage + 1}, sortField=${sortField}, sortDir=${sortDir})}">Next</a>
        </li>
    </ul>
</div>
```

- Could you add a “First” and “Last” button to jump directly to the first/last page?
