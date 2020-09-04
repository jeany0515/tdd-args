import java.util.HashMap;
import java.util.Map;

public class Schema {
    private Map<String, String> schema;

    public Schema(Map<String, String> schema) {
        this.schema = schema;
    }

    public boolean validate(Map<String, String> argsInput) {
        for (String key : argsInput.keySet()) {
            if (!schema.containsKey(key)) {
                String message = String.format("Flag %s does not exist in schema", key);
                throw new RuntimeException(message);
            } else {
                String valueType = schema.get(key);
                String flagValue = argsInput.get(key);
                try {
                    if(valueType.equals("number")) {
                        Integer.parseInt(flagValue);
                    }
                    if(valueType.equals("boolean") && !(flagValue.equals("true") || flagValue.equals("false"))) {
                        throw new Exception();
                    }
                } catch (Exception error){
                    String message = String.format("The value type of flag %s is wrong", key);
                    throw new RuntimeException(message);
                }

            }
        }

        return true;
    }

    public  Map<String, Object> parser(Map<String, String> argsInput) {
        Map<String, Object> result = new HashMap<>();
        for (String key : schema.keySet()) {
            String valueType = schema.get(key);
            String flagValue = argsInput.get(key);
            Object value = flagValue;
            if (valueType.equals("number")) {
                value = argsInput.containsKey(key) ? Integer.parseInt(flagValue) : 0;
            }
            if (valueType.equals("boolean")) {
                value = argsInput.containsKey(key) && Boolean.parseBoolean(flagValue);
            }
            if (valueType.equals("string")) {
                value = argsInput.containsKey(key) ? flagValue : "";
            }

            result.put(key, value);
        }

        return  result;
    }
}
