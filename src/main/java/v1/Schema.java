package v1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schema {
    private Map<String, String> schema = new HashMap<>();

    public Schema(String schema) {
        List<String> flagSchemas = Arrays.asList(schema.split(" "));
        flagSchemas.forEach(flagSchema -> {
            String[] flagTypes = flagSchema.split(":");
            this.schema.put(flagTypes[0], flagTypes[1]);
        });
    }

    public String getTypeOf(String flag) {
        return schema.get(flag);
    }

    public boolean isContain(String flag) {
        return schema.containsKey(flag);
    }
}
