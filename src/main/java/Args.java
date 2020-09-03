import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {
    private String args;
    private List<String> splitArgs;

    public Args(String args) {
        this.args = args.trim();
    }

    private boolean isStartWithMiddleLine() {
        return args.length() > 0 && args.startsWith("-");
    }

    private void setSplitArgs() {
        String[] list = " ".concat(this.args).replaceAll("\\s+", " ").split(" -");
        List<String> splitArgs = new ArrayList<>(Arrays.asList(list));
        splitArgs.remove(0);

        this.splitArgs = splitArgs;
    }

    private boolean isFlagDistinct() {
        setSplitArgs();
        List<String> distinctFlags = splitArgs.stream().map(arg -> arg.split(" ")[0]).distinct().collect(Collectors.toList());
        System.out.println(distinctFlags.toString());
        return distinctFlags.size() == splitArgs.size();
    }

    public boolean validate() {
        return isStartWithMiddleLine() && isFlagDistinct();
    }
}
