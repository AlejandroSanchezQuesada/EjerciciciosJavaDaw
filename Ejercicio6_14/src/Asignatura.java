
public class Asignatura {

    //Atributos
    private String NomAsignatura;
    private float nota;

    //Constructores
    public Asignatura(String _NomAsignatura, float _nota) {

        NomAsignatura = _NomAsignatura;
        nota = _nota;

    }

    //Getters y Setters
    public String getNomAsignatura() {
        return NomAsignatura;
    }

    public void setNomAsignatura(String _NomAsignatura) {
        NomAsignatura = _NomAsignatura;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float _nota) {
        nota = _nota;
    }

    //Metodos
    public String Calificacion() {
        if (getNota() >= 5) {
            return "Aprobado";
        } else {
            return "Suspenso";
        }

    }

    public String ConsulNom() {

        return getNomAsignatura();

    }

    public String Datos() {
        String r = getNomAsignatura() + " : " + getNota() + " : " + Calificacion();

        return r;

    }

}
