/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionMySql;

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
public class ClsConexionMySqlTest {
    
    public ClsConexionMySqlTest() {
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
     * Test of Consulta method, of class ClsConexionMySql.
     */
    @Test
    public void testConsulta() {
        ClsConexionMySql con = new ClsConexionMySql();
        System.out.println("Consulta");
        String Sql = "select * from dia where dia_num_dia = 2";
        String expResult = "2";
        ClsResultSet rec = ClsConexionMySql.Consulta(Sql);
        String result="";
        while (rec.Lee()) {            
            result = rec.Campo(1).toString();
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("Esperado = "+expResult + " Obtenido = "+result);
    }

    /**
     * Test of Transaccion method, of class ClsConexionMySql.
     */
    @Test
    public void testTransaccion() {
        System.out.println("Transaccion");
        String Sql = "insert into dia values (2,'Dia uno',2)";
        boolean expResult = true;
        boolean result = ClsConexionMySql.Transaccion(Sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("Esperado = "+expResult + " Obtenido = "+result);
    }
    @Test
    public void testTransaccionFallida() {
        System.out.println("Transaccion fallida");
        String Sql = "insert into dia values (2,'Dia uno',null)";
        boolean expResult = false;
        boolean result = ClsConexionMySql.Transaccion(Sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("Esperado = "+expResult + " Obtenido = "+result);
    }
}
