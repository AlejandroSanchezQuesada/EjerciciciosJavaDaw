package examen2;

public class NIF {

    private int dni;
    private char letra;
    private char letras[] = {'T', 'R','W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

//Constructor
    public NIF(int dni, char letra) {
        this.dni = dni;
        this.letra = letra;
    }

//Getters y Setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

//Metodos
    public char letraCorrecta() {
        return letras[getDni() % 23];

    }

    public boolean compruebaLetra() {
        char c = letraCorrecta();
        if (c == getLetra()) {
            return true;
        } else {
            return false;
        }

    }

}
