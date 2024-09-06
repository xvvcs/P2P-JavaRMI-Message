import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddressServerInterface extends Remote {
    void registerPeer(String alias, String address) throws RemoteException;
    String lookupPeer(String alias) throws RemoteException;
}
