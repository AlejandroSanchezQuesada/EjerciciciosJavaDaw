public class Perro extends Animal {

    //Atributos
    public enum tipo_raza {
        PastorAleman, Husky, FoxTerrier, Dalmata, SanBernardo
    };
    private tipo_raza raza;
    private String microchip;

    //Getters
    public String getMicrochip() {
        return microchip;
    }

    public tipo_raza getRaza() {
        return raza;

    }
    //Constructores

    public Perro(String _nombre, tipo_raza _raza, String _fechaNacimiento, double _peso, String _microchip) {
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
                + "fechaNacimiento " + fechaNacimiento + "\n peso " + peso + "\n microchip " + microchip +"\n comentarios:"+comentarios +"\n ";

    }


}
