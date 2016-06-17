/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetrispeli.kayttoliittyma.Ohjaaja;

/**
 *
 * @author annettek
 */
public class AjastinTest {
    
    Ohjaaja ohjaaja;
    Ajastin ajastin;
    
    public AjastinTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ohjaaja = new Ohjaaja();
        ajastin = new Ajastin(ohjaaja) {};
    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void ajastinAsettaaViiveenOikein(){
//        ajastin.paivita();
//        assertEquals(1000, ajastin.getDelay());
//        
//    }
    
    @Test
    public void AjastinOnAluksiNolla(){
        assertEquals(ajastin.toString(), "00:00:00");
    }
}
