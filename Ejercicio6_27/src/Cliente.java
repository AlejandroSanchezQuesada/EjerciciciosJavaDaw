public class Cliente {
   
    private String nombre;
    private String direccion;
    private String email;
    
    
    public Cliente(){}

    public Cliente(String nombre, String direccion, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
    }

    
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente: " + "nombre=" + nombre + ", direccion=" + direccion + ", email=" + email;
    }
    
    
   
    
    
    
}
