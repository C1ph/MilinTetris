/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.milintetris;

import javax.swing.SwingUtilities;
import tetrispeli.kayttoliittyma.Kayttoliittyma;
import tetrispeli.kayttoliittyma.Ohjaaja;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo tarvittavat komponentit ja käynnistää uuden pelin.
 */
public class Main {
    
    public static void main(String[] args) {   
        Ohjaaja ohjaaja = new Ohjaaja();
        ohjaaja.uusiPeli();
        
    }
}
