package formasexamen;
import java.util.LinkedList;

public class Formas 
{

    
    public static void main(String[] args) 
    {
        Punto2D p1, p2;
        Punto3D p3,p4;
        double dist;
        LinkedList<Punto> listaPuntos = new LinkedList();
        Rectangulo r1,r2;
        Cuadrado c1,c2;
        
        /* Probamos la clase Punto2D */
        
        System.out.println("PROBAMOS LA CLASE PUNTO2D");
        
        //Inicializamos con el constructor sin parámetros
        p1 = new Punto2D();        
        p2 = new Punto2D(1,1);

        //Getters and Setters
        System.out.println("El valor x de p1 es: " + p1.getX());
        System.out.println("El valor y de p1 es: " + p1.getY());
        
        System.out.println("El valor x de p2 es: " + p2.getX());
        System.out.println("El valor y de p2 es: " + p2.getY());
        
        //toString
        System.out.println("P1 --> " + p1);
        System.out.println("P2 --> " + p2);
        
        //mover
        p2.mover(1,1);
        System.out.println("mover(1,1) sobre P2 -->" + p2);
        
        //distancia
        dist = p1.distancia(p2);
        
        System.out.println("Distancia entre p1 y p2: " + dist);
        
        System.out.println("");
       
        
        /* Probamos la clase Punto3D */
        
        System.out.println("PROBAMOS LA CLASE PUNTO3D");
        
        
        //Inicializamos con el constructor sin parámetros
        p3 = new Punto3D();        
        p4 = new Punto3D(1,1,1);
        
        //Getters and Setters
        System.out.println("El valor x de p3 es: " + p3.getX());
        System.out.println("El valor y de p3 es: " + p3.getY());
        System.out.println("El valor z de p3 es: " + p3.getZ());
        
        System.out.println("El valor x de p4 es: " + p4.getX());
        System.out.println("El valor y de p4 es: " + p4.getY());
        System.out.println("El valor z de p4 es: " + p4.getZ());
        
        //toString
        System.out.println(p3);
        System.out.println(p4);

        
        //distancia
        dist = p3.distancia(p4);
        
        System.out.println("Distancia entre p3 y p4: " + dist);
       
        System.out.println("");
        
        
        /* PROBAMOS LA LIGADURA DINÁMICA */
        System.out.println("LIGADURA DINÁMICA");
        
        listaPuntos.add(p1);
        listaPuntos.add(p2);
        listaPuntos.add(p3);
        listaPuntos.add(p4);
        
        for(int i=0; i<listaPuntos.size(); i++)
            System.out.println(listaPuntos.get(i).toString());
        
        System.out.println("");
       
        
        /* PROBAMOS LA CLASE RECTÁNGULO */
        
        System.out.println("PROBAMOS LA CLASE RECTÁNGULO");
        
        r1 = new Rectangulo();
        r2 = new Rectangulo(p2,2,4);
        
        System.out.println("R1--> " + r1);
        System.out.println("R2-->" + r2);
        
        System.out.println("Área de R1--> " + r1.area());
        
        r2.mover(1, 1);
        System.out.println("R2 movido(1,1) --> " + r2);
        
        System.out.println("");
        
        /* PROBAMOS LA CLASE CUADRADO */
        System.out.println("PROBAMOS LA CLASE CUADRADO");
        
        c1 = new Cuadrado();
        c2 = new Cuadrado(p2,2);
        
        System.out.println("C1--> " + c1);
        System.out.println("C2-->" + c2);
        
        System.out.println("Área de C2--> " + c2.area());
        
        r2.mover(2, -2);
        System.out.println("C2 movido(2,-2) --> " + c2);
        
    }
    
}

