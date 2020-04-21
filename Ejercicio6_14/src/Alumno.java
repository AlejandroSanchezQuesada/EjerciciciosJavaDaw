
import java.util.ArrayList;

public class Alumno {

    //Atributos
    private String nombre;
    private int edad;
    private ArrayList<Asignatura> ListaAsignatura = new ArrayList();

    //Constructores
    public Alumno(String _nombre, int _edad) {
        nombre = _nombre;
        edad = _edad;
    }
    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String _nombre) {
        nombre = _nombre;
    }

    public void setEdad(int _edad) {
        edad = _edad;
    }

    public ArrayList<Asignatura> getListaAsignatura() {
        return ListaAsignatura;
    }
    
    
    
    

    public float Promedio() {
        float media = 0f;
        int cont = 0;
        for (int i = 0; i < ListaAsignatura.size(); i++) {
            media = media + ListaAsignatura.get(i).getNota();
            cont++;
        }
        media = media / cont;

        return media;
    }

    public void PonAsignatura(String _Asignatura, float _nota) {
        ListaAsignatura.add(new Asignatura(_Asignatura, _nota));

    }

    public String Datos() {

        String r = getNombre() + " M:" + Promedio();
        return r;

    }

}
