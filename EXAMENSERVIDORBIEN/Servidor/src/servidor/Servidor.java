package servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread {

    Socket sCliente;
    static ArrayList<String> ListaPaises = new ArrayList();
    String adivinanza = "melocoton";

    public Servidor(Socket sCliente) {
        this.sCliente = sCliente;
    }

    public void run() {

        try {
            DataOutputStream dos = new DataOutputStream(sCliente.getOutputStream());
            DataInputStream dis = new DataInputStream(sCliente.getInputStream());
            boolean palabracorrecta = false;
            
            while (palabracorrecta != true) {
                dos.writeUTF("Introduce la palabra secreta");
                String palabra = dis.readUTF();

                if (palabra.equals(adivinanza)) {
                    dos.writeUTF("Usuario conectado");
                    palabracorrecta = true;
                    dos.writeBoolean(palabracorrecta);
                } else {
                    dos.writeUTF("Palabra secreta incorrecta");
                    palabracorrecta = false;
                    dos.writeBoolean(palabracorrecta);

                }

            }
//--------------------------------------------------------------------
            boolean orden = false;
            while (orden != true) {
                dos.writeUTF("Introduzca nombre pais europeo, escriba fin para salir");
                String pais = dis.readUTF();
                pais = pais.toUpperCase();
                boolean comprobando = false;
                if (!pais.equals("FIN")) {    
                    for (int i = 0; i < ListaPaises.size(); i++) {
                        if (pais.equals(ListaPaises.get(i))) {
                            comprobando = true;
                            i++;
                            dos.writeUTF(ListaPaises.get(i));
                            i = ListaPaises.size();
                            
                        }

                    }
                    if (comprobando == false) {
                        dos.writeUTF("PAIS NO ENCONTRADO");
                    }

                } else {
                    dos.writeUTF("saliendo del servidor");
                    orden = true;
                    sCliente.close();
                }

            }

            

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        ServerSocket skServidor;

        metemeEnLista();

        try {
            skServidor = new ServerSocket(1234);
            System.out.println("Servidor iniciado");
            System.out.println("Lista de paises cargada!");

            while (true) {
                Socket sCliente;
                try {
                    sCliente = skServidor.accept();
                    new Servidor(sCliente).start();
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void metemeEnLista() {

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader("CapitalesEuropa.txt");
            br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                ListaPaises.add(linea);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
    
    
    
    
    

}
