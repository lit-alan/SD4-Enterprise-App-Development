package sd4.com.application.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentRegistration {
    private String name;
    private String email;
    private int age;
    private String studentId;
    private String course;
    private String password;
    private String confirmPassword;
}
//
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//public class StudentRegistration {
//
//    @NotBlank(message = "Name is required")
//    @Size(
//            min = 3,
//            max = 50,
//            message = "Name must be between 3 and 50 characters"
//    )
//    @Pattern(
//            regexp = "[A-Za-z ]+",
//            message = "Name may contain letters and spaces only"
//    )
//    private String name;
//
//
//    @NotBlank(message = "Email address is required")
//    @Email(message = "Please enter a valid email address")
//    private String email;
//
//
//    @Min(
//            value = 18,
//            message = "Age must be at least 18"
//    )
//    @Max(
//            value = 100,
//            message = "Age must not exceed 100"
//    )
//    private int age;
//
//
//    @NotBlank(message = "Student ID is required")
//    @Pattern(
//            regexp = "[A-Z]{2}[0-9]{6}",
//            message = "Student ID must contain two uppercase letters followed by six digits"
//    )
//    private String studentId;
//
//
//    @NotBlank(message = "Course is required")
//    private String course;
//
//
//    @NotBlank(message = "Password is required")
//    @Size(
//            min = 12,
//            max = 50,
//            message = "Password must be between 12 and 50 characters"
//    )
//    @Pattern(
//            regexp = ".*[A-Z].*",
//            message = "Password must contain at least one uppercase letter"
//    )
//    @Pattern(
//            regexp = ".*[a-z].*",
//            message = "Password must contain at least one lowercase letter"
//    )
//    @Pattern(
//            regexp = ".*[0-9].*",
//            message = "Password must contain at least one number"
//    )
//    @Pattern(
//            regexp = ".*[!@#$%^&*].*",
//            message = "Password must contain at least one special character"
//    )
//    private String password;
//
//
//    @NotBlank(message = "Please confirm your password")
//    private String confirmPassword;
//}
