package herenciafigura;

public class Cuadrado extends Figura {

    private int ladoMenor;
    private int ladoMayor;

    public Cuadrado(int ladoMenor, int ladoMayor) {
        this.ladoMenor = ladoMenor;
        this.ladoMayor = ladoMayor;
    }

    public int getArea() {

        return ladoMenor * ladoMayor;

    }

}
