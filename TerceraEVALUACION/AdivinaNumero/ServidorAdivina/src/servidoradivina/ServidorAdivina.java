package servidoradivina;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorAdivina {

    public static int EligeNumero() {

        return (int) (Math.random() * 10) + 1;

    }

    public static void main(String[] args) {

        ServerSocket ss = null;

        try {
            ss = new ServerSocket(1234);

        } catch (IOException ex) {
            Logger.getLogger(ServidorAdivina.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }

        int entrada;
        int numero = EligeNumero();

        System.out.println(numero);
        int i = 3;
        while (true) {

            try {
                Socket sckt = ss.accept();

                DataInputStream dis = new DataInputStream(sckt.getInputStream());
                DataOutputStream dos = new DataOutputStream(sckt.getOutputStream());

                int puerto = sckt.getPort();
                // Dirección de Internet remota
                InetAddress direcc = sckt.getInetAddress();
                // Leemos datos de la peticion

                if (i == 0) {
                    dos.writeUTF("Has perdido cerrando conexión");
                    dis.close();
                    dos.close();
                    sckt.close();
                }

                entrada = dis.readInt();

                if (entrada == numero) {
                    dos.writeUTF("Enhorabuena has ganado!");
                    dis.close();
                    dos.close();
                    sckt.close();
                    i = 0;

                } else if (entrada < numero) {
                    i--;
                    dos.writeUTF("Menor Vidas restantes " + i);

                } else {
                    i--;
                    dos.writeUTF("Mayor Vidas restantes " + i);

                }

            } catch (IOException ex) {
                Logger.getLogger(ServidorAdivina.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
