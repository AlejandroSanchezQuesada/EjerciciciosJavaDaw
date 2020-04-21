package ejercicio6_11;

public class Rueda {

    private boolean inflada;

    public Rueda() {
        inflada = true;

    }

    public boolean inflar() {
        return inflada = true;

    }

    public boolean desinflar() {
        return inflada = false;
    }
    
    
    public String estado(){
    String r;
        if (inflada) {
            return r = "Inflada";
        }else{
        return r = "Desinflada";
        }
    
    }

}
