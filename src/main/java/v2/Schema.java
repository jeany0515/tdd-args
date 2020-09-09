package v2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schema {
    private Map<String, String> flagTypes = new HashMap<>();

    public Schema(String schema) {
        List<String> flagSchemas = Arrays.asList(schema.split(" "));
        flagSchemas.forEach(flagSchema -> {
            String[] flagTypes = flagSchema.split(":");
            this.flagTypes.put(flagTypes[0], flagTypes[1]);
        });
    }

    public String getTypeOf(String flag) {
        return flagTypes.get(flag);
    }
}
