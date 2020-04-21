/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formasexamen;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexk
 */
public class CuadradoTest {
    
    public CuadradoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLado method, of class Cuadrado.
     */
    @Test
    public void testGetLado() {
        System.out.println("getLado");
        Cuadrado instance = new Cuadrado();
        instance.setLado(0);
        int expResult = 0;
        int result = instance.getLado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(expResult+" "+result);
    }

    /**
     * Test of setLado method, of class Cuadrado.
     */
    @Test
    public void testSetLado() {
        System.out.println("setLado");
        int lado = 2;
        Cuadrado instance = new Cuadrado();
        instance.setLado(lado);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of toString method, of class Cuadrado.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Cuadrado instance = new Cuadrado();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mover method, of class Cuadrado.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        int _x = 0;
        int _y = 0;
        Cuadrado instance = new Cuadrado();
        instance.mover(_x, _y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
