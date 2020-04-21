package ejercicio6_2;

import java.util.Scanner;

public class Ejercicio6_2 {

    public static void main(String[] args) {
        String nombre;
        int edad;
        char sexo;
        double peso;
        double altura;
        Scanner sc = new Scanner(System.in);

        //Persona 1
        Persona alejandro = new Persona();
        System.out.println("Nombre de persona");
        alejandro.setNombre(nombre = sc.nextLine());
        System.out.println("Edad de persona");
        alejandro.setEdad(edad = sc.nextInt());
        sc.nextLine();
        System.out.println("Sexo de persona");
        alejandro.setSexo(sexo = sc.nextLine().charAt(0));
        System.out.println("Peso de Persona");
        alejandro.setPeso(peso = sc.nextDouble());
        System.out.println("Altura");
        alejandro.setAltura(altura = sc.nextDouble());
        sc.nextLine();
        //Persona 2 

        Persona jose = new Persona();
        System.out.println("Nombre de persona");

        jose.setNombre(nombre = sc.nextLine());
        sc.nextLine();
        System.out.println("Edad de persona");
        jose.setEdad(edad = sc.nextInt());
        System.out.println("pulsa intro bug hay un bug de buffer ignora esta linea");
        sc.nextLine();
        System.out.println("Sexo de persona");
        jose.setSexo(sexo = sc.nextLine().charAt(0));

        //Persona 3
        Persona mathi = new Persona();

        //Calculos de IMC
        System.out.println(alejandro.CalculaIMC());
        System.out.println(jose.CalculaIMC());
        System.out.println(mathi.CalculaIMC());

        //Mayores de edad
        System.out.println(alejandro.EsMayorDeEdad());
        System.out.println(jose.EsMayorDeEdad());
        System.out.println(mathi.EsMayorDeEdad());

        //Informacion total de las personas
        System.out.println(alejandro.toString2());
        System.out.println(jose.toString2());
        System.out.println(mathi.toString2());

    }

}
