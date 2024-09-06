import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PeerInterface extends Remote {
    void sendMessage(String message) throws RemoteException;
    String getAlias() throws RemoteException;
}
