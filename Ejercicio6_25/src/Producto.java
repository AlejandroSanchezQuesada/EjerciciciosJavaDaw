public  class Producto {
    
    protected double Precio;
    protected String Codigo;
    protected String Marca;
    protected String Nombre;

    
    //Constructor
    public Producto(double Precio, String Codigo, String Marca, String Nombre) {
        this.Precio = Precio;
        this.Codigo = Codigo;
        this.Marca = Marca;
        this.Nombre = Nombre;
    }
    
    public String Mostrar(){
    return Precio+" "+Codigo+" "+Marca+" "+Nombre;
    
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
   
    
    
    
    
    
    
    
    
    
    
    
}
