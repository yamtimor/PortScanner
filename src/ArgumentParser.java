public class ArgumentParser {

    public static void parseArgumentsAndScanPorts(String[] args) {
        // Check if at least one argument (target IP) is provided
        if (args.length < 1) {
            System.out.println("Usage: java PortScanner <target> [startPort] [endPort]");
            return;
        }

        String target = args[0];
        int startPort = 1;
        int endPort = 1024;
        if (args.length >= 3) {
            try {
                startPort = Integer.parseInt(args[1]);
                endPort = Integer.parseInt(args[2]);

                // Validate port range
                if (startPort < 1 || endPort > 65535 || startPort > endPort) {
                    System.out.println("Invalid port range. Please provide a valid range (1-65535).");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid port numbers. Using default range 1-1024.");
            }
        }

        PortScanner.scanPorts(target, startPort, endPort);
    }
}
