/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import tetrispeli.logiikka.Suunta;
import static javafx.scene.input.KeyCode.Z;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omistaja
 */
public class PalikkaTest {
    
    private Palikka palikka;
    private Ruudukko ruudukko;
    
    public PalikkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Palikka palikka = new Palikka(0, 0);
        Ruudukko ruudukko = new Ruudukko(8, 10);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void palikanMuotoAsetetaanOikein (){
        palikka = new Palikka(0,0);
        boolean[][] expected = {
            { false, true, false },
            { false, true , false },
            { true, true, false }
        };
        assertArrayEquals(expected, palikka.getRuudukko());
    }
}
