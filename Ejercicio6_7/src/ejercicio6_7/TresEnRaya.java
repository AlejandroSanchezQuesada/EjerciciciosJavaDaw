package ejercicio6_7;

import java.util.Scanner;

public class TresEnRaya {

    Scanner sc = new Scanner(System.in);
    private int tablero[][] = new int[3][3];

    //Constructor
    public TresEnRaya() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                tablero[x][y] = 0;
            }
        }
    }

    public void MueveJugador() {
        boolean comprobador = false;

        while (comprobador == false) {
            System.out.println("Introduzca posicion fila valor 1 a 3");
            int posX = sc.nextInt() - 1;
            System.out.println("Introduzca posicion columna valor 1 a 3");
            int posY = sc.nextInt() - 1;

            if (tablero[posX][posY] == 0) {
                tablero[posX][posY] = 1;
                comprobador = true;
            } else {
                System.out.println("La posicion está ocupada, vuelva a poner las posiciones");
            }

        }

    }

    public void MueveOrdenador() {
        boolean comprobador = false;

        while (comprobador == false) {
            int posX = (int) ((Math.random() * 3) + 1) - 1;
            int posY = (int) ((Math.random() * 3) + 1) - 1;

            if (tablero[posX][posY] == 0) {
                tablero[posX][posY] = 2;
                comprobador = true;
            }

        }

    }

    public void DibujaTablero() {
        System.out.println("1 2 3");
        System.out.println("=====");
        for (int x = 0; x < 3; x++) {
            int p = x + 1;
            for (int y = 0; y < 3; y++) {
                if (tablero[x][y] == 1) {
                    System.out.print(" X ");
                } else if (tablero[x][y] == 2) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" - ");
                }

            }
            System.out.print("|" + p);
            System.out.println("");

        }

    }

    public boolean GanaJugador() {
        boolean comprobador = false;
        if (tablero[0][0] == 1 && tablero[0][1] == 1 && tablero[0][2] == 1) {
            comprobador = true;
        } else if (tablero[1][0] == 1 && tablero[1][1] == 1 && tablero[1][2] == 1) {
            comprobador = true;
        } else if (tablero[2][0] == 1 && tablero[2][1] == 1 && tablero[2][2] == 1) {
            comprobador = true;
        } else if (tablero[0][0] == 1 && tablero[1][1] == 1 && tablero[2][2] == 1) {
            comprobador = true;
        } else if (tablero[2][0] == 1 && tablero[1][1] == 1 && tablero[0][2] == 1) {
            comprobador = true;
        } else if (tablero[0][0] == 1 && tablero[1][0] == 1 && tablero[2][0] == 1) {
            comprobador = true;
        } else if (tablero[1][0] == 1 && tablero[1][1] == 1 && tablero[1][2] == 1) {
            comprobador = true;
        } else if (tablero[2][0] == 1 && tablero[2][1] == 1 && tablero[2][2] == 1) {
            comprobador = true;
        }

        return comprobador;
    }

    public boolean GanaOrdenador() {
        boolean comprobador = false;
        if (tablero[0][0] == 1 && tablero[0][1] == 1 && tablero[0][2] == 1) {
            comprobador = true;
        } else if (tablero[1][0] == 1 && tablero[1][1] == 1 && tablero[1][2] == 1) {
            comprobador = true;
        } else if (tablero[2][0] == 1 && tablero[2][1] == 1 && tablero[2][2] == 1) {
            comprobador = true;
        } else if (tablero[0][0] == 1 && tablero[1][1] == 1 && tablero[2][2] == 1) {
            comprobador = true;
        } else if (tablero[2][0] == 1 && tablero[1][1] == 1 && tablero[0][2] == 1) {
            comprobador = true;
        } else if (tablero[0][0] == 1 && tablero[1][0] == 1 && tablero[2][0] == 1) {
            comprobador = true;
        } else if (tablero[1][0] == 1 && tablero[1][1] == 1 && tablero[1][2] == 1) {
            comprobador = true;
        } else if (tablero[2][0] == 1 && tablero[2][1] == 1 && tablero[2][2] == 1) {
            comprobador = true;
        }

        return comprobador;

    }

    public boolean QuedanMovimientos() {
        boolean comprobador = false;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (tablero[x][y] == 0) {
                    comprobador = true;
                }
            }
        }
        return comprobador;

    }

}
