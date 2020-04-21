package ejercicio6_4;

public class Ejercicio6_4 {

    public static void main(String[] args) {

        Cliente Juan = new Cliente("Juan Martinez", "22.355.658-F");
        Cliente Pedro = new Cliente("Pedro Garrigos", "36.258.957-R");

        CuentaBancaria c1 = new CuentaBancaria("01234567890123456789", 250);
        CuentaBancaria c2 = new CuentaBancaria("98765432109876543210", 22500);

        CuentaBancaria c3 = new CuentaBancaria("65498732109873216540", 1200);
        CuentaBancaria c4 = new CuentaBancaria("78965412307896541230", 15000);
        CuentaBancaria c5 = new CuentaBancaria("45698712300321456987", 350);

        Juan.NuevaCuenta(c1);
        Juan.NuevaCuenta(c2);
        Pedro.NuevaCuenta(c3);
        Pedro.NuevaCuenta(c4);
        Pedro.NuevaCuenta(c5);

        System.out.println("Ingreso 50 en c1");
        c1.setIngreso(50);
        System.out.println("Reintegro de 60  en c1");
        c1.setReintegro(60);
        
        
        System.out.println("Reintegro de 16000 en c4");
        c4.setReintegro(16000);
        
        
        System.out.println(Juan.toString2());
        System.out.println(Pedro.toString2());

    }

}
