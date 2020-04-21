public class Papel extends Producto {
    
    private String Color;
    private String Tamano;

    public Papel(double Precio, String Codigo, String Marca, String Nombre, String _Color, String _Tamano) {
        super(Precio, Codigo, Marca, Nombre);
        Color = _Color;
        Tamano = _Tamano;
    }
    
    @Override
    public String Mostrar(){
    return super.Mostrar() + " "+Color+" "+Tamano; 
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getTamano() {
        return Tamano;
    }

    public void setTamano(String Tamano) {
        this.Tamano = Tamano;
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
