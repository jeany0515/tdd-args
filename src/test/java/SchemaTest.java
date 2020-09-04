import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SchemaTest {
    @Test
    void should_return_error_message_when_verify_given_args_with_flag_not_exist_in_schema() {
        //given
        Map<String, String> schemaInput = new HashMap<>();
        schemaInput.put("l", "boolean");
        Map<String, String> argsInput = new HashMap<>();
        argsInput.put("p", null);

        //when
        Schema schema = new Schema(schemaInput);
        Exception exception = assertThrows(RuntimeException.class, () ->
                schema.validate(argsInput));

        //then
        assertEquals("Flag p does not exist in schema", exception.getMessage());
    }

    @Test
    void should_return_error_message_when_verify_given_args_with_value_type_not_match_schema() {
        //given
        Map<String, String> schemaInput = new HashMap<>();
        schemaInput.put("l", "number");
        Map<String, String> argsInput = new HashMap<>();
        argsInput.put("l", "true");

        //when
        Schema schema = new Schema(schemaInput);
        Exception exception = assertThrows(RuntimeException.class, () ->
                schema.validate(argsInput));

        //then
        assertEquals("The value type of flag l is wrong", exception.getMessage());
    }

    @Test
    void should_return_true_when_verify_given_args_with_flag_and_value_match_schema() {
        //given
        Map<String, String> schemaInput = new HashMap<>();
        schemaInput.put("l", "number");
        Map<String, String> argsInput = new HashMap<>();
        argsInput.put("l", "1234");

        //when
        Schema schema = new Schema(schemaInput);
        boolean expected = schema.validate(argsInput);

        //then
        assertEquals(true, expected);
    }

    @Test
    void should_return_args_detail_when_parser_given_args_with_flag_and_value_match_schema() {
        //given
        Map<String, String> schemaInput = new HashMap<>();
        schemaInput.put("l", "number");
        schemaInput.put("p", "string");
        schemaInput.put("b", "boolean");
        Map<String, String> argsInput = new HashMap<>();
        argsInput.put("l", "1234");
        argsInput.put("p", "hello");
        argsInput.put("b", "true");

        Map<String, Object> argsResult = new HashMap<>();
        argsResult.put("l", 1234);
        argsResult.put("p", "hello");
        argsResult.put("b", true);


        //when
        Schema schema = new Schema(schemaInput);
        Map<String, Object> expected = schema.parser(argsInput);

        //then
        assertEquals(argsResult, expected);
    }

    @Test
    void should_return_args_detail_with_default_value_when_parser_given_args_less_than_schema() {
        //given
        Map<String, String> schemaInput = new HashMap<>();
        schemaInput.put("l", "number");
        schemaInput.put("p", "string");
        schemaInput.put("b", "boolean");
        Map<String, String> argsInput = new HashMap<>();
        argsInput.put("l", "1234");

        Map<String, Object> argsResult = new HashMap<>();
        argsResult.put("l", 1234);
        argsResult.put("p", "");
        argsResult.put("b", false);


        //when
        Schema schema = new Schema(schemaInput);
        Map<String, Object> expected = schema.parser(argsInput);

        //then
        assertEquals(argsResult, expected);
    }
}
