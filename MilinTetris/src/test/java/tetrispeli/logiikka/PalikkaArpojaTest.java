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
import tetrispeli.logiikka.palikkatyypit.TPalikka;

/**
 *
 * @author annettek
 */
public class PalikkaArpojaTest {

    PalikkaArpoja arpoja;

    public PalikkaArpojaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        PalikkaArpoja arpoja = new PalikkaArpoja(0, 0);
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void TPalikanArvontaOikein() {
//        TPalikka t = new TPalikka(0, 0);
//        Palikka arvottu = arpoja.arvoPalikka();
//        assertEquals(t, arvottu);
//    }
    
//    @Test
//    public void arvontaToimii() {
//        PalikkaArpoja arpoja = new PalikkaArpoja(0, 0);
//        Palikka numero = arpoja.arvoPalikka();
//    }
}
