package clienteadivina;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteAdivina {

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
        Scanner sc = new Scanner(System.in);
        boolean correcto = false;
        try {
            sckt = new Socket(direcc, puerto);
            dis = new DataInputStream(sckt.getInputStream());
            dos = new DataOutputStream(sckt.getOutputStream());

            //Mensaje bienvenida servidor
            System.out.println(dis.readUTF());
            //Mensaje de Espera
            System.out.println(dis.readUTF());
            //Mensaje de comenzar el juego
            System.out.println(dis.readUTF());

            while (correcto == false) {
                int intento = sc.nextInt();

                dos.writeInt(intento);
                String resultado = dis.readUTF();
                System.out.println(resultado);

                if (resultado.equals("Correcto! eres el ganador!")) {
                    correcto = true;
                }

            }

        } catch (Exception e) {
        }

    }

}
