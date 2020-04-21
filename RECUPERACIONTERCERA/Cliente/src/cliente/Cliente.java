package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Cliente {

    static Socket sCliente = null;

    public static void main(String[] args) {

        try {
            String ip = args[0];
            sCliente = new Socket(ip, 1234);
            DataOutputStream dos = new DataOutputStream(sCliente.getOutputStream());
            DataInputStream dis = new DataInputStream(sCliente.getInputStream());
            Scanner sc = new Scanner(System.in);

            login(dis, sc, dos);

            provincias(dis, sc, dos);

            sCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void provincias(DataInputStream dis, Scanner sc, DataOutputStream dos) throws IOException {
        boolean orden = false;

        while (orden != true) {
            System.out.println(dis.readUTF());
            String comunidad = sc.nextLine();
            dos.writeUTF(comunidad);
            System.out.println(dis.readUTF());
            if (comunidad.equalsIgnoreCase("fin")) {
                orden = true;
            }

        }
    }

    private static void login(DataInputStream dis, Scanner sc, DataOutputStream dos) throws IOException {
        boolean palabracorrecta = false;

        while (palabracorrecta != true) {
            System.out.println(dis.readUTF());
            String intento = sc.nextLine();
            dos.writeUTF(intento);

            System.out.println(dis.readUTF());
            palabracorrecta = dis.readBoolean();

        }
    }
}
