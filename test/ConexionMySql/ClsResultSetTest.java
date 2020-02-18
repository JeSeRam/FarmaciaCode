/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionMySql;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Freak
 */
public class ClsResultSetTest {
    
    public ClsResultSetTest() {
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
     * Test of AsignaRsultSet method, of class ClsResultSet.
     */
    @Test
    public void testAsignaRsultSet() {
        System.out.println("AsignaRsultSet");
        ResultSet Rec = null;
        ClsResultSet instance = new ClsResultSet();
        instance.AsignaRsultSet(Rec);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Lee method, of class ClsResultSet.
     */
    @Test
    public void testLee() {
        System.out.println("Lee");
        boolean expResult = false;
        ClsResultSet instance = new ClsResultSet();
        boolean result = instance.Lee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TieneRegistros method, of class ClsResultSet.
     */
    @Test
    public void testTieneRegistros() {
        System.out.println("TieneRegistros");
        boolean expResult = false;
        ClsResultSet instance = new ClsResultSet();
        boolean result = instance.TieneRegistros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Campo method, of class ClsResultSet.
     */
    @Test
    public void testCampo_int() {
        System.out.println("Campo");
        int NumeroDeCampo = 0;
        Object expResult = null;
        ClsResultSet instance = new ClsResultSet();
        Object result = instance.Campo(NumeroDeCampo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Campo method, of class ClsResultSet.
     */
    @Test
    public void testCampo_String() {
        System.out.println("Campo");
        String NombreDelCampo = "";
        Object expResult = null;
        ClsResultSet instance = new ClsResultSet();
        Object result = instance.Campo(NombreDelCampo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CampoNumerico method, of class ClsResultSet.
     */
    @Test
    public void testCampoNumerico_int() {
        System.out.println("CampoNumerico");
        int NumeroDeCampo = 0;
        Object expResult = null;
        ClsResultSet instance = new ClsResultSet();
        Object result = instance.CampoNumerico(NumeroDeCampo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CampoNumerico method, of class ClsResultSet.
     */
    @Test
    public void testCampoNumerico_String() {
        System.out.println("CampoNumerico");
        String NombreDelCampo = "";
        Object expResult = null;
        ClsResultSet instance = new ClsResultSet();
        Object result = instance.CampoNumerico(NombreDelCampo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CampoFecha method, of class ClsResultSet.
     */
    @Test
    public void testCampoFecha_int() {
        System.out.println("CampoFecha");
        int NumeroDeCampo = 0;
        Object expResult = null;
        ClsResultSet instance = new ClsResultSet();
        Object result = instance.CampoFecha(NumeroDeCampo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CampoFecha method, of class ClsResultSet.
     */
    @Test
    public void testCampoFecha_String() {
        System.out.println("CampoFecha");
        String NombreDelCampo = "";
        Object expResult = null;
        ClsResultSet instance = new ClsResultSet();
        Object result = instance.CampoFecha(NombreDelCampo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
