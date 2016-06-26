/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetrispeli.logiikka.Palikka;
import tetrispeli.logiikka.palikkatyypit.Suorapalikka;

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

    @Test
    public void xKoordinaatinAsetusToimii(){
        palikka = new Palikka(0,0) {};
        palikka.setX(10);
        assertEquals(10, palikka.getX());
    }
    
    @Test
    public void yKoordinaatinAsetusToimii(){
        palikka = new Palikka(0,0) {};
        palikka.setY(10);
        assertEquals(10, palikka.getY());
    }
    
    @Test
    public void siirraAlasToimii() {
        palikka = new Palikka(0, 0) {};
        palikka.siirraAlas();
        assertEquals(0, palikka.getX());
        assertEquals(-1, palikka.getY());
    }
    
    @Test
    public void siirraYlosToimii() {
        palikka = new Palikka(0, 0) {};
        palikka.siirraYlos();
        assertEquals(0, palikka.getX());
        assertEquals(1, palikka.getY());
    }
    
    @Test
    public void siirraOikealleToimii() {
        palikka = new Palikka(0, 0) {};
        palikka.siirraOikealle();
        assertEquals(1, palikka.getX());
        assertEquals(0, palikka.getY());
    }
    
    @Test
    public void siirraVasemmalleToimii() {
        palikka = new Palikka(0, 0) {};
        palikka.siirraVasemmalle();
        assertEquals(-1, palikka.getX());
        assertEquals(0, palikka.getY());
    }
}
