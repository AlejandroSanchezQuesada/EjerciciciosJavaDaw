
import java.util.ArrayList;

public class Alquiler {
    
    private String nomPelicula;
    private String nomCliente;
    
     ArrayList<String> ListaPelis = new ArrayList();
 
    
    public Alquiler(){
    
    
    }
    
    public Alquiler(String _nomPelicula){
    nomPelicula = _nomPelicula;
    ListaPelis.add(nomPelicula);
    
    
    }
    
    
    public Alquiler(String _nomPelicula, String _nomCliente){
    
    nomPelicula = _nomPelicula;
    nomCliente = _nomCliente;
    ListaPelis.add(nomPelicula);
    
    }

    public String getNomPelicula() {
        return nomPelicula;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomPelicula(String nomPelicula) {
        this.nomPelicula = nomPelicula;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

   public String ListaPelis(){
       String r = "";
       for (int i = 0; i < ListaPelis.size(); i++) {
          return r = ListaPelis.get(i);
       }
         return r;
   
   }
    
    public String toString2(){
    return getNomCliente() + " - " + getNomPelicula();
    
    }
    
    
    
    
}
