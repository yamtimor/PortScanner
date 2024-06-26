# PortScanner

A simple Java tool to scan ports on a target IP address.

## Usage

### Command-Line Arguments

```bash
java Main <target> [startPort] [endPort] [timeout]
```

- `<target>`: Target IP address.
- `[startPort]`: (Optional) Starting port (default: 1).
- `[endPort]`: (Optional) Ending port (default: 1024).
- `[timeout]`: (Optional) Timeout in ms (default: 200).

#### Examples:

```bash
java Main 192.168.1.1
java Main 192.168.1.1 20 80
java Main 192.168.1.1 20 80 300
```

### Interactive Mode

Run without arguments to be prompted for input:

```bash
java Main
```

#### Example Run:

```sh
$ java Main
No arguments provided. Please enter the target IP address:
192.168.1.1
Enter start port (default 1):
20
Enter end port (default 1024):
80
Enter timeout in milliseconds (default 200):
300
```
