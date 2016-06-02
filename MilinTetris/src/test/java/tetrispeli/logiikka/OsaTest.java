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
import tetrispeli.logiikka.Palikka;

/**
 *
 * @author annettek
 */
public class OsaTest {
    
    Palikka palikka;
    Osa osa;
    Ruudukko ruudukko;
    
    public OsaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Palikka palikka = new Palikka(0, 0) {};
        Ruudukko ruudukko = new Ruudukko(10, 12);
    }
    
    @After
    public void tearDown() {
    }

}
