package ejercicio6_11;

public class Motor {
    
    private boolean arrancado;
    
    public Motor(){
    arrancado = false;
    }
    
    public boolean Arrancar(){
    return arrancado = true;

    
    }
    
    public boolean Parar(){
    return arrancado = false;
    }
    
    public String estado(){
        String r;
        if (arrancado) {
            
            return r = "Arrancado";
        }
        else{return r = "Parado";}
    }
    
}
