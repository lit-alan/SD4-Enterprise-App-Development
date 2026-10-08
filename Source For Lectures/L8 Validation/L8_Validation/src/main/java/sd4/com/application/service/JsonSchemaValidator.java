package sd4.com.application.service;


import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import org.everit.json.schema.Schema;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JsonSchemaValidator {

    private Schema schema;

    public JsonSchemaValidator() {
        try {

            //load the schema from the file
            InputStream inputStream = new ClassPathResource("schemas/book-schema.json").getInputStream();


            JSONObject jsonSchema = new JSONObject(new JSONTokener(inputStream));
            this.schema = SchemaLoader.load(jsonSchema);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON schema", e);
        }
    }
//
    public void validateJson(String json) {
        JSONObject jsonObject = new JSONObject(json);

        //This line throws an exception if invalid
        schema.validate(jsonObject);
    }

    //use this version of validateJson and the formatValidationErrors method below to
    //customise the error messages returned
//    public List<String> validateJson(String json) {
//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            //This line throws an exception if invalid
//            schema.validate(jsonObject);
//            return List.of();
//        } catch (ValidationException e) {
//            return formatValidationErrors(e);
//        }
//    }
//
//    private List<String> formatValidationErrors(ValidationException e) {
//        return e.getAllMessages().stream()
//                //Remove JSON Pointer notation
//                .map(msg -> msg.replace("#/", "").replace("#", "Root"))
//                //Remove regex pattern from error messages returned
//                .map(msg -> msg.replaceAll("does not match pattern \\^.*\\$", "is invalid"))
//                .map(msg -> msg.replace("is not of type", "must be of type"))
//                .map(msg -> msg.replace("must have a minimum value", "must be at least"))
//                .collect(Collectors.toList());
//    }

}
