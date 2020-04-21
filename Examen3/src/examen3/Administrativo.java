package examen3;

public class Administrativo extends Empleado{
    
    private char categoria;
    private int horasExtra;

    public Administrativo() {
    }


    public Administrativo( String nombre, String apellidos, int salarioBase, char categoria, int horasExtra) {
        super(nombre, apellidos, salarioBase);
        this.categoria = categoria;
        this.horasExtra = horasExtra;
        salarioBase = calculaSalario();
        
    }
//Getter y Setter

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }
    
//Metodos
    
    @Override
    public String muestraInf(){
    
    return super.muestraInf()+  " Categoria : "+getClass().getSimpleName();
    }
    
    
    @Override
    public int calculaSalario(){
        if (getCategoria() == 'A') {
            salarioBase = salarioBase+175;
        }else if (getCategoria() == 'B') {
            salarioBase = salarioBase+125;
        }else if (getCategoria() == 'C') {
            salarioBase = salarioBase+75;
        }else if (getCategoria() == 'D') {
            salarioBase = salarioBase+25;
        }
        
        int sueldoExtra = 8*getHorasExtra();
        salarioBase = salarioBase + sueldoExtra;
        
        return salarioBase;
    
    }
    
    
    
    
    
    
    
    
}
