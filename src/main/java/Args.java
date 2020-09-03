import java.util.Arrays;
import java.util.List;

public class Args {
    private List<String> args;

    public Args(String args) {
        this.args = Arrays.asList(" ".concat(args).split(" -"));
    }

    public boolean validate() {
        return args.size() > 0;
    }
}
