import java.rmi.Naming;

public class PeerApp {
    public static void main(String[] args) {
        try {
            // Start RMI registry programmatically on port 5000
            java.rmi.registry.LocateRegistry.createRegistry(5050);

            // Create and bind the Address Server
            AddressServerImplementation addressServer = new AddressServerImplementation();
            Naming.rebind("//localhost:5050/addressServer", addressServer);
            System.out.println("Address Server is running.");

            // Create two peers and register them
            Peer peer1 = new Peer("peer1", addressServer);
            Peer peer2 = new Peer("peer2", addressServer);

            // Bind peers to the RMI registry
            Naming.rebind("//localhost:5050/peer1", peer1);
            Naming.rebind("//localhost:5050/peer2", peer2);

            // Register peers with the Address Server
            peer1.registerPeer("//localhost:5050/peer1");
            peer2.registerPeer("//localhost:5050/peer2");

            // Simulate peer1 sending a message to peer2
            peer1.sendMessageToPeer("peer2", "Hello from peer1!");
            peer2.sendMessageToPeer("peer1", "Hello from peer2!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
