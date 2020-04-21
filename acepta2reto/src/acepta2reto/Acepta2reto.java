package acepta2reto;

import java.util.Scanner;

public class Acepta2reto {

    public static void main(String[] args) {
        int participantes;
        int rondas = 3;
        int posparticipante = 0;
        int possecond = 0;
        float mejor = 0;
        float segundomejor = 0;
        float puntuaciones;

        Scanner sc = new Scanner(System.in);

        do {
            participantes = sc.nextInt();
            String tablaparticipantes[] = new String[participantes];
            float tablapuntuaciones[][] = new float[rondas][participantes];
            for (int i = 0; i < participantes; i++) {
                String persona = sc.next();
                tablaparticipantes[i] = persona;
            }
            for (int y = 0; y < rondas; y++) {
                for (int x = 0; x < participantes; x++) {
                    puntuaciones = (float) (Math.random() * 100) + 1;
                    tablapuntuaciones[y][x] = puntuaciones;
                }

            }
            
            for (int y = 0; y < rondas; y++) {
                for (int x = 0; x < participantes; x++) {
                    if (tablapuntuaciones[y][x] > mejor) {
                        mejor = tablapuntuaciones[y][x];
                        posparticipante = x;
                    }
                }
            }
            
            for (int y = 0; y < rondas; y++) {
                for (int x = 0; x < participantes; x++) {
                    if (participantes == posparticipante) {
                        x++;
                    }
                    if (tablapuntuaciones[y][x] > segundomejor) {
                        segundomejor = tablapuntuaciones[y][x];
                        possecond = x;
                    }
{
                    
                    
                    
                    
                    
                    
                    }
                }
            }
            
            

            for (int y = 0; y < rondas; y++) {
                for (int x = 0; x < participantes; x++) {
                    System.out.print(tablapuntuaciones[y][x] + " ");
                }
                System.out.println("");
            }
            
            
            System.out.println("La mejor puntuacion es "+mejor+" y el ganador es "+tablaparticipantes[posparticipante]);
            System.out.println("La segunda mejor puntuacion es "+segundomejor+" y el segundo es "+tablaparticipantes[possecond]);

        } while (participantes == 0);

    }

}
