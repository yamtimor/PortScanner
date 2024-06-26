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


### Interactive Mode

Run without arguments to be prompted for input:

```bash
java Main
```

