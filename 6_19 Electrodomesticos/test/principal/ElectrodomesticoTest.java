/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

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
public class ElectrodomesticoTest {
    
    public ElectrodomesticoTest() {
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
     * Test of getPrecio method, of class Electrodomestico.
     */
    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        Electrodomestico instance = new Electrodomestico();
        float expResult = 100;
        float result = instance.getPrecio();
        assertEquals(expResult, result, 100);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecio method, of class Electrodomestico.
     */
    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        float precio = 0.0F;
        Electrodomestico instance = new Electrodomestico();
        instance.setPrecio(precio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class Electrodomestico.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Electrodomestico instance = new Electrodomestico();
        String expResult = "";
        String result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class Electrodomestico.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        String color = "";
        Electrodomestico instance = new Electrodomestico();
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsumoenergetico method, of class Electrodomestico.
     */
    @Test
    public void testGetConsumoenergetico() {
        System.out.println("getConsumoenergetico");
        Electrodomestico instance = new Electrodomestico();
        char expResult = ' ';
        char result = instance.getConsumoenergetico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConsumoenergetico method, of class Electrodomestico.
     */
    @Test
    public void testSetConsumoenergetico() {
        System.out.println("setConsumoenergetico");
        char consumoenergetico = ' ';
        Electrodomestico instance = new Electrodomestico();
        instance.setConsumoenergetico(consumoenergetico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeso method, of class Electrodomestico.
     */
    @Test
    public void testGetPeso() {
        System.out.println("getPeso");
        Electrodomestico instance = new Electrodomestico();
        float expResult = 0.0F;
        float result = instance.getPeso();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPeso method, of class Electrodomestico.
     */
    @Test
    public void testSetPeso() {
        System.out.println("setPeso");
        float peso = 0.0F;
        Electrodomestico instance = new Electrodomestico();
        instance.setPeso(peso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobarConsumoEnergetico method, of class Electrodomestico.
     */
    @Test
    public void testComprobarConsumoEnergetico() {
        System.out.println("comprobarConsumoEnergetico");
        char _letra = ' ';
        Electrodomestico instance = new Electrodomestico();
        instance.comprobarConsumoEnergetico(_letra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobarColor method, of class Electrodomestico.
     */
    @Test
    public void testComprobarColor() {
        System.out.println("comprobarColor");
        String _color = "";
        Electrodomestico instance = new Electrodomestico();
        instance.comprobarColor(_color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of precioFinal method, of class Electrodomestico.
     */
    @Test
    public void testPrecioFinal() {
        System.out.println("precioFinal");
        Electrodomestico instance = new Electrodomestico();
        float expResult = 0.0F;
        float result = instance.precioFinal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Electrodomestico.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Electrodomestico instance = new Electrodomestico();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
