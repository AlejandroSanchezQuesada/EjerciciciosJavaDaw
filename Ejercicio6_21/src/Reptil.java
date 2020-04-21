public class Reptil extends Animal {
    public enum tipo_especie {Tortuga, Iguana, DragonDeComodo};
    private tipo_especie especie;
    private boolean venenoso;
    
    
    public Reptil(String _nombre, tipo_especie _especie, String _fechaNacimiento, double _peso, boolean _venenoso) {
        super();

        nombre = _nombre;
        especie = _especie;
        fechaNacimiento = _fechaNacimiento;
        peso = _peso;
        venenoso = _venenoso;

    }

    @Override
    public String toString() {
        return "nombre " + nombre + "\n especie " + especie + "\n "
                + "fechaNacimiento " + fechaNacimiento + "\n peso " + peso + "\n venenoso " + venenoso +"\n comentarios:"+comentarios+"\n ";
    }
    
    
    
    
    
    
    
    
}
