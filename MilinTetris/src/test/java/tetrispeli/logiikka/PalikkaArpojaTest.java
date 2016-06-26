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
    Palikka palikka;
    Logiikka logiikka;

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
        PalikkaArpoja arpoja = new PalikkaArpoja(10);
        Palikka p = new Palikka(0, 0) {};
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void PalikanArvontaOikein() {
//        PalikkaArpoja arpoja = new PalikkaArpoja(0);
//        Palikka arvottu = arpoja.arvoPalikka();
//        
//    }
}
