// Programa que pide los bigramas al servidor por medio de Sockets
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.rmi.*;
public class Cliente {
    Servidor servidor;

    public Cliente()
    {
      System.err.println("\nInicializando el cliente...\n");
      try{
        servidor = (Servidor) Naming.lookup("//localhost/Servidor");

      }
      catch(Exception e){
         e.printStackTrace();
         System.exit(1);
      }
    }


    public void getBigramsFromClient()  {
      BufferedReader stdbr = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Escriba el bigrama :");
      //program
      String in;
      try {
        while ((in=stdbr.readLine()) != null) {

          int count = servidor.getBigramCount(in);
          System.out.println("La cantidad de veces que aparece el bigrama es ->: "+count);
          System.out.println("Escriba el siguiente bigrama :");
        }
      }catch(IOException e)
      {

      }


    }
  
    public static void main( String args[] )
    {
        Cliente app = new Cliente();
        app.getBigramsFromClient();
    }
}
