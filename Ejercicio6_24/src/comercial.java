
public class comercial extends empleado {

    private double comision;

    public comercial(String _nombre, int _edad, double _salario, double _comision) {
        super();
        nombre = _nombre;
        edad = _edad;
        salario = _salario;
        comision = _comision;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
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

    @Override
    public String toString() {
        return getClass().getName() + " nombre: " + nombre + " edad: " + edad + " salario: " + salario + " comision: " + comision;
    }

    public boolean TienePlus() {
        if (edad > 30 && comision > 200) {
            salario = salario + plus;
            return true;
        }

        return false;
    }
}
