package clientedirectorios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteDirectorios {

    public static void main(String[] args) {
        InetAddress direcc = null;
        try {

            direcc = InetAddress.getByName(args[0]);
        } catch (UnknownHostException uhe) {
            System.err.println("Host no encontrado : " + uhe);
            System.exit(-1);
        }
        int puerto = 1234;

        Socket sckt = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        
        try {
                sckt = new Socket(direcc, puerto);
                dis = new DataInputStream(sckt.getInputStream());
                dos = new DataOutputStream(sckt.getOutputStream());
                String opcion;
                Scanner sc = new Scanner(System.in);
                //Mensaje de conexion con exito
                System.out.println(dis.readUTF());
                //Mensaje de la lista de opciones disponibles
                System.out.println(dis.readUTF());
                
                //Elegimos la opcion
                opcion = sc.next();
                dos.writeUTF(opcion);
                //Mostramos el resultado
                System.out.println(dis.readUTF());
                //Mensaje final para saber que llegamos al final
                System.out.println(dis.readUTF());
                
                sckt.close();
                dis.close();
                dos.close();
                
                
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
        }
        
        
        
        

    }

}
