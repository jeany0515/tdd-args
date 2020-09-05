package v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Args {
    private final String command;
    private final List<Arg> args = new ArrayList<>();

    public Args(String command, Schema schema) {
        this.command = command.trim();
        String[] list = " ".concat(this.command).replaceAll("\\s+", " ").split(" -");
        List<String> args = new ArrayList<>(Arrays.asList(list));
        args.remove(0);
        args.forEach(arg -> this.args.add(new Arg(arg, schema)));
    }

    public Object getValueOf(String flag) {
        return args.stream().filter(arg -> arg.getFlag().equals(flag)).findFirst().get().getValue();
    }
}

