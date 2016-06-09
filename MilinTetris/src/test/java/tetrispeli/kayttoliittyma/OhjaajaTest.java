/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.kayttoliittyma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetrispeli.logiikka.Palikat.JPalikka;
import tetrispeli.logiikka.Palikka;
import tetrispeli.logiikka.Suunta;

/**
 *
 * @author annettek
 */
public class OhjaajaTest {

    private Ohjaaja ohjaaja;
    private Palikka ekaPalikka;
    private Palikka tokaPalikka;

    public OhjaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ohjaaja = new Ohjaaja(15, 20);
        ekaPalikka = new JPalikka(0, 0);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tyhjienPalikoidenPoistoToimii() {
        JPalikka palikka = new JPalikka(0, 0);
        boolean[][] tyhjaRuudukko = {
            {false, false, false},
            {false, false, false},
            {false, false, false}
        };
        palikka.setRuudukko(tyhjaRuudukko);
        ohjaaja.lisaaPalikka(palikka);
        assertEquals(1, ohjaaja.getPalikat().size());
    }

    @Test
    public void tyhjatRivitPoistetaan() {
        JPalikka palikka = new JPalikka(0, 0);
        boolean[][] tyhjaRuudukko = {
            {false, false, false},
            {false, false, false},
            {false, false, false}
        };
        palikka.setRuudukko(tyhjaRuudukko);
        ohjaaja.poistaTyhjia();
        assertEquals(0, ohjaaja.getPalikat().size());
    }

    @Test
    public void siirtoOnnistuu() {
        ohjaaja.luoPalikka();
        Palikka palikka = ohjaaja.getAktiivinen();
        int x = palikka.getX();
        int y = palikka.getY();
        ohjaaja.siirraPalikka(Suunta.OIKEA);
        ohjaaja.siirraPalikka(Suunta.ALAS);
        assertEquals(x + 1, palikka.getX());
        assertEquals(y + 1, palikka.getY());
    }

    @Test
    public void uusiPalikkaOnOikeassaPaikassa(){
        int koko = 10;
        ohjaaja = new Ohjaaja(koko, 10);
        ohjaaja.luoPalikka();
        Palikka palikka = ohjaaja.getAktiivinen();
        assertEquals(koko / 2 - 2, palikka.getX());
        assertEquals(0, palikka.getY());
    }
}
