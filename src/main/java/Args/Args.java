package Args;

public class Args {
    private String args;

    public Args(String args) {
        this.args = args.trim();
    }

    public boolean validate() {
        return args.length() > 0;
    }
}
