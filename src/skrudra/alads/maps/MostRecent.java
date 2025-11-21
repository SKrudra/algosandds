package skrudra.alads.maps;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostRecent {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        List<Map<String, String>> input = getInput();
        Map<String, Map<String, String>> seen = new HashMap<>();
        for (Map<String, String> map : input) {
            seen.putIfAbsent(map.get("patient_id"), map);
            Date existing = df.parse(seen.get(map.get("patient_id")).get("timestamp"));
            Date coming = df.parse(map.get("timestamp"));
            if (coming.compareTo(existing) > 0) {
                seen.put(map.get("patient_id"), map);
            }
        }
        System.out.println(seen);
    }

    private static List<Map<String, String>> getInput() {
        return List.of(
                new HashMap<>() {{
                    put("patient_id", "A123");
                    put("timestamp", "2025-11-20T10:00:00");
                    put("data", "Blood Test");
                }},
                new HashMap<>() {{
                    put("patient_id", "B456");
                    put("timestamp", "2025-11-19T09:00:00");
                    put("data", "X-Ray");
                }}, new HashMap<>() {{
                    put("patient_id", "A123");
                    put("timestamp", "2025-11-21T08:00:00");
                    put("data", "MRI");
                }}, new HashMap<>() {{
                    put("patient_id", "B456");
                    put("timestamp", "2025-11-20T11:00:00");
                    put("data", "CT Scan");
                }}
        );
    }
}
