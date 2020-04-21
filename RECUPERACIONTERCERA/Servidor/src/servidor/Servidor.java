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
    static ArrayList<String> ListaProvincias = new ArrayList();
    String palabrasecreta = "fresa";

    public Servidor(Socket sCliente) {
        this.sCliente = sCliente;
    }

    public void run() {
        try {
            DataOutputStream dos = new DataOutputStream(sCliente.getOutputStream());
            DataInputStream dis = new DataInputStream(sCliente.getInputStream());
            login(dos, dis);

            provincias(dos, dis);

            sCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void provincias(DataOutputStream dos, DataInputStream dis) throws IOException {
        boolean orden = false;
        while (orden != true) {
            dos.writeUTF("Introduce nombre de una comunidad, 'fin' para salir");
            String comunidad = dis.readUTF();
            if (!comunidad.equalsIgnoreCase("fin")) {
                boolean encontrado = false;
                for (int i = 0; i < ListaProvincias.size(); i++) {
                    if (comunidad.equalsIgnoreCase(ListaProvincias.get(i))) {
                        i++;
                        dos.writeUTF(ListaProvincias.get(i));
                        encontrado = true;
                    }

                }
                if (encontrado == false) {
                    dos.writeUTF("Provincia no encontrada");
                }

            } else {
                dos.writeUTF("Saliendo servidor");
                orden = true;
            }

        }
    }

    private void login(DataOutputStream dos, DataInputStream dis) throws IOException {
        boolean palabracorrecta = false;

        while (palabracorrecta != true) {
            dos.writeUTF("Introduce la palabra secreta");
            String intento = dis.readUTF();

            if (intento.equals(palabrasecreta)) {
                dos.writeUTF("Usuario conectado");
                palabracorrecta = true;
                dos.writeBoolean(palabracorrecta);
            } else {
                dos.writeUTF("Palabra Introducida incorrecta");
                dos.writeBoolean(palabracorrecta);
            }

        }
    }

    public static void main(String[] args) {

        try {
            ServerSocket skServidor = new ServerSocket(1234);
            System.out.println("Conexion iniciada");
            cargaLista();
            System.out.println("Lista de pronvincias cargada");

            while (true) {
                Socket sCliente = skServidor.accept();
                new Servidor(sCliente).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cargaLista() {

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader("provincias.txt");
            br = new BufferedReader(fr);
            String linea;
            int cont = 0;
            while ((linea = br.readLine()) != null) {
                if (cont == 0 || cont % 2 == 0) {
                    ListaProvincias.add(linea);
                } else {
                    String divide[] = linea.split(" ");
                    String datosBonitos = "Latidud:" + divide[0] + "  Longitud:" + divide[1];
                    ListaProvincias.add(datosBonitos);
                }

                cont++;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (fr != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

}
