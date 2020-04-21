package servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexk
 */
public class Servidor extends Thread {

    Socket sCliente;

    public Servidor(Socket sCliente) {
        this.sCliente = sCliente;
    }

    public void run() {
        try {
            DataOutputStream dos = new DataOutputStream(sCliente.getOutputStream());
            DataInputStream dis = new DataInputStream(sCliente.getInputStream());
            boolean validaPalabra = false;
            String palabrasecreta = palabraSecreta();

            while (validaPalabra != true) {
                dos.writeUTF("Dime la palabra secreta");
                String palabra = dis.readUTF();
                if (palabra.equals(palabrasecreta)) {
                    dos.writeUTF("Adivinaste");
                    validaPalabra = true;
                    dos.writeBoolean(validaPalabra);
                } else {
                    dos.writeUTF("no adivinaste");
                    dos.writeBoolean(validaPalabra);

                }

            }
            dos.writeUTF("Usuario Conectado");
            String pais;
            FileReader fr = null;
            BufferedReader br = null;
            String linea;

            do {
                dos.writeUTF("Introduzca el nombre de un país europeo, fin para salir");
                pais = dis.readUTF();
                pais = pais.toUpperCase();
                System.out.println(pais);
                if (!pais.equals("FIN")) {

                    fr = new FileReader("CapitalesEuropa.txt");
                    br = new BufferedReader(fr);
                    boolean resultadoNegativo = false;
                    while ((linea = br.readLine()) != null) {

                        if (linea.equals(pais)) {
                            dos.writeUTF(br.readLine());
                            dos.writeBoolean(false);
                            resultadoNegativo = true;

                        }

                    }
                    if (resultadoNegativo == false) {
                        dos.writeUTF("PAIS NO ENCONTRADO");
                        dos.writeBoolean(false);
                    }
                } else {
                    dos.writeUTF("Saliendo Programa");
                    dos.writeBoolean(true);

                }

            } while (pais.equals("FIN"));

            sCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {

        ServerSocket skServidor;
        try {
            skServidor = new ServerSocket(1234);

            while (true) {
                Socket sCliente = skServidor.accept();
                new Servidor(sCliente).start(); // start ejecuta el método run
                System.out.println("Cliente aceptado");
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String palabraSecreta() {
        return "melocoton";

    }


    
    
    
}
