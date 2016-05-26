/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import tetrispeli.logiikka.Palikka;
import tetrispeli.logiikka.Ruudukko;
import tetrispeli.logiikka.Suunta;
import static javafx.scene.input.KeyCode.Z;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetrispeli.logiikka.Palikat.JPalikka;

/**
 *
 * @author annettek
 */
public class PalikkaTest {

    Palikka palikka;
    Ruudukko ruudukko;

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
        Palikka palikka = new Palikka(0, 0);
        Ruudukko ruudukko = new Ruudukko(10, 12);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void palikkaOnOikeanMuotoinen() {
        palikka = new JPalikka(0, 0);
        boolean[][] uusi = {
            {false, true, false},
            {false, true, false},
            {true, true, false}
        };
        assertArrayEquals(uusi, palikka.getRuudukko());
    }

    @Test
    public void onkoTyhjaToimiiJosPalikkaEiOleTyhja() {
        palikka = new JPalikka(0, 0);
        assertFalse(palikka.onkoTyhja());
    }

    @Test
    public void palikanSiirtoOnnistuu() {
        palikka = new JPalikka(0, 0);
        palikka.siirra(Suunta.OIKEA);
        assertEquals(1, palikka.getX());
        palikka.siirra(Suunta.ALAS);
        assertEquals(1, palikka.getY());
    }

    @Test
    public void arvontaToimii() {
        palikka = new JPalikka(0, 0);
        int[][] numero = palikka.arvoPalikka();
    }
    

}
