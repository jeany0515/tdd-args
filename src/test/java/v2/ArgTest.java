package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgTest {
    @Test
    void should_return_8080_when_get_value_given_flag_p8080_schema_p_integer() {
        //given
        String flagValue = "p 8080";
        Schema schema = new Schema("p:integer");
        Arg arg = new Arg(flagValue, schema);

        //when
        Object actual = arg.getValue();

        //then
        assertEquals(8080, actual);
    }

    @Test
    void should_return_true_when_get_value_given_flag_l_true_schema_l_boolean() {
        //given
        String flagValue = "l true";
        Schema schema = new Schema("l:boolean");
        Arg arg = new Arg(flagValue, schema);

        //when
        Object actual = arg.getValue();

        //then
        assertEquals(true, actual);
    }

    @Test
    void should_return_false_when_check_is_arg_without_flag() {
        //given
        String flagValue = "l true";
        Schema schema = new Schema("l:boolean");
        Arg arg = new Arg(flagValue, schema);

        //when
        Object actual = arg.withFlag("p");

        //then
        assertEquals(false, actual);
    }
}
