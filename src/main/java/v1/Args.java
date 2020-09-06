package v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Args {
    private final List<Arg> args = new ArrayList<>();

    public Args(String command, Schema schema) {
        List<String> args = splitToArgs(command.trim());
        args.forEach(arg -> this.args.add(new Arg(arg, schema)));
    }

    private List<String> splitToArgs(String command) {
        String[] list = " ".concat(command).replaceAll("\\s+", " ").split(" -");
        List<String> args = new ArrayList<>(Arrays.asList(list));
        args.remove(0);
        return args;
    }

    public Object getValueOf(String flag) {
        return args.stream().filter(arg -> arg.getFlag().equals(flag)).findFirst().get().getValue();
    }
}

