/*
*
*Hojar.java
* Creada por Fran y editada por Alejandro Sanchez el 8 de Junio
*/
package Hogar;

/**
 *Esta clase contiene los atributos para generar una vivienda llamando a la clase vivienda
 * @author alejandro sanchez
 */
public class Hogar 
{
/*
    * Metodo main donde se ejecuta el programa
  */  
    public static void main(String[] args) 
    {
        /**
         * Constructor que inicia los parametros de la casa
         * @param precio determina el precio de la vivienda
         * @param numHabitaciones determina el numero de habitaciones
         * @param superficie determina la superficie de la vivienda
         * @param parking determina si tiene parking o no
         * @param estado determina el estado en el que se encuentra
         * @param propietario determina el dueño que pertenece la vivienda
         * 
         * */
        
        
        
        
        
        Vivienda casa1 = new Vivienda(120000);
        
        double precio;
        int numHabitaciones;
        double superficie;
        boolean parking;
        String estado;
        String propietario;
        
        
        /*
        *Devuelve los valores de la vivienda
        *@return  valores de la vivienda
        *
        *
        */
        
        
        imprimirVivienda(casa1);
        
        
    }

    private static void imprimirVivienda(Vivienda casa1) {
        System.out.println("Precio: " + casa1.getPrecio());
        System.out.println("Número de habitaciones: "+ casa1.getNumHabitaciones());
        System.out.println("Superficie en m2: " + casa1.getSuperficie());
        System.out.println("¿Dispone de parking?: " + casa1.isParking());
        System.out.println("Estado: "+ casa1.getEstado());
        System.out.println("Propietario: "+ casa1.getPropietario());
    }
    
}
