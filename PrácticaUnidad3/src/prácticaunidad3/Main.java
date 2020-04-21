/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prácticaunidad3;

/**
 *
 * @author ED05
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CCuenta miCuenta;
        double saldoActual;
        
        miCuenta = new CCuenta("Manuel Mantecas","0000-1234-55-123456789",3000,0);
        try 
        {
            miCuenta.retirar(2400);
        } catch (Exception e)
        {
            System.out.print("Fallo al retirar");
        }
        
        try
        {
            System.out.println("Ingreso en cuenta");
            miCuenta.ingresar(695);
        } catch (Exception e)
        {
            System.out.print("Fallo al ingresar");
        }
        saldoActual = miCuenta.getEstado();
        System.out.println("El saldo actual es"+ saldoActual );
    }

}
