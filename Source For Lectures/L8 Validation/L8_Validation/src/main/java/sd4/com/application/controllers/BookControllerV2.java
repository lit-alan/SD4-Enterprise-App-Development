package sd4.com.application.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sd4.com.application.model.Book;
import sd4.com.application.service.BookService;
import sd4.com.application.service.JsonSchemaValidator;

import java.util.List;

@RestController
@RequestMapping("/books/v2")
public class BookControllerV2 {

    @Autowired
    private BookService bookService;

    @Autowired
    private JsonSchemaValidator jsonSchemaValidator;



    //use this version of addBook and the ErrorResponse class below
    //to customise the error messages returned
//    @PostMapping
//    public ResponseEntity<?> addBook(@RequestBody String bookJson) {
//
//        try {
//            List<String> errors = jsonSchemaValidator.validateJson(bookJson);
//
//            if (!errors.isEmpty()) {
//                return ResponseEntity.badRequest().body(
//                        new ErrorResponse("Invalid JSON", errors)
//                );
//            }
//
//            //Convert the json string to a Book object (Deserialization)
//            ObjectMapper objectMapper = new ObjectMapper();
//            Book b = objectMapper.readValue(bookJson, Book.class);
//
//            bookService.saveBook(b);
//
//            return ResponseEntity.ok("Book entity is valid and has been added");
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Invalid JSON: " + e.getMessage());
//        }
//    }
//
//    static class ErrorResponse {
//        private final String message;
//        private final List<String> errors;
//
//        public ErrorResponse(String message, List<String> errors) {
//            this.message = message;
//            this.errors = errors;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//
//        public List<String> getErrors() {
//            return errors;
//        }
//    }
}
