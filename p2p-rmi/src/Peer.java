import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Peer extends UnicastRemoteObject implements PeerInterface {
    private final String alias;
    private final AddressServerInterface addressServer;

    // Constructor
    public Peer(String alias, AddressServerInterface addressServer) throws RemoteException {
        super();
        this.alias = alias;
        this.addressServer = addressServer;
    }

    // Get peer alias
    @Override
    public String getAlias() throws RemoteException {
        return alias;
    }

    // Send a message to another peer
    public void sendMessageToPeer(String peerAlias, String message) throws Exception {
        String peerAddress = addressServer.lookupPeer(peerAlias);
        if (peerAddress != null) {
            PeerInterface peer = (PeerInterface) Naming.lookup(peerAddress);
            peer.sendMessage(message);
        } else {
            System.out.println("Peer not found.");
        }
    }

    // Receive a message
    @Override
    public void sendMessage(String message) throws RemoteException {
        System.out.println("Received message: " + message);
    }

    // Register the peer with the address server
    public void registerPeer(String address) throws Exception {
        addressServer.registerPeer(alias, address);
    }
}
