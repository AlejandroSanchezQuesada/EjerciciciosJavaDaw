package examen3;

import java.util.ArrayList;

public class Examen3 {

    public static void main(String[] args) {
        ArrayList<Empleado>Lista = new ArrayList();
        Empleado juan = new Empleado("Juan","Martinez",800);
        Socio mariano = new Socio("Mariano","Fernandez",800,15);
        Administrativo lucas = new Administrativo("Lucas","Hernandez",800,'C',10);
        Administrativo antonio = new Administrativo("Antonio","Garcia",800,'A',15);
        Socio juanl = new Socio("Juan","Lopez",800,4);
        
        
        
        Lista.add(juan);
        Lista.add(mariano);
        Lista.add(lucas);
        Lista.add(antonio);
        Lista.add(juanl);
        
        
        for (int i = 0; i < Lista.size(); i++) {
            System.out.println(Lista.get(i).muestraInf());
        }
        
        
    }
    
}
