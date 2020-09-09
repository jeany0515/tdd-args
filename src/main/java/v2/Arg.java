package v2;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class Arg {
    private final String flag;
    private final String value;
    private final String type;

    public Arg(String flagValue, Schema schema) {
        String[] flagValues = flagValue.split(" ");
        this.flag = flagValues[0];
        this.value = flagValues[1];
        this.type = schema.getTypeOf(this.flag);
    }


    public Object getValue() {
        switch (type) {
            case "boolean":
                return parseBoolean(value);
            case "integer":
                return parseInt(value);
            default:
                return value;
        }
    }

    boolean withFlag(String flag) {
        return this.flag.equals(flag);
    }
}
