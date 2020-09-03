import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgTest {
    @Test
    void should_return_false_when_verify_arg_given_flag_pb() {
        //given
        String inputArg = "-pb";

        //when
        Arg arg = new Arg(inputArg);
        boolean expected = arg.isValidated();

        //then
        assertEquals(false, expected);
    }

    @Test
    void should_return_true_when_verify_arg_given_flag_p() {
        //given
        String inputArg = "-p";

        //when
        Arg arg = new Arg(inputArg);
        boolean expected = arg.isValidated();

        //then
        assertEquals(true, expected);
    }

    @Test
    void should_return_false_when_verify_arg_given_value_with_blank_space() {
        //given
        String inputArg = "-p 1234 567";

        //when
        Arg arg = new Arg(inputArg);
        boolean expected = arg.isValidated();

        //then
        assertEquals(false, expected);
    }
}
