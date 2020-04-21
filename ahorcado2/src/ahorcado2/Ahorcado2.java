package ahorcado2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Ahorcado2 {
    public static void main(String[] args) {
    //Creacion de array con nombres de las palabras   
    String[ ] palabras = { "vaca", "ordenador", "camion"};
    
    //Declaracion para escoger un numero aleatorio de 0 a 2
    Random aleatorio = new Random();
    int nescogido = aleatorio.nextInt(3);
    //Palabra escogida
    String chosen = palabras[nescogido];
    
    //Declaracion de variables para medir su tamaño
    int tamano;
    tamano = palabras[nescogido].length(); //Cogemos palabra aleatorio y medimos su tamaño
    
    //Numero de vidas 
    int vidas = 5;
    
    //Variables de teclado
    Scanner teclado = new Scanner(System.in);
    String adivinar;
    char letra;
    char letrapalabra;
    //variables varias
    int x,y;
    
    
    //Comienza el programa
        System.out.println("***************************************************************");
    System.out.println("Bienvenido al ahorcado diseñado por Alejandro Sanchez Quesada");
        System.out.println("***************************************************************");
    System.out.println("Comienza el juego adivina la palabra tienes 5 vidas");
        System.out.println("***************************************************************");
        
    //Comienza el bucle del juego
        for(x=0;x<=vidas;vidas--){
        System.out.println("Vidas actuales: "+vidas);
        System.out.println("Introduce una letra, tiene que ser así AA para una A o KK para una K");    
        adivinar = teclado.nextLine();
        
        //StringBuilder sb=new StringBuilder("hola");
        //sb.setCharAt(1, '-');
        //letra = adivinar.charAt(0);
        //Ponemos otro bucle para comprobar caracter por caracter si coincide la palabra
            for(y=0;y<tamano;y++){
                letra = adivinar.charAt(0);
                letrapalabra = chosen.charAt(y);
                
                    if(letra == letrapalabra){
                      System.out.print(letra);}
                    else if(letra != letrapalabra){
                        System.out.print("-");}
            }
        System.out.println("");    
        }
    
    
    
  // System.out.println(letra);    
        
        
    }
    
}
