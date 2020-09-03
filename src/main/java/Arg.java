import java.util.Arrays;
import java.util.List;

public class Arg {
    private List<String> args;

    public Arg(String arg) {
        this.args = Arrays.asList(arg.split("\\s+"));
    }

    private boolean isFlagVerified() {
        return args.get(0).length() == 2;
    }

    public boolean isValidated() {
        return isFlagVerified();
    }
}
