public class Gato extends Animal{
    
    public enum tipo_raza {Comun,Siames, Persa, Angora, ScottishFold};
    private tipo_raza raza;
    private String microchip;
    
    //Constructor
    
    public Gato(String _nombre, tipo_raza _raza, String _fechaNacimiento, double _peso, String _microchip) {
        super();

        nombre = _nombre;
        raza = _raza;
        fechaNacimiento = _fechaNacimiento;
        peso = _peso;
        microchip = _microchip;

    }

    @Override
    public String toString() {
           return "nombre " + nombre + "\n raza " + raza + "\n "
                + "fechaNacimiento " + fechaNacimiento + "\n peso " + peso + "\n microchip " + microchip +"\n comentarios:"+comentarios+"\n ";

    }
    
    
    
    
    
}
