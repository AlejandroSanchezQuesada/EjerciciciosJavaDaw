
public class CuentaBancaria {
    
    private String numero;
    private double saldo;

    public CuentaBancaria(String numero, double saldo) {

        this.numero = numero;
        this.saldo = saldo;

    }

    public String getNumero() {

        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setIngreso(double cantidad) {
        this.saldo+= cantidad;

    }

    public boolean setReintegro(double cantidad) {
        boolean reintegro = false;
        if (this.saldo - cantidad >= 0) {
            this.saldo = this.saldo - cantidad;
            reintegro = true;
        }else{System.out.println("Saldo Insuficiente para reintegro");}

        return reintegro;
    }

    public String toString2() {
        String datos = "Numero de cuenta: " + getNumero() + " cantidad de dinero: " + getSaldo() + " €\n";
        return datos;
}}
