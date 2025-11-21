package skrudra.alads.maps;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class PatientRecord {

    String id;
    long timestamp;
    String data;
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public PatientRecord(String id, String timestamp, String data) throws ParseException {
        this.id = id;
        this.timestamp = df.parse(timestamp).getTime();
        this.data = data;
    }
    @Override
    public String toString() {
        return id + ", " + timestamp + ", " + data;
    }
}

public class MostRecentThreadSafeOptimized {
    private static final ConcurrentMap<String, PatientRecord> LATEST_RECORDS = new ConcurrentHashMap<>();

    public static void main(String[] args) throws ParseException {
        List<Map<String, String>> input = getInput();

        for (Map<String, String> map : input) {
            processRecord(new PatientRecord(map.get("patient_id"), map.get("timestamp"), map.get("data")));
        }
        LATEST_RECORDS.entrySet().forEach(System.out::println);
    }

    private static void processRecord(PatientRecord record) {
        LATEST_RECORDS.merge(record.id, record, (existing, incoming) -> existing.timestamp > incoming.timestamp ? existing : incoming);
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
