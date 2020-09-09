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
}
