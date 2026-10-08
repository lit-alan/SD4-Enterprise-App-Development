package sd4.com.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *
 * @author Alan.Ryan
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message="Publisher cannot be empty")
    @Size(min = 3, message="Publisher must be at least 3 characters")
    private String publisher;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;

    @NotNull(message="Price cannot be empty")
    @DecimalMin("1.0")
    private Double price;

    @NotBlank(message="ISBN cannot be null")
    @ISBN(type = ISBN.Type.ISBN_13)
    private String isbn;

    private long authorID;

}


