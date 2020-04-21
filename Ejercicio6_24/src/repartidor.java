public class repartidor extends empleado {
    
    private String zona;

    public repartidor(String _nombre, int _edad, double _salario, String _zona) {
        super();
        nombre = _nombre;
        edad = _edad;
        salario = _salario;
        zona = _zona;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean TienePlus(){
    if (edad < 25 && zona.equals("zona3")){
        salario = salario+plus;
        return true;
    }
    return false;
    
    
    }
    
    
    
    
    @Override
    public String toString() {
        return getClass().getName()+" nombre: "+nombre+" edad: "+edad+" salario: "+salario+" zona: "+zona;
    }
    
    
    
    
    
}
