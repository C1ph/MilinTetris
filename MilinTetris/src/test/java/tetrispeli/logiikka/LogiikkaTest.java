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
public class LogiikkaTest {
    
    Palikka palikka;
    Ohjaaja ohjaaja;
    Logiikka logiikka;
    
    public LogiikkaTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        palikka = new Palikka(0, 0) {};
    }
    
    @After
    public void tearDown() {
    }

}
