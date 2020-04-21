package ejercicio6_11;

public class Puerta {

    private Ventana ventanaPuerta = new Ventana();
    private boolean abierta;

    public boolean setCierraPuerta() {
        return abierta = false;

    }

    public boolean setAbrePuerta() {
        return abierta = true;
    }
    
    public String estado(){
    String r;
        if (abierta) {
            return r = "Abierta";
        }else{return r = "Cerrada";}
    
    
    }
    

}
