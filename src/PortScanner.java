import java.net.Socket;
import java.net.InetSocketAddress;

public class PortScanner {

    public static void scanPorts(String target, int startPort, int endPort, int timeout) {
        System.out.println("Starting scan on target: " + target + " from port " + startPort + " to " + endPort + " with timeout: " + timeout + "ms");

        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(target, port), timeout); // Use the timeout parameter
                System.out.println("Port " + port + " is open.");
            } catch (Exception e) {
                System.out.println("Port " + port + " is closed.");
            }
        }

        System.out.println("Scan completed on target: " + target);
    }

    public static void scanPorts(String target, int startPort, int endPort) {
        scanPorts(target, startPort, endPort, 200); // Calls the overloaded method with default timeout
    }

    public static void scanPorts(String target) {
        scanPorts(target, 1, 1024, 200); // Calls the overloaded method with default ports and timeout
    }
}
