package ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio7 {

    public static void separa(String ficheroOrigen, String ficheroFinal) {

        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        String linea;
        String lineaFinal = "";
        String cortame[];
        try {
            fr = new FileReader(ficheroOrigen);
            br = new BufferedReader(fr);
            fw = new FileWriter(ficheroFinal);
            bw = new BufferedWriter(fw);

            while ((linea = br.readLine()) != null) {

                lineaFinal = lineaFinal + linea;

            }

            cortame = lineaFinal.split(" ");
            
            
            for (int i = 0; i < cortame.length; i++) {
                bw.write(cortame[i]);
                bw.newLine();
            }
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio7.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio7.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        
            try {
                if (ficheroOrigen != null) {
                    br.close();
                }
                if (ficheroFinal != null) {
                    bw.close();
                }
                
                
                
            } catch (Exception e) {
            }
        
        
        
        }

    }

    public static void main(String[] args) {

        separa("fichero1.txt", "fichero2.txt");

    }

}
