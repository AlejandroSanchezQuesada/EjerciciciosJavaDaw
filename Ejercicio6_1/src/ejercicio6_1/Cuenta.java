package ejercicio6_1;

public class Cuenta {

    String titular;
    String numero;
    float saldo;

    public Cuenta(String _titular, String _numero, float _saldo) {
        titular = _titular;
        numero = _numero;
        saldo = _saldo;
    }

    public Cuenta(Cuenta c) {
        this(c.titular, c.numero, c.saldo);
    }

    public void setCuenta(String nombre, String number, float s) {
        titular = nombre;
        numero = number;
        saldo = s;
    }

    public void setCuenta(Cuenta c) {
        setCuenta(c.titular, c.numero, c.saldo);
    }

    public String toString() {
        return "\nTitular: " + titular + "\nNúmero: " + numero + "\nSaldo:" + saldo;
    }

    public String setTitular(String titular) {
        this.titular = titular;
        return titular;
    }

    public void getTitular() {
        System.out.println("Nombre de titular " + this.titular);

    }

    public String setNumero(String numero) {
        this.numero = numero;
        return numero;
    }

    public void getNumero() {
        System.out.println("Numero de cuenta " + this.numero);
    }

    public float setSaldo(float saldo) {
        this.saldo = saldo;
        return saldo;
    }

    public void getSaldo() {
        System.out.println("Saldo de la cuenta " + this.saldo);
    }

    public float incSaldo(float inc) {
        this.saldo = this.saldo + inc;
        return this.saldo;
    }

    public float decSaldo(float dec) {
        this.saldo = this.saldo - dec;
        return this.saldo;
    }

}
