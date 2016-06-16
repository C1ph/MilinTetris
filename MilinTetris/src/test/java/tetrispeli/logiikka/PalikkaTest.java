/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import tetrispeli.logiikka.Palikka;
import tetrispeli.logiikka.Suunta;
import static javafx.scene.input.KeyCode.Z;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetrispeli.kayttoliittyma.Ohjaaja;
import tetrispeli.logiikka.palikkatyypit.JPalikka;
import tetrispeli.logiikka.PalikkaArpoja;

/**
 *
 * @author annettek
 */
public class PalikkaTest {

    Palikka palikka;
    Ruudukko ruudukko;
    Ohjaaja ohjaaja;

    public PalikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Ohjaaja ohjaaja;
        Palikka ekaPalikka;
        Palikka tokaPalikka;
        Palikka palikka = new Palikka(0, 0) {
        };
        Ruudukko ruudukko = new Ruudukko(10, 12);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void palikkaOnOikeanMuotoinen() {
        Palikka r = new JPalikka(3, 3);
        boolean[][] uusi = {
            {false, true, false},
            {false, true, false},
            {true, true, false}
        };
        assertArrayEquals(uusi, r.getRuudukko());
    }

    @Test
    public void onkoTyhjaToimiiJosRuudukkoEiOleTyhja() {
        Ruudukko r = new Ruudukko(0, 0);
        assertEquals(true, r.onkoTyhja());
    }

//    @Test
//    public void arvontaToimii() {
//        PalikkaArpoja arpoja = new PalikkaArpoja(0, 0);
//        Palikka numero = arpoja.arvoPalikka();
//    }

    @Test
    public void palikanSiirtoOnnistuu() {
        Osa o = new Osa(1, 1);
        o.siirra(Suunta.OIKEA);
        assertEquals(2, o.getX());
        o.siirra(Suunta.ALAS);
        assertEquals(2, o.getY());
    }
    
//    @Test
//    public void tyhjienPalikoidenPoistoToimii() {
//        JPalikka palikka = new JPalikka(0, 0);
//        boolean[][] tyhjaRuudukko = {
//            {false, false, false},
//            {false, false, false},
//            {false, false, false}
//        };
//        palikka.setRuudukko(tyhjaRuudukko);
//        ohjaaja.lisaaPalikka(palikka);
//        assertEquals(1, ohjaaja.getPalikat().size());
//    }

//    @Test
//    public void tyhjatRivitPoistetaan() {
//        JPalikka palikka = new JPalikka(0, 0);
//        boolean[][] tyhjaRuudukko = {
//            {false, false, false},
//            {false, false, false},
//            {false, false, false}
//        };
//        palikka.setRuudukko(tyhjaRuudukko);
//        ohjaaja.poistaTyhjia();
//        assertEquals(0, ohjaaja.getPalikat().size());
//    }

//    @Test
//    public void siirtoOnnistuu() {
//        ohjaaja.luoPalikka();
//        Palikka palikka = ohjaaja.getAktiivinen();
//        int x = palikka.getX();
//        int y = palikka.getY();
//        ohjaaja.siirraPalikka(Suunta.OIKEA);
//        ohjaaja.siirraPalikka(Suunta.ALAS);
//        assertEquals(x + 1, palikka.getX());
//        assertEquals(y + 1, palikka.getY());
//    }

//    @Test
//    public void uusiPalikkaOnOikeassaPaikassa(){
//        int koko = 10;
//        ohjaaja = new Ohjaaja(koko, 10);
//        ohjaaja.luoPalikka();
//        Palikka palikka = ohjaaja.getAktiivinen();
//        assertEquals(koko / 2 - 2, palikka.getX());
//        assertEquals(0, palikka.getY());
//    }
}
