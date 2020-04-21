package bloque40;

public class Bloque40 {

    public static void main(String[] args) {
        int max = 100;
        int min = 0;
        int rango = max - min + 1;
        int arraynumeros[] = new int[5];
        int sumapositivos = 0;
        int sumanegativos = 0;
        int sumatotal = 0;
        int contadorpositivos=0;
        int contadornegativos=0;

        for (int x = 0; x < arraynumeros.length; x++) {

            int aleatorio = (int) (Math.random() * rango) + min;

            arraynumeros[x] = aleatorio;
            System.out.print(arraynumeros[x] + " ");

        }
        for (int y = 0; y < arraynumeros.length; y++) {
            if (arraynumeros[y] > 0) {
                sumapositivos = sumapositivos + arraynumeros[y];
                contadorpositivos++;    
            }
            if (arraynumeros[y] < 0) {
                sumanegativos = sumanegativos + arraynumeros[y];
                contadornegativos++;
            }

            sumatotal = sumatotal + arraynumeros[y];

        }
        System.out.println("");
        System.out.println("MEDIA DE NUMEROS, POSTIVIOS, NEGATIVOS, TOTAL");
        System.out.println(sumapositivos/contadorpositivos);
        System.out.println(sumanegativos/contadornegativos);
        System.out.println(sumatotal);

    }

}
