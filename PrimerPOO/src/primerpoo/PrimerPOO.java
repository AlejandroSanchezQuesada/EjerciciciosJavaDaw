package primerpoo;

public class PrimerPOO {

    public static void main(String[] args) {
        int turno = 0; //empieza pikachu

        Pokemon pikachu = new Pokemon("pikachu", 3, 3);
        Pokemon charmander = new Pokemon();

        //Comienza el juego
        while (pikachu.getVida() > 0 && charmander.getVida() > 0) {
            if (turno == 0) {
                System.out.println("Turno de Pikachu!");
                charmander.setVida(charmander.getVida() - pikachu.getAtaque());
                System.out.println("La vida restante de Charmander es " + charmander.getVida());
                turno = 1;
            } else {
                System.out.println("Turno de Charmander!");
                pikachu.setVida(pikachu.getVida() - charmander.getAtaque());
                System.out.println("La vida restante de Pikachu es " + pikachu.getVida());
                turno = 0;
            }
            System.out.println("Fin del turno " + turno);
            if (pikachu.getVida()<= 0) {
                System.out.println("CHARMANDER ES EL GANADOR");
            }
            else if(charmander.getVida()<= 0) {
                System.out.println("PIKACHU ES EL GANADOR");
            }

        }

    }

}
