package servidoradivina;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorAdivina extends Thread {

    static ServerSocket skServidor = null;
    Socket sCliente = null;
    static int seg = 0;
    static int maxUsers = 0;
    static int numero;
    boolean ganadorFinal = false;

    public ServidorAdivina(Socket sCliente) {

        this.sCliente = sCliente;

    }

    public void run() {
        try {
            DataInputStream dis = new DataInputStream(sCliente.getInputStream());
            DataOutputStream dos = new DataOutputStream(sCliente.getOutputStream());
            int vidas = 5;
            boolean correcto = false;
            //Mensaje de bienvenida servidor
            dos.writeUTF("Bienvenido al servidor");
            //Espera 
            dos.writeUTF("Esperando jugadores durante 30segundos");
            //Cronometro();
            dos.writeUTF("Comienza el juego! Tienes 5 intentos");
            while (vidas > 0 || correcto == true) {
                System.out.println(numero);
                int intento = dis.readInt();
                if (intento == numero && ganadorFinal == false) {
                    dos.writeUTF("Correcto! eres el ganador!");
                    correcto = true;
                    ganadorFinal = true;
                    dos.close();
                    dis.close();
                    

                } else if (intento == numero && ganadorFinal == true) {
                    dos.writeUTF("Era correcto pero ya tenemos otro ganador! :( ");
                    correcto = true;
                    dos.close();
                    dis.close();
                    

                } else if (intento < numero) {
                    dos.writeUTF("Mayor");
                    vidas--;

                } else if (intento > numero) {
                    dos.writeUTF("Menor");
                    vidas--;
                }

            }
            if (vidas <= 0) {
                dos.close();
                dis.close();
                skServidor.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(ServidorAdivina.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int AdivinaNumero() {

        return (int) (Math.random() * 20) + 1;

    }

    public static void Cronometro() {

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                System.out.println("Han pasado " + seg + " segundos");
                seg++;
                if (seg >= 31) {
                    t.cancel();
                    System.out.println("Se cancelo el timer a los 30 segundos");
                }
            }
        }, 1000, 1000);

    }

    public static void main(String[] args) {
        numero = AdivinaNumero();

        try {
            skServidor = new ServerSocket(1234);

        } catch (IOException ex) {
            Logger.getLogger(ServidorAdivina.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {
            try {
                if (maxUsers < 3 && seg < 30) {
                    maxUsers++;
                    Socket sCliente = skServidor.accept();
                    if (maxUsers == 1) {
                        Cronometro();
                    }
                    new ServidorAdivina(sCliente).start();

                }

            } catch (IOException ex) {
                Logger.getLogger(ServidorAdivina.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
