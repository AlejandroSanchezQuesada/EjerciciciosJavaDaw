package cinesavenida;

import java.util.ArrayList;

public class CinesAvenida {

    public static void main(String[] args) {
        SalaCine sala1,sala2,sala3,sala4,sala5,sala6;
        ArrayList<SalaCine> neocinedosmares;
        neocinedosmares = new ArrayList();
        
        
        sala1 = new SalaCine();
        sala1.setNombreSala("Sala 1");
        sala1.setAforo(50);
        sala1.setOcupadas(30);
        sala1.setPelicula("Los Inmortales");
        sala1.setEntrada(7.50f);
        
        
        sala2 = new SalaCine("Sala 2","Los Minions",5.50f,120,120);
        sala3 = new SalaCine("Sala 3","Gremmlins",7.50f,60,50);
        sala4 = new SalaCine("Sala 4","Thor",7.50f,150,120);
        sala5 = new SalaCine("Sala 5","Aquaman",9.50f,150,150);
        sala6 = new SalaCine("Sala 6","Bohemian Raphsody",9.50f,75,50);

        neocinedosmares.add(sala1);
        neocinedosmares.add(sala2);
        neocinedosmares.add(sala3);
        neocinedosmares.add(sala4);
        neocinedosmares.add(sala5);
        neocinedosmares.add(sala6);
        
        
       
        
        
        
        
        //Recorro la lista para mostrar el estado de cada sala
        for (int i = 0; i < neocinedosmares.size(); i++) {
            System.out.println(neocinedosmares.get(i).toString2());
            System.out.println("**************************");
        }
        
         //Aumentar precio en un 10%
        
        for (int i = 0; i < neocinedosmares.size(); i++) {
            SalaCine c = neocinedosmares.get(i);
            float precio = c.getEntrada();
            precio = precio * 1.10f;
            c.setEntrada(precio);
        }
        System.out.println("\n ******************************************************* \n");
        //Recorro la lista para mostrar el estado de cada sala
        for (int i = 0; i < neocinedosmares.size(); i++) {
            System.out.println(neocinedosmares.get(i).toString2());
            System.out.println("**************************");
        }
        
        
        
    }
    
}
