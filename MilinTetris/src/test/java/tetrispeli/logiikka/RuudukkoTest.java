/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.util.ArrayList;
import tetrispeli.logiikka.Palikka;
import tetrispeli.logiikka.Ruudukko;
import tetrispeli.logiikka.Suunta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetrispeli.logiikka.Palikat.Neliopalikka;

/**
 *
 * @author annettek
 */
public class RuudukkoTest {

    Ruudukko ruudukko;
    Palikka palikka;

    public RuudukkoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ruudukko = new Ruudukko(0, 0);
        palikka = new Palikka(0, 0);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void uusiRuudukkoOnTyhja() {
        assertEquals(-1, ruudukko.palautaRivi());
    }

    @Test
    public void palautusToimii() {
        assertEquals(ruudukko.palautaRivi(), -1);
    }
    
    @Test
    public void ruudukkoLuodaanOikein(){
        assertTrue(ruudukko != null);
    }

    @Test
    public void leveysAsetetaanOikein() {
        ruudukko = new Ruudukko(4, 6);
        assertEquals(ruudukko.getLeveys(), 4);
    }

    @Test
    public void korkeusAsetetaanOikein() {
        ruudukko = new Ruudukko(4, 6);
        assertEquals(ruudukko.getKorkeus(), 6);
    }
    
    @Test
    public void tyhjennaMetodiToimii(){
        ArrayList<Palikka> palikat = new ArrayList<>();
        palikat.add(new Neliopalikka(0,4));
        ruudukko.tyhjennaRuudukko();
        assertEquals(-1, ruudukko.palautaRivi());
    }
}
