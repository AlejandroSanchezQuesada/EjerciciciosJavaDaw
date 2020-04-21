package servidordirectorios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ServidorDirectorios {

    public static String ObtieneDirectorio() {
        String resultado = "Mostrando resultado de LISTAR \n";
        File dir = new File(".");
        File[] filesList = dir.listFiles();
            for (File file : filesList) {
                if (file.isFile()) {
            resultado = resultado+(file.getName())+"\n";
                        }

            }
         
        return resultado;


    }
    
    public static String ObtieneRuta(String ruta){
    
    String resultado = "Mostrando resultado de la ruta "+ruta+"\n";
        File dir = new File(ruta);
        File[] filesList = dir.listFiles();
            for (File file : filesList) {
                if (file.isFile()) {
            resultado = resultado+(file.getName())+"\n";
                        }

            }
         
        return resultado;
       
    }
    
    

    public static void main(String[] args) {

        ServerSocket ss = null;

        try {
            ss = new ServerSocket(1234);

        } catch (IOException ex) {
            Logger.getLogger(ServidorDirectorios.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {
           
            try {
                Socket sckt = ss.accept();

                DataInputStream dis = new DataInputStream(sckt.getInputStream());
                DataOutputStream dos = new DataOutputStream(sckt.getOutputStream());

               
                dos.writeUTF("Conectado con éxito!");
                
                dos.writeUTF("Comandos disponibles LIST o CD +('-')+ruta");
                 
                
                String opcion = dis.readUTF();
                opcion = opcion.toLowerCase();
                
                String cd[] = opcion.split("-");
                
                if (opcion.equals("list")) {
                    dos.writeUTF(ObtieneDirectorio());
                }else if (cd[0].equals("cd")) {
                   dos.writeUTF(ObtieneRuta(cd[1]));

                }else{
                dos.writeUTF("Todas las opciones han sido incorrectas");
                }
                
                dis.close();
                dos.close();
                sckt.close();

            } catch (IOException ex) {
                Logger.getLogger(ServidorDirectorios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
