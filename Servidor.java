import java.rmi.*; // Importar Remote y RemoteException de rmi.

public interface Servidor extends Remote {
  ///Get
   public int getBigramCount(String bigram) throws RemoteException;
}
