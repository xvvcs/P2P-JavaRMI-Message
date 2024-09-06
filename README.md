# Peer-to-Peer Message System using Java RMI

## Overview

This project is a peer-to-peer message system implemented using **Java RMI**. It includes two main components:
- **Peers**: Participants that register with the address server and can send messages to other peers.
- **Address Server**: A centralized server that allows peers to register with an alias and find other peers by their alias.

### Features:
- Peers can register with the address server using a unique alias.
- Peers can look up other peers by alias and send messages.
- Simple RMI-based communication.

---

## How It Works

1. **Start the RMI Registry**: The RMI registry is started programmatically within the `PeerApp` on a specific port (e.g., `5050`).

2. **Address Server Initialization**:
    - The address server is created and registered in the RMI registry.
    - Peers can now register themselves with this address server.

3. **Peer Registration**:
    - Each peer is created with a unique alias and address.
    - Peers register themselves with the address server using their alias, allowing other peers to find them.

4. **Sending Messages**:
    - When a peer wants to send a message, it first queries the address server for the target peer’s address.
    - Once the target peer’s address is found, the message is sent using the RMI remote method invocation.

5. **Receiving Messages**:
    - Peers implement the `sendMessage()` method, which displays any message received from other peers.

---

## Setting up the Project

### Prerequisites

- **Java JDK**: Ensure that Java is installed and properly set up. You can verify this using:
    ```bash
    java -version
    javac -version
    ```

- **IntelliJ IDEA**: This project is structured for IntelliJ, though other IDEs may be used.

### Steps to Run

1. **Clone the Repository**:
   Clone the project from GitHub to your local machine.
   ```bash
   git clone https://github.com/yourusername/yourproject.git
2. **Open in IntelliJ**:
Open IntelliJ IDEA.
Go to File > Open and select the project directory.
3. **Configure RMI Port**:
   In `PeerApp.java`, ensure the RMI registry is started on a port that is not in use (e.g., `5050`).
4. **Build the Project**:
   In IntelliJ, click Build > Build Project or use the shortcut `Cmd + F9` to compile the project.
5. **Run the Application**:
   Right-click on `PeerApp.java` and select Run PeerApp to start the application.
   You will see the address server running, and peers registering and sending messages.
### Author
- **xvvcs**
