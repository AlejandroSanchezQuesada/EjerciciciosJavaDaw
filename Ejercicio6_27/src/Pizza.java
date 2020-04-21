public class Pizza {
    
    private String tipo;
    private String tamano;
    private String toppings;
    private double precio;
    
    
    public Pizza(){}

    public Pizza(String tipo, String tamano, String toppings, double precio) {
        this.tipo = tipo;
        this.tamano = tamano;
        this.toppings = toppings;
        this.precio = precio;
    }

    

    

    
    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

 



    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return tipo + " "+ tamano + " " + toppings;
    }
    
    
    
    
    
    
    
    
    
}
