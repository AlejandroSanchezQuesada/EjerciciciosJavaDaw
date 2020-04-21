package examen3;

public class Socio extends Empleado{
    
    private int numAcciones;

    public Socio() {
    }

    public Socio(int numAcciones) {
        this.numAcciones = numAcciones;
    }

    
    public Socio(String nombre, String apellidos, int salarioBase, int _numAcciones) {
        super(nombre, apellidos, salarioBase);
        numAcciones = _numAcciones;
        salarioBase = calculaSalario();
    }
//Getters y Setters
    public int getNumAcciones() {
        return numAcciones;
    }

    public void setNumAcciones(int numAcciones) {
        this.numAcciones = numAcciones;
    }
    
    @Override
    public String muestraInf(){
    
    return super.muestraInf()+ " Categoria : "+getClass().getSimpleName();
    }
    
    @Override
    public int calculaSalario(){
        if (getNumAcciones() >=1 && getNumAcciones() <=5) {
            salarioBase = salarioBase + 1000;
        }else if (getNumAcciones() >=6 && getNumAcciones() <=20) {
            salarioBase = salarioBase + 3000;
        }else if (getNumAcciones() >20) {
            salarioBase = salarioBase + 5000;
        }else{
            salarioBase = salarioBase + 0;
        }
        
    return salarioBase;
    }
    
    
    
    
    
    
}
