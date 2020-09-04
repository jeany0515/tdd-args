package v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NewSchemaTest {
    @Test
    void should_return_boolean_when_get_type_given_schema_p_with_boolean() {
        //given
        String input = "p:boolean";
        Schema schema = new Schema(input);

        //when
        String actual = schema.getTypeOf("p");

        //then
        assertEquals("boolean", actual);
    }

    @Test
    void should_return_true_when_schema_contain_flag_p() {
        //given
        String input = "p:boolean";
        Schema schema = new Schema(input);

        //when
        boolean actual = schema.isContain("p");

        //then
        assertEquals(true, actual);
    }
}
