import java.net.Socket;
import java.net.InetSocketAddress;

public class PortScanner {

    private static final int TIMEOUT = 200; // Timeout in milliseconds

    public static void scanPorts (String target, int startPort, int endPort) {
        System.out.println("Starting scan on target: " + target + " from port " + startPort + " to " + endPort);

        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(target, port), TIMEOUT);
                System.out.println("Port" + port + " is open.");
            } catch (Exception e) {
                System.out.println("Port " + port + " is closed.");
            }
        }

        System.out.println("Scan completed on target: " + target);
    }
    public static void scanPorts(String target) {
        scanPorts(target, 1, 1024); // Calls the overloaded method with default start and end ports
    }
}
