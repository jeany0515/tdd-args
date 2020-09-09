package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SchemaTest {
    @Test
    void should_return_integer_when_get_type_give_flag_p_and_schema_p_integer() {
        //given
        String flag = "p";
        Schema schema = new Schema("p:integer");

        //when
        String actual = schema.getTypeOf(flag);

        //then
        assertEquals("integer", actual);
    }

    @Test
    void should_return_error_message_when_get_type_given_flag_p_and_schema_l_integer() {
        //given
        String flag = "p";
        Schema schema = new Schema("l:integer");

        //when
        Exception exception = assertThrows(RuntimeException.class, () -> schema.getTypeOf(flag));

        //then
        assertEquals("Flag not found", exception.getMessage());
    }

    @Test
    void should_return_error_message_when_validate_given_schema_duplicate_flag() {
        //when
        Exception exception = assertThrows(RuntimeException.class, () ->
                new Schema("l:integer l:boolean"));

        //then
        assertEquals("Schema flag duplicated", exception.getMessage());
    }
}
