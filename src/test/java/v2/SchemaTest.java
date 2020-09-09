package v2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void should_return_true_when_is_contain_flag_given_flag_p_and_schema_p_integer() {
        //given
        String flag = "p";
        Schema schema = new Schema("p:integer");

        //when
        boolean actual = schema.isContain(flag);

        //then
        assertEquals(true, actual);
    }

    @Test
    void should_return_false_when_is_contain_flag_given_flag_p_and_schema_l_integer() {
        //given
        String flag = "p";
        Schema schema = new Schema("l:integer");

        //when
        boolean actual = schema.isContain(flag);

        //then
        assertEquals(false, actual);
    }
}
