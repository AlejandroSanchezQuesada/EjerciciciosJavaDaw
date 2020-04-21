package clientecajero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteCajero {

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
            Scanner sc = new Scanner(System.in);
            
            //Mensaje de bienvenida y de insertar usuario y contrasña
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());
            //Ahora tenemos que ingresar nosotros el usuario y contraseña
            String credenciales = sc.nextLine();
            dos.writeUTF(credenciales);
            //Respuesta del Servidor
            System.out.println(dis.readUTF());
            
            //Si hemos logeado con exito procedemos a dar la orden 
            System.out.println(dis.readUTF());
            String orden = sc.nextLine();
            dos.writeUTF(orden);
            
            
            
            

        } catch (Exception e) {
        }

    }

}
