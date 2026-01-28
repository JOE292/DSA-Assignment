public class Main {
    public static void main(String[] args) {

        LogSystem system = new LogSystem(3, 3, 3);

        system.log(100, "INFO", "Server started");
        system.log(101, "WARN", "High memory usage");
        system.log(102, "ERROR", "Disk full");
        system.log(103, "INFO", "Request received");

        System.out.println("Initial Status:");
        system.status();

        system.log(104, "INFO", "Request completed");

        System.out.println("\nAfter adding another log:");
        system.status();

        System.out.println("\nQUERY ERROR:");
        for (Log log : system.query("ERROR")) {
            System.out.println(log.timestamp + " ERROR: " + log.message);
        }

        system.purge(101);

        System.out.println("\nAfter PURGE (timestamp >= 101):");
        system.status();
    }
}
