package principal;

public class Persona {

    protected String nombre;
    protected String apellidos;
    protected int edad;
//Constructor por defecto
    public Persona() {
        nombre = "";
        apellidos = "";
        edad = 0;

    }
//Constructor con los tres atributos
    public Persona(String _nombre, String _apellidos, int _edad) {

        nombre = _nombre;
        apellidos = _apellidos;
        edad = _edad;

    }
//Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
//Metodos
    public void MostrarDatos(){
        System.out.println("Nombre : "+nombre+" - Apellidos : "+apellidos+" - edad : "+edad);
    }
    
    
    
}
