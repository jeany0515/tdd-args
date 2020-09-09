package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgsTest {
    @Test
    void should_return_8080_when_get_value_of_flag_p_given_arg_p8080() {
        //given
        String input = "-p 8080";
        Schema schema = new Schema("p:integer");
        Args args = new Args(input, schema);

        //when
        Object actual = args.getValueOf("p");

        //then
        assertEquals(8080, actual);
    }
}
