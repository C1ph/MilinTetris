/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.kayttoliittyma;

import java.awt.Graphics;
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
public class AlustaTest {
    
    Alusta alusta;
    
    public AlustaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    public void testaaPiirraPalikka() {
        System.out.println("piirraPalikka");
        Palikka piirrettava = null;
        Graphics g = null;
        Alusta instance = null;
        instance.piirraPalikka(piirrettava, g);
    }

    @Test
    public void testaaPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        Alusta instance = null;
        instance.paintComponent(g);
    }

    public class AlustaImpl extends Alusta {

        public AlustaImpl() {
            super(0, null);
        }
    }
    
    
    
}
