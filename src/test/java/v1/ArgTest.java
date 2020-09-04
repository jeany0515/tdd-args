package v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArgTest {
    @Test
    void should_return_8080_when_get_arg_value_given_arg_p_8080() {
        //given
        String input = "p 8080";
        Schema schema = new Schema("p:number");
        Arg arg = new Arg(input, schema);

        //when
        Object actual = arg.getValue();

        //then
        assertEquals(8080, actual);
    }

    @Test
    void should_return_true_when_get_arg_value_given_arg_p_true() {
        //given
        String input = "p true";
        Schema schema = new Schema("p:boolean");
        Arg arg = new Arg(input, schema);

        //when
        Object actual = arg.getValue();

        //then
        assertEquals(true, actual);
    }


    @Test
    void should_return_false_when_get_value_flag_given_arg_flag_p_type_boolean() {
        //given
        String input = "p";
        Schema schema = new Schema("p:boolean");
        Arg arg = new Arg(input, schema);

        //when
        Object actual = arg.getValue();

        //then
        assertEquals(false, actual);
    }

    @Test
    void should_return_0_when_get_value_flag_given_arg_flag_p_type_number() {
        //given
        String input = "p";
        Schema schema = new Schema("p:number");
        Arg arg = new Arg(input, schema);

        //when
        Object actual = arg.getValue();

        //then
        assertEquals(0, actual);
    }
}
