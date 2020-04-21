package ejercicio6_12;

import java.util.Scanner;

public class Hora {

    private int hora;
    private int minutos;
    private int segundos;
    Scanner sc = new Scanner(System.in);

    //Constructores
    public Hora() {
        hora = 00;
        minutos = 00;
        segundos = 00;

    }

    public Hora(int _hora, int _minutos, int _segundos) {
        hora = _hora;
        minutos = _minutos;
        segundos = _segundos;

    }

    //Getters y Setters
    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setHora(int _hora) {
        hora = _hora;
    }

    public void setMinutos(int _minutos) {
        minutos = _minutos;
    }

    public void setSegundos(int _segundos) {
        segundos = _segundos;
    }

    //Metodos
    public void Leer() {
        boolean comprobador = false;
        int contador = 0;
        try {

            do {
                System.out.println("Dime la hora");
                int _hora = sc.nextInt();
                if (_hora >= 0 && _hora <= 23) {
                    contador++;
                } else {
                    contador = 0;
                }

                System.out.println("Dime los minutos");
                int _minutos = sc.nextInt();
                if (_minutos >= 0 && _minutos <= 59) {
                    contador++;
                } else {
                    contador = 0;
                }

                System.out.println("Dime los segundos");
                int _segundos = sc.nextInt();
                if (_segundos >= 0 && _segundos <= 59) {
                    contador++;
                } else {
                    contador = 0;
                }

                if (contador == 3) {
                    comprobador = true;
                    hora = _hora;
                    minutos = _minutos;
                    segundos = _segundos;
                    System.out.println("Horas minutos y segundos puestos correctamente");

                } else {
                    System.out.println("Ha habido un fallo al introducir los datos vuelve a intentarlo.");
                }

            } while (comprobador == false);

        } catch (Exception InputMismatchException) {
            System.out.println("Algun dato erroneo");

        }

    }//Fin metodo leer

    public int aSegundos(int _hora, int _minutos, int _segundos) {
        int horasegundos = _hora * 3600;
        int horasminutos = _minutos * 60;
        int total = horasegundos + horasminutos + _segundos;

        return total;

    }

    public void deSegundos(int _segundos) {
        int _minutos = 0;
        int _horas = 0;
        while (_segundos > 60) {
            _segundos = _segundos - 60;
            _minutos++;
        }
        while (_minutos > 60) {
            _minutos = _minutos - 60;
            _horas++;
        }
        hora = _horas;
        minutos = _minutos;
        segundos = _segundos;

    }

    public int segundosDesde(int _hora, int _minutos, int _segundos) {
        int a = aSegundos(hora, minutos, segundos);
        int b = aSegundos(_hora, _minutos, _segundos);

        int total = a - b;
        return Math.abs(total);

    }

    public void siguiente() {
        segundos = segundos + 1;
        if (segundos > 59) {
            segundos = 0;
            minutos++;
        }
        if (minutos > 59) {
            minutos = 0;
            hora++;
        }
    }

    public void anterior() {
        segundos = segundos - 1;

        if (segundos < 0) {
            segundos = 59;
            minutos--;
        }
        if (minutos < 0 && hora > 0) {
            minutos = 59;
            hora--;
        }

    }

    public boolean igualQue(int _hora, int _minutos, int _segundos) {
        return hora == _hora && minutos == _minutos && segundos == _segundos;

    }

    public String toString2() {
        String texto = hora + ":" + minutos + ":" + segundos;
        return texto;

    }

}
