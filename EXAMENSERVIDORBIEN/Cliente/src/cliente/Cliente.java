package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    static Socket sCliente = null;

    public static void main(String[] args) {

        try {
            sCliente = new Socket("127.0.0.1", 1234);
            DataOutputStream dos = new DataOutputStream(sCliente.getOutputStream());
            DataInputStream dis = new DataInputStream(sCliente.getInputStream());
            Scanner sc = new Scanner(System.in);
            boolean palabracorrecta = false;
            boolean orden = false;

            while (palabracorrecta != true) {
                System.out.println(dis.readUTF());
                String intento = sc.nextLine();
                dos.writeUTF(intento);

                System.out.println(dis.readUTF());
                palabracorrecta = dis.readBoolean();

            }
//-----------------------------------------------------------------
            while (orden != true) {
                System.out.println(dis.readUTF());
                String pais = sc.nextLine();
                dos.writeUTF(pais);
                if (pais.equalsIgnoreCase("FIN")) {
                    orden = true;
                }
               System.out.println(dis.readUTF());

            }

            sCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
