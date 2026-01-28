import java.util.ArrayList;
import java.util.List;

public class LogSystem {

    private CircularBuffer hot;
    private CircularBuffer warm;
    private CircularBuffer cold;

    public LogSystem(int hotSize, int warmSize, int coldSize) {
        hot = new CircularBuffer(hotSize);
        warm = new CircularBuffer(warmSize);
        cold = new CircularBuffer(coldSize);
    }


    public void log(int timestamp, String severity, String message) {
        Log newLog = new Log(timestamp, severity, message);

        Log overflow = hot.insert(newLog);
        if (overflow != null) {
            overflow = warm.insert(overflow);
            if (overflow != null) {
                cold.insert(overflow);
            }
        }
    }


    public List<Log> query(String severity) {
        List<Log> result = new ArrayList<>();

        for (Log log : hot.getAll()) {
            if (log.severity.equals(severity)) {
                result.add(log);
            }
        }

        for (Log log : warm.getAll()) {
            if (log.severity.equals(severity)) {
                result.add(log);
            }
        }

        for (Log log : cold.getAll()) {
            if (log.severity.equals(severity)) {
                result.add(log);
            }
        }

        result.sort((a, b) -> b.timestamp - a.timestamp);
        return result;
    }


    public void purge(int timestamp) {
        hot.purge(timestamp);
        warm.purge(timestamp);
        cold.purge(timestamp);
    }


    public void status() {
        System.out.println("Hot: " + hot.getSize());
        System.out.println("Warm: " + warm.getSize());
        System.out.println("Cold: " + cold.getSize());
    }
}
