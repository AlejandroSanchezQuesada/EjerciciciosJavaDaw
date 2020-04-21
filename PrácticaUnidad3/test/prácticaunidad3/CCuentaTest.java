/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prácticaunidad3;

import junit.framework.TestCase;

/**
 *
 * @author alexk
 */
public class CCuentaTest extends TestCase {
    
    public CCuentaTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of setNombre method, of class CCuenta.
     */
    

    /**
     * Test of ingresar method, of class CCuenta.
     */   /*
     public void testIngresar() throws Exception {
        System.out.println("ingresar");
        double cantidad = 550;
        double resultadoEsperado = cantidad;
        CCuenta instance = new CCuenta();
        instance.ingresar(cantidad);
        double resultadoREAL = instance.getEstado();
        assertEquals(resultadoEsperado, resultadoREAL);
    } */

    /**
     * Test of retirar method, of class CCuenta.
     */
    public void testRetirarIngresar() throws Exception {
        System.out.println("Ingresar y Retirar");
        double cantidad = 500;
        double resultadoEsperadoRetirar = 100;
        double resultadoEsperadoIngreso = 550;
        CCuenta instance = new CCuenta();
        instance.ingresar(cantidad);
        instance.ingresar(50);
        
        assertEquals(instance.getEstado(),resultadoEsperadoIngreso);
        instance.retirar(200);
        instance.retirar(200);
        instance.retirar(50);
        
        assertEquals(instance.getEstado(),resultadoEsperadoRetirar);
        
        
        
    }

    /**
     * Test of getCuenta method, of class CCuenta.
     */
   
    
}
