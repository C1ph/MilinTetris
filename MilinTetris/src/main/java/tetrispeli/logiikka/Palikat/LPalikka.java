/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka.Palikat;

import tetrispeli.logiikka.Palikka;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo L-muotoisen palikan.
 */
public class LPalikka extends Palikka {

    public LPalikka(int x, int y) {
        super(x, y);
        boolean[][] uusi = {
            {false, true, false},
            {false, true, false},
            {false, true, true}
        };
        super.ruudukko = uusi;
    }
}
