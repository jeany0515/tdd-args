package v1;

public class Arg {
    private String flag;
    private String value;
    private Schema schema;

    public Arg(String arg, Schema schema) {
        String[] flagValue = arg.split("\\s+", 2);
        this.flag = flagValue[0];
        this.value = flagValue.length == 2 ? flagValue[1] : "";
        this.schema = schema;
    }

    public String getFlag() {
        return this.flag;
    }

    public Object getValue() {

        String flagType = schema.getTypeOf(flag);
        if (flagType.equals("number")) {
            return value.isEmpty() ? 0 : Integer.parseInt(value);
        }
        if (flagType.equals("boolean")) {
            return !value.isEmpty() && Boolean.parseBoolean(value);
        }
        return value;
    }
}
