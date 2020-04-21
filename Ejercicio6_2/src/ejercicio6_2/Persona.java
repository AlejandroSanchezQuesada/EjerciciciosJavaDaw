package ejercicio6_2;

import java.util.Random;

public class Persona {

    //Variables
    String nombre;
    int edad;
    String dni;
    char sexo;
    double peso;
    double altura;
    double IMC;
    boolean mayor;

    final char hombre = 'H';
    final char mujer = 'M';

    //Setters y Getters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;

    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public char getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    //Constructores
    public Persona() {
        //Estos son los valores por defecto
        nombre = "";
        edad = 0;
        dni = "";
        sexo = hombre;

    }

    public Persona(String nombre, int edad, char sexo) {

        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;

    }

    public Persona(String nombre, int edad, String dni, char sexo, int peso, int altura) {

        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;

    }

    public String toString2() {
        String informacion = "Nombre : " + nombre + "\n edad : " + edad + "\n dni : " + dni + "\n sexo : " + sexo + "\n peso : " + peso + "\n altura : " + altura;

        return informacion;
    }

    public int CalculaIMC() {
        int resultado = 0;
        IMC = (peso) / (altura * altura);
        if (IMC < 18.5) {
            resultado = -1;
        } else if (IMC > 18.5 && IMC < 24.9) {
            resultado = 0;
        } else if (IMC > 24.9) {
            resultado = 1;
        }

        return resultado;

    }

    public boolean EsMayorDeEdad() {

        if (edad >= 18) {
            mayor = true;
        } else {
            mayor = false;
        }

        return mayor;
    }

    private void comprobarSexo(char sexo) {
        if (this.sexo != 'H' && this.sexo != 'M') {
            this.sexo = 'H';
        }

    }

    public String GeneraDni() {
        String letra;
        Random aleatorio = new Random();
        String cadena = "";

        int b[] = new int[8];

        for (int i = 0; i < b.length; i++) {
            b[i] = aleatorio.nextInt(9);
        }
        for (int i = 0; i < b.length; i++) {
            cadena = cadena + b[i];
        }
        int cadenanumero = Integer.parseInt(cadena);
        char a[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resultado = cadenanumero % 23;
        letra = cadenanumero + "" + a[resultado];
        dni = letra;
        return letra;

    }

}
