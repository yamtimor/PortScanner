import java.net.Socket;
import java.net.InetSocketAddress;

public class PortScanner {

    public static void scanPorts (String target, int startPort, int endPort) {

        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress(target, port, 1000));
                System.out.println("Port" + port + "is open.");
            } catch (Exception e) {
                System.out.println("Port " + port + "Is closed.");
            }
        }
    }
    public static void scanPorts(String target) {
        scanPorts(target, 1, 1024); // Calls the overloaded method with default start and end ports
    }


    public static void main (String[] args)
    {
        String target = "TARGET HOST";
        scanPorts(target, 80, 100)
    }
}
