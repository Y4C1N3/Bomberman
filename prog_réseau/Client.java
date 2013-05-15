import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
 
 
public class Client {
     
    public static void main(String[] zero) {
         
         InetAddress adresse_client;
	 InetAddress adresse_serveur;
         BufferedReader in;
 
        try {
             adresse_serveur = InetAddress.getLocalHost();// serveur machine locale
             //adresse_serveur = InetAdress.getByName(192.168..); serveur machine distante
             Socket socket = new Socket(adresse_serveur, 8080); 
             System.out.println("Demande de connexion");
        
             in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//on écrit dans le buffer ce que nous écrit le serveur
             String message_distant = in.readLine();//on stocke la première ligne dans "message_distant"
             System.out.println(message_distant);//on écrit sur la sortie standard le "message_distant"
             socket.close();
 
        }catch (UnknownHostException e) {
             
            e.printStackTrace();
        }catch (IOException e) {
             
            e.printStackTrace();
        }
    }
 
}
