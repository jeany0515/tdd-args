package v0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgTest {
    @Test
    void should_return_false_when_verify_arg_given_flag_pb() {
        //given
        String inputArg = "pb";

        //when
        Arg arg = new Arg(inputArg);
        boolean actual = arg.isValidated();

        //then
        assertEquals(false, actual);
    }

    @Test
    void should_return_true_when_verify_arg_given_flag_p() {
        //given
        String inputArg = "p";

        //when
        Arg arg = new Arg(inputArg);
        boolean actual = arg.isValidated();

        //then
        assertEquals(true, actual);
    }

    @Test
    void should_return_false_when_verify_arg_given_value_with_blank_space() {
        //given
        String inputArg = "p 1234 567";

        //when
        Arg arg = new Arg(inputArg);
        boolean actual = arg.isValidated();

        //then
        assertEquals(false, actual);
    }

//    @Test
//    void should_return_true_when_verify_arg_given_many_blank_space_between_flag_and_value() {
//        //given
//        String inputArg = "p 1234";
//
//        //when
//        v0.Arg arg = new v0.Arg(inputArg);
//        boolean actual = arg.isValidated();
//
//        //then
//        assertEquals(true, actual);
//    }
}
