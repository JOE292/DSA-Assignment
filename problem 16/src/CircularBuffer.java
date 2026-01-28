public class CircularBuffer {

    private Log[] buffer;
    private int capacity;
    private int start;
    private int size;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new Log[capacity];
        this.start = 0;
        this.size = 0;
    }


    public Log insert(Log log) {
        if (size < capacity) {
            int index = (start + size) % capacity;
            buffer[index] = log;
            size++;
            return null;
        } else {
            Log oldest = buffer[start];
            buffer[start] = log;
            start = (start + 1) % capacity;
            return oldest;
        }
    }


    public Log[] getAll() {
        Log[] logs = new Log[size];
        for (int i = 0; i < size; i++) {
            logs[i] = buffer[(start + i) % capacity];
        }
        return logs;
    }


    public void purge(int timestamp) {
        Log[] currentLogs = getAll();
        buffer = new Log[capacity];
        start = 0;
        size = 0;

        for (Log log : currentLogs) {
            if (log.timestamp >= timestamp) {
                insert(log);
            }
        }
    }

    public int getSize() {
        return size;
    }
}
