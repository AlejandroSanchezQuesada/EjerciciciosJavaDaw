package ejercicio7_24;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio7_24 {

    private static ArrayList <Integer> lista =new ArrayList();
    private static ArrayList <Integer> lista2 =new ArrayList();
    
    

    public static void main(String[] args) throws IOException {
        FileReader primero=null;
        FileReader segundo=null;
        try {
             primero = new FileReader("Fichero1.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio7_24.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
             segundo = new FileReader("Fichero2.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio7_24.class.getName()).log(Level.SEVERE, null, ex);
        }
        noCoinciden(primero, segundo);

    }

    public static void noCoinciden(FileReader x, FileReader y) throws IOException {
        BufferedReader bf = null;
        BufferedReader bf2 = null;
        String linea;
        int aux=0;
        try {
            bf = new BufferedReader(x);
            bf2 = new BufferedReader(y);
            while((linea=bf.readLine())!=null){  
                aux=Integer.parseInt(linea);
                lista.add(aux);
            }
            while((linea=bf2.readLine())!=null){
                aux=Integer.parseInt(linea);
                lista2.add(aux);
            }
            
            for(int i=0;i<lista.size();i++){
                for(int j=0;j<lista2.size();j++){
                    if(lista.get(i)==lista2.get(j)){
                        System.out.println(lista.get(i));
                    }
                }
            }
           
        }catch(IOException e){
            
        }finally{
            try{
                if(bf!=null){
                    bf.close();
                }
                if(bf2!=null){
                    bf2.close();
                }
            }catch(IOException e){
                
            }
        }

    }

}
