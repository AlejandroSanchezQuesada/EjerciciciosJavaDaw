package examen3;

public class Empleado {

    protected String nombre;
    protected String apellidos;
    protected int salarioBase;
//Constructores

    public Empleado() {
        salarioBase = 800;
    }

    public Empleado(String nombre, String apellidos, int salarioBase) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salarioBase = salarioBase;
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

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String muestraInf() {
        return nombre + " " + apellidos + "               Salario: " + salarioBase;
    }

    public int calculaSalario() {

        return getSalarioBase();

    }

}
