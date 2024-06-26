import java.util.Scanner;

public class ArgumentParser {

    public static void parseArgumentsAndScanPorts(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String target;
        int startPort = 1;
        int endPort = 1024;
        int timeout = 200; // Default timeout in milliseconds

        if (args.length < 1) {
            System.out.println("No arguments provided. Please enter the target IP address:");
            target = scanner.nextLine();

            System.out.println("Enter start port (default 1):");
            try {
                startPort = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                startPort = 1;
            }

            System.out.println("Enter end port (default 1024):");
            try {
                endPort = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                endPort = 1024;
            }

            System.out.println("Enter timeout in milliseconds (default 200):");
            try {
                timeout = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                timeout = 200;
            }
        } else {
            target = args[0];
            if (args.length >= 3) {
                try {
                    startPort = Integer.parseInt(args[1]);
                    endPort = Integer.parseInt(args[2]);

                    if (startPort < 1 || endPort > 65535 || startPort > endPort) {
                        System.out.println("Invalid port range. Please provide a valid range (1-65535).");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid port numbers. Using default range 1-1024.");
                }
            }

            if (args.length == 4) {
                try {
                    timeout = Integer.parseInt(args[3]);

                    if (timeout < 1) {
                        System.out.println("Invalid timeout. Please provide a valid timeout value (greater than 0).");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid timeout value. Using default timeout of 200ms.");
                }
            }
        }

        PortScanner.scanPorts(target, startPort, endPort, timeout);
    }
}
