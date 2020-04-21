
import java.util.ArrayList;

public class main {
   public static void main(String[] args) {
       ArrayList<Soporte>ListaSoportes = new ArrayList();
       CintaVideo cv = new CintaVideo("Ciudadano Kane",5487,15,95);
       DVD dv = new DVD("Fargo",5488,14.99f,115);
       Juego j = new Juego("Pro Evolution 2019",5489,45,"PS3",1,4);
       
       
       
       ListaSoportes.add(cv);
       ListaSoportes.add(dv);
       ListaSoportes.add(j);
       
       for (int i = 0; i < ListaSoportes.size(); i++) {
           System.out.println(ListaSoportes.get(i).imprimeDatos());
       }
       
       
       
       
}
 
}
