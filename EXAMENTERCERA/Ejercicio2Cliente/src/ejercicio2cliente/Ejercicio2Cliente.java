package ejercicio2cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio2Cliente {

    static Socket sCliente = null;

    public static void main(String[] args) {
        try {
            sCliente = new Socket("127.0.0.1", 1234);
            DataInputStream dis = new DataInputStream(sCliente.getInputStream());
            DataOutputStream dos = new DataOutputStream(sCliente.getOutputStream());
            Scanner sc = new Scanner(System.in);

            //Variables
            boolean validado = false;
            boolean resolviendopaises = false;
            while (validado != true) {
                //Mensaje de decir la palabra secreta
                System.out.println(dis.readUTF());
                //Toca escribirla

                String palabra = sc.nextLine();
                dos.writeUTF(palabra);
                System.out.println(dis.readUTF());
                validado = dis.readBoolean();
            }
            //Mensaje usuario conectado
            System.out.println(dis.readUTF());
            while (resolviendopaises != true) {
                System.out.println(dis.readUTF());
                String pais = sc.next();
                dos.writeUTF(pais);
                //Leemos el resultado del pais 
                System.out.println(dis.readUTF());
                //Obtenemos la booleana para poder salir del bucle
                resolviendopaises = dis.readBoolean();

            }

        } catch (EOFException ax) {

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio2Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
