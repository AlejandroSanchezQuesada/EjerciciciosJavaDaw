package ejercicio4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio4 {

    
    public static void copiaFichero(String nombreOriginal, String nombreCopia){
    FileReader fr = null;
    BufferedReader br = null;
    
    FileWriter fw = null;
    BufferedWriter bw = null;
    String linea;
    
        try {
            fr = new FileReader(nombreOriginal);
            br = new BufferedReader(fr);
            fw = new FileWriter(nombreCopia);
            bw = new BufferedWriter(fw);
            while((linea =br.readLine()) != null){
            bw.write(linea);
            bw.newLine();
            
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        
            try {
                if (nombreOriginal != null) {
                    br.close();
                }
                
                if (nombreCopia != null) {
                   bw.close();
                }
                
            } catch (Exception e) {
            }
        
        }
    
    
        
        
        
    
    }
    
    
    
    public static void main(String[] args) {
        
        copiaFichero("fichero1.txt","fichero2.txt");
        
       
    }
    
}
