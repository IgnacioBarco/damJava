/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nacho
 */
public class TestJUnit {
    
    public TestJUnit() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /**
     * Test de add, de la clase Calculando
     */
    @Test
    public void testAdd() {
        String prueba="Test de add";
        double a = 54d;
        double b = 36d;
        double resultado= a+b;
        double resultadoEsperado = 90d;
        
        Calculando instance = new Calculando();
        instance.add(a,b);
        assertEquals(resultadoEsperado, resultado,0);
        
        if (resultadoEsperado!=resultado){
            fail(prueba+", valores "+a+" y "+b+" : El test ha fallado");
        } else {
            System.out.println(prueba+", valores "+a+" y "+b+" : correcta");
        }
    }
    
    /**
     * Test de subtract, de la clase Calculando
     */
    @Test
    public void testSubstract() {
        String prueba="Test de subtract";
        double a = 25d;
        double b = 35d;
        double resultado= a-b;
        double resultadoEsperado = -10d;
        
        Calculando instance = new Calculando();
        instance.subtract(a,b);
        assertEquals(resultadoEsperado, resultado,0);
        
        if (resultadoEsperado!=resultado){
            fail(prueba+", valores "+a+" y "+b+" : El test ha fallado");
        } else {
            System.out.println(prueba+", valores "+a+" y "+b+" : correcta");
        }
    }
    
    /**
     * Test de multiply, de la clase Calculando
     */
    @Test
    public void testMultiply() {
        String prueba="Test de multiply";
        double a = 5d;
        double b = 7d;
        double resultado= a*b;
        double resultadoEsperado = 35d;
        
        Calculando instance = new Calculando();
        instance.multiply(a,b);
        assertEquals(resultadoEsperado, resultado,0);
        
        if (resultadoEsperado!=resultado){
            fail(prueba+", valores "+a+" y "+b+" : El test ha fallado");
        } else {
            System.out.println(prueba+", valores "+a+" y "+b+" : correcta");
        }
    }
    
    /**
     * Test de divide 01, de la clase Calculando
     */
    @Test
    public void testDivide01() {
        String prueba="Test de divide 01";
        double a = 55d;
        double b = 5d;
        double resultado= a/b;
        double resultadoEsperado = 11d;
        
        Calculando instance = new Calculando();
        instance.divide(a,b);
        assertEquals(resultadoEsperado, resultado,0);
        
        if (resultadoEsperado!=resultado){
            fail(prueba+", valores "+a+" y "+b+" : El test ha fallado");
        } else {
            System.out.println(prueba+", valores "+a+" y "+b+" : correcta");
        }
    }
    /**
     * Test de divide 02, de la clase Calculando
     */
    @Test
    public void testDivide02() {
        String prueba="Test de divide 02";
        double a = 0d;
        double b = 7d;
        double resultado= a/b;
        double resultadoEsperado = 0d;
        
        Calculando instance = new Calculando();
        instance.divide(a,b);
        assertEquals(resultadoEsperado, resultado,0);
        
        if (resultadoEsperado!=resultado){
            fail(prueba+", valores "+a+" y "+b+" : El test ha fallado");
        } else {
            System.out.println(prueba+", valores "+a+" y "+b+" : correcta");
        }
    }
    
    /**
     * Test de divide 01, de la clase Calculando
     */
    @Test
    public void testDivide03() {
        
        try{
            String prueba="Test de divide 03";
            double a = 11d;
            double b = 0d;
            double resultado= a/b;
            double resultadoEsperado = 11d;

            Calculando instance = new Calculando();
            instance.divide(a,b);
            assertEquals(resultadoEsperado, resultado,0);

            if (resultadoEsperado!=resultado){
                fail(prueba+", valores "+a+" y "+b+" : El test ha fallado");
            } else {
                System.out.println(prueba+", valores "+a+" y "+b+" : correcta");
            }
        }catch(AssertionError ex){
            fail("Fallo de la prueba: "+ex);
            
        }
    }
    
}
