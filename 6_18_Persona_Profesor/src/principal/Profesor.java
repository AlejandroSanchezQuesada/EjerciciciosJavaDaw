package principal;

public class Profesor extends Persona {

    private String idProfesor;

    public Profesor() {
        super();
        idProfesor = "Desconocido";

    }

    public Profesor(String _nombre, String _apellidos, int _edad, String _idProfesor) {
        super(_nombre, _apellidos, _edad);
        idProfesor = _idProfesor;

    }
//Getters y Setters
    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }
//Metodos
    
    @Override
    public void MostrarDatos(){
    System.out.print(" - idProfesor : "+idProfesor+" ");
    super.MostrarDatos();
        
       
    
    }
    
    
    
    
}
