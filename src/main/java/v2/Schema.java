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
            isFlagDuplicated(flagTypes[0]);
            this.flagTypes.put(flagTypes[0], flagTypes[1]);
        });
    }

    private void isFlagDuplicated(String flag) {
        if(flagTypes.containsKey(flag)) {
            throw new RuntimeException("Schema flag duplicated");
        }
    }

    public String getTypeOf(String flag) {
        return flagTypes.get(flag);
    }

    public boolean isContain(String flag) {
        return flagTypes.containsKey(flag);
    }
}
