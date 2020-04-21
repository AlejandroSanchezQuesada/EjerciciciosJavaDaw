
import java.util.Scanner;

public class principal {

    public static void main(String[] args) {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        Perro e = new Perro("Rambo", Perro.tipo_raza.PastorAleman, "2019-2-1", 23, "Rambo03");
        Gato g = new Gato("Marie", Gato.tipo_raza.Comun, "2017-4-1", 8, "MarieDNI02");
        Pajaro p = new Pajaro("Cuco", Pajaro.tipo_especie.Agapornis, "2014-3-12", 1, true);
        Reptil r = new Reptil("Raptor", Reptil.tipo_especie.DragonDeComodo, "2013-2-1", 2, false);

        ClinicaVeterinaria torrevieja = new ClinicaVeterinaria();
        torrevieja.ListaAnimales.add(e);
        torrevieja.ListaAnimales.add(g);
        torrevieja.ListaAnimales.add(p);
        torrevieja.ListaAnimales.add(r);

        do {
            System.out.println("Seleccione una opcion");
            System.out.println("1. Inserta Animal \n"
                    + "2. Busca Animal \n"
                    + "3. Modifica Comentario Animal \n"
                    + "4. Muestra la lista de animales \n"
                    + "5. Salir");
            System.out.println("***********************************");

            opcion = sc.nextInt();
            if (opcion == 1) {
                torrevieja.InsertaAnimal();
            } else if (opcion == 2) {
                System.out.println(torrevieja.BuscaAnimal());
            } else if (opcion == 3) {
                torrevieja.ModificaComentarioAnimal();
            } else if (opcion == 4) {
                System.out.println(torrevieja.ListaAnimales.toString());
            }

        } while (opcion != 5);

    }
}
