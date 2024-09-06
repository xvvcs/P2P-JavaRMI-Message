import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class AddressServerImplementation extends UnicastRemoteObject implements AddressServerInterface {
    private final HashMap<String, String> peerRegistry;

    // Constructor
    public AddressServerImplementation() throws RemoteException {
        peerRegistry = new HashMap<>();
    }

    // Register a peer by alias and address
    @Override
    public void registerPeer(String alias, String address) throws RemoteException {
        peerRegistry.put(alias, address);
        System.out.println(alias + " registered with address " + address);
    }

    // Lookup a peer by alias
    @Override
    public String lookupPeer(String alias) throws RemoteException {
        return peerRegistry.get(alias);
    }
}
