import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.util.Scanner;
 
public class Serveur {
 
    public static void main(String[] zero) {
         
         
       ServerSocket socketserveur;
       Socket socketduserveur1;
       PrintWriter out;

       Scanner scan = new Scanner(System.in);
       String message = new String();
       
        try {
         socketserveur = new ServerSocket(8080, 3); //création socket serveur : _num port : 8080, client max: 3
            
         socketduserveur1 = socketserveur.accept(); //création socket spécifique au client si connexion acceptée 
         System.out.println("client connecté!\n");
         out = new PrintWriter(socketduserveur1.getOutputStream());//création buffer et lui associe le flux de sortie du "socketserveur1"
	 message = scan.nextLine();
         out.write(message);
         //out.write("connexion établit");//écriture dans le buffer 
         out.flush();//on vide le buffer

         socketserveur.close();
         socketduserveur1.close();
         
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}
