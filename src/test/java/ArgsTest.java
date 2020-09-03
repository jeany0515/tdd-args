import Args.Args;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgsTest {
    @Test
    void should_return_true_when_verify_given_args_start_and_end_with_blank_space() {
        //given
        String argsInput = "   -l   ";

        //when
        Args args =  new Args(argsInput);
        boolean expected = args.validate();

        //then
        assertEquals(true, expected);
    }
}
