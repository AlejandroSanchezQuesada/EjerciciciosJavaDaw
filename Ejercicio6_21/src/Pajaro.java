public class Pajaro extends Animal{
    public enum tipo_especie {Canario, Periquito, Agapornis};
    private tipo_especie especie;
    private boolean cantor;
    
    public Pajaro(String _nombre, tipo_especie _especie, String _fechaNacimiento, double _peso, boolean _cantor) {
        super();

        nombre = _nombre;
        especie = _especie;
        fechaNacimiento = _fechaNacimiento;
        peso = _peso;
        cantor = _cantor;

    }

    @Override
    public String toString() {
        return "nombre " + nombre + "\n especie " + especie + "\n "
                + "fechaNacimiento " + fechaNacimiento + "\n peso " + peso + "\n cantor " + cantor +"\n comentarios:"+comentarios+"\n ";
    }
    
    
    
}
