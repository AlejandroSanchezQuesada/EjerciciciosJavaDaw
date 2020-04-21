
public class Utensillio extends Producto {

    private double peso;
    private String categoria;

    public Utensillio(double Precio, String Codigo, String Marca, String Nombre, double peso, String categoria) {
        super(Precio, Codigo, Marca, Nombre);
        this.peso = peso;
        this.categoria = categoria;
    }

    @Override
    public String Mostrar() {
        return super.Mostrar()+" "+peso+" "+categoria;
        
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
