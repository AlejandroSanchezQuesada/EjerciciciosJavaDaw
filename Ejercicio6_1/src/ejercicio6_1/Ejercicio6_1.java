package ejercicio6_1;

public class Ejercicio6_1 {

    public static void main(String[] args) {
        
        Cuenta alejandro = new Cuenta("Alejandro","154326980",1500);
        
        alejandro.setTitular("Hack3rman");
        alejandro.getTitular();
        alejandro.setNumero("123456hacked");
        alejandro.getNumero();
        alejandro.setSaldo(0);
        alejandro.getSaldo();
        alejandro.incSaldo(2500);
        alejandro.getSaldo( );
        alejandro.decSaldo(1000);
        alejandro.getSaldo();
        
        
        
        
    }
    
}
