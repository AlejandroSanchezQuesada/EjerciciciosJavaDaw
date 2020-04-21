package principal;

import java.util.ArrayList;

public class principal {
    
    public static void main(String[] args) {
        ArrayList<Persona>listaPersonas = new ArrayList();
        Persona p1 = new Persona("Mariano","Saura",25);
        
        Profesor profe1 = new Profesor();
        profe1.setNombre("Pedro");
        profe1.setApellidos("López");
        profe1.setEdad(50);
        profe1.setIdProfesor("PL");
        
        listaPersonas.add(p1);
        listaPersonas.add(profe1);
        
        
        for (int i = 0; i < listaPersonas.size(); i++) {
            listaPersonas.get(i).MostrarDatos();
            System.out.println(listaPersonas.get(i).getClass());
            System.out.println("");
        }
        
        
    }
}
