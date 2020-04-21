package servidorcajero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import static java.lang.Integer.parseInt;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorCajero extends Thread{


    String usuarioLogeado;
    String cantidadOperar;
    static ServerSocket skServidor = null;
    Socket sCliente = null;

        public ServidorCajero(Socket sCliente) {

            this.sCliente = sCliente;

        }

        public void run() {

            try {

                DataInputStream dis = new DataInputStream(sCliente.getInputStream());
                DataOutputStream dos = new DataOutputStream(sCliente.getOutputStream());
                dos.writeUTF("Hola bienvenido al Servidor de Aleandro");
                dos.writeUTF("Inserte Usuario y Contraseña");
                String credenciales = dis.readUTF();

                if (Login(credenciales) == true) {
                    dos.writeUTF("Conexion realizada con exito");
                } else {
                    dos.writeUTF("Error en usuario/contraseña cerrando conexion");
                    sCliente.close();
                    dos.close();
                    dis.close();
                }

                //Elegimos Orden
                dos.writeUTF("Opciones disponibles - RETIRAR CANTIDAD, INGRESAR CANTIDAD, FIN ");
                String orden = dis.readUTF();
                orden = orden.toLowerCase();
                String SeparaOrden[] = orden.split(" ");

                if (SeparaOrden[0].equals("retirar")) {
                    Retirar(SeparaOrden[1]);
                } else if (SeparaOrden[0].equals("ingresar")) {
                    Ingresar(SeparaOrden[1]);
                    dos.writeUTF("Ingreso de " + SeparaOrden[1] + " realizado");
                } else if (SeparaOrden[0].equals("fin")) {
                    sCliente.close();
                    dos.close();
                    dis.close();
                } else {
                    System.out.println("Ninguna opcion ha sido correcta");

                }

            } catch (IOException ex) {
                Logger.getLogger(ServidorCajero.class.getName()).log(Level.SEVERE, null, ex);
            }

        }



    public static void main(String[] args) {
        System.out.println("Servidor Iniciado");

        try {
            //ss = new ServerSocket(1234);
            skServidor = new ServerSocket(1234);
        } catch (IOException ex) {
            Logger.getLogger(ServidorCajero.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {

            try {
                Socket sCliente = skServidor.accept();
                new ServidorCajero(sCliente).start();

            } catch (Exception e) {
                System.out.println("error?");
            }

        }

    }
    
        

    public boolean Login(String credenciales) {

        boolean resultado = false;
        String creden[] = credenciales.split(" ");
        String comprueba[];
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader("usuarios.txt");
            br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                comprueba = linea.split(" ");

                if ((comprueba[0].equals(creden[0])) && (comprueba[1].equals(creden[1]))) {
                    resultado = true;
                    usuarioLogeado = creden[0];

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return resultado;
    }

    public void Ingresar(String cantidad) {

        FileReader fr = null;
        BufferedReader br = null;
        String comprueba[];
        try {
            fr = new FileReader("saldos.txt");
            br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                comprueba = linea.split(" ");
                System.out.println(comprueba[0]);
                System.out.println(usuarioLogeado);
                if (comprueba[0].equals(usuarioLogeado)) {
                    cantidadOperar = comprueba[1];
                    System.out.println(cantidadOperar);
                    int cant = Integer.parseInt(cantidadOperar);
                    int cant2 = Integer.parseInt(cantidad);
                    int cant3 = cant + cant2;

                    cantidadOperar = String.valueOf(cant3);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        //Escritura-------------------------------------
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter("saldos.txt", true);
            bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write(usuarioLogeado + " " + cantidadOperar);
            cantidadOperar = "";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fw) {
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void Retirar(String cantidad) {

        FileReader fr = null;
        BufferedReader br = null;
        String comprueba[];
        try {
            fr = new FileReader("saldos.txt");
            br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                comprueba = linea.split(" ");
                System.out.println(comprueba[0]);
                System.out.println(usuarioLogeado);
                if (comprueba[0].equals(usuarioLogeado)) {
                    cantidadOperar = comprueba[1];
                    System.out.println(cantidadOperar);
                    int cant = Integer.parseInt(cantidadOperar);
                    int cant2 = Integer.parseInt(cantidad);
                    int cant3 = cant - cant2;
                    if (cant3 < 0) {
                        cant3 = Integer.parseInt(comprueba[1]);
                        System.out.println("La cantidad a retirar no puede ser negativa, operacion cancelada");
                    }

                    cantidadOperar = String.valueOf(cant3);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        //Escritura-------------------------------------
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter("saldos.txt", true);
            bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write(usuarioLogeado + " " + cantidadOperar);
            cantidadOperar = "";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fw) {
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}
