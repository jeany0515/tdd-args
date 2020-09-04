import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgsTest {
    @Test
    void should_return_true_when_verify_given_args_start_and_end_with_blank_space() {
        //given
        String argsInput = "   -l   ";

        //when
        Args args =  new Args(argsInput);
        boolean actual = args.validate();

        //then
        assertEquals(true, actual);
    }

    @Test
    void should_return_false_when_verify_given_args_not_start_with_middle_line() {
        //given
        String argsInput = "   l  -p   ";

        //when
        Args args =  new Args(argsInput);
        boolean actual = args.validate();

        //then
        assertEquals(false, actual);
    }


    @Test
    void should_return_false_when_verify_given_args_with_duplicate_flag() {
        //given
        String argsInput = "-l -p 8080 -l ";

        //when
        Args args =  new Args(argsInput);
        boolean actual = args.validate();

        //then
        assertEquals(false, actual);
    }

    @Test
    void should_return_false_when_verify_given_args_with_flag_pb() {
        //given
        String argsInput = "-pb -p 8080 -l ";

        //when
        Args args =  new Args(argsInput);
        boolean actual = args.validate();

        //then
        assertEquals(false, actual);
    }

    @Test
    void should_return_false_when_verify_given_args_with_value_separated_with_blank_space() {
        //given
        String argsInput = " -p 8080 123 -l ";

        //when
        Args args =  new Args(argsInput);
        boolean actual = args.validate();

        //then
        assertEquals(false, actual);
    }

    @Test
    void should_return_true_when_verify_given_args_in_the_right_way() {
        //given
        String argsInput = " -p 8080  -l ";

        //when
        Args args =  new Args(argsInput);
        boolean actual = args.validate();

        //then
        assertEquals(true, actual);
    }
}
