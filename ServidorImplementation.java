// Programa que da resultado sobre diagramas a travez de sockets
import java.io.*;
import java.rmi.*;  // Importar Remote y RemoteException de rmi.
import java.rmi.server.*;


public class ServidorImplementation extends UnicastRemoteObject implements Servidor {

    BigramController bigramController;

    public ServidorImplementation () throws RemoteException{
      super();

      String inputFileName = "Input.txt";
      System.out.println("Procesando archivo " + inputFileName);
      this.bigramController = new BigramController("Input.txt");
      //Read the file and create the bigram hashtable with all the bigrams and the count example:
      // "Word1 Word2" => 2
      this.bigramController.createBigramTable();
      //Collect results and fill a array to sort the result.
      this.bigramController.collectResults();

      this.bigramController.printInfile("Results.txt");

      System.out.println("Bigramas procesados");
      System.out.println("Servidor listo");
   }

    public int getBigramCount(String bigram) throws RemoteException
    {
      return bigramController.searchBigram(bigram);
    }


    public static void main(String args[]){
      System.err.println("\nInicializando el servidor...");
      //Se crea el objeto servidor
      try{
        ServidorImplementation s = new ServidorImplementation();
        //Registrar el objeto
        String nombreObjetoServidor = "//localhost/Servidor";
        Naming.rebind(nombreObjetoServidor, s);
      }
      catch(Exception e){
        System.err.println(e);
      }
      System.err.println("\nEl servidor esta corriendo");
    }
}
