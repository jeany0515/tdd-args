package v1;

public class ValueType {
    private final String type;
    private final Object defaultValue;

    public ValueType(String type, Object defaultValue) {
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public String getType() {
        return type;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }
}
