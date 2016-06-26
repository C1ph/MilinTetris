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
import tetrispeli.logiikka.palikkatyypit.JPalikka;

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
    
    public void getKokoAntaaKoonOikein(){
        Palikka j = new JPalikka(3, 3);
        assertEquals(3, palikka.getX());
        assertEquals(3, palikka.getY());
    }

    @Test
    public void palikanluominenOnnistuu() {
        Osa o = new Osa(1, 1);
        assertEquals(1, o.getX());
        assertEquals(1, o.getY());
    }

    @Test
    public void onkoTyhjaToimii(){
        Ruudukko ruudukko = new Ruudukko(10, 12);
        assertTrue(ruudukko.onkoKohtaTyhja(0, 0));
    }
    
    @Test
    public void kierraOikealleToimii() {
        palikka = new Palikka(1, 2) {
        };
        palikka.kierraOikealle();
        assertEquals(1, palikka.getX());
        assertEquals(2, palikka.getY());
    }
    
    @Test
    public void kierraVasemmalleToimii() {
        palikka = new Palikka(0, 0) {
        };
        palikka.kierraVasemmalle(1, 1);
        assertEquals(2, 2, palikka.getX());
        assertEquals(2, 2, palikka.getY());
    }

    @Test
    public void siirtoAlasOnnistuu() {
        palikka = new Palikka(0, 0) {
        };
        int x = palikka.getX();
        int y = palikka.getY();
        palikka.siirraAlas();
        assertEquals(0, palikka.getX());
        assertEquals(-1, palikka.getY());
    }

    @Test
    public void siirtoYlosOnnistuu() {
        palikka = new Palikka(0, 0) {
        };
        int x = palikka.getX();
        int y = palikka.getY();
        palikka.siirraYlos();
        assertEquals(0, palikka.getX());
        assertEquals(1, palikka.getY());
    }

    @Test
    public void siirtoVasemmalleOnnistuu() {
        palikka = new Palikka(0, 0) {
        };
        int x = palikka.getX();
        int y = palikka.getY();
        palikka.siirraVasemmalle();
        assertEquals(-1, palikka.getX());
        assertEquals(0, palikka.getY());
    }

    @Test
    public void siirtoOikealleOnnistuu() {
        palikka = new Palikka(0, 0) {
        };
        palikka.siirraOikealle();
        assertEquals(1, palikka.getX());
        assertEquals(0, palikka.getY());
    }

    @Test
    public void uusiPalikkaOnOikeassaPaikassa() {
        palikka = new Palikka(3, 3) {
        };
        int koko = 10;
        assertEquals(koko / 2 - 2, palikka.getX());
    }

}
