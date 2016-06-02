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
public class SPalikka extends Palikka {

    public SPalikka(int x, int y) {
        super(x, y);
        boolean[][] uusi = {
            {false, false, false},
            {false, true, true},
            {true, true, false}
        };
        super.ruudukko = uusi;
    }
}
