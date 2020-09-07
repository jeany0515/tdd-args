package v1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schema {
    private Map<String, ValueType> schema = new HashMap<>();

    public Schema(String schema) {
        List<String> flagSchemas = Arrays.asList(schema.split(" "));
        flagSchemas.forEach(flagSchema -> {
            String[] flagInfos = flagSchema.split(":");
            Object defaultValue = "";

            if (flagInfos[1].equals("number")) {
                defaultValue = 0;
            }
            if (flagInfos[1].equals("boolean")) {
                defaultValue = false;
            }
            ValueType valueType = new ValueType(flagInfos[1], defaultValue);
            this.schema.put(flagInfos[0], valueType);
        });
    }

    public String getTypeOf(String flag) {
        return schema.get(flag).getType();
    }

    public boolean isContain(String flag) {
        return schema.containsKey(flag);
    }

    public Object getDefaultValue(String flag) {
        return schema.get(flag).getDefaultValue();
    }
}
