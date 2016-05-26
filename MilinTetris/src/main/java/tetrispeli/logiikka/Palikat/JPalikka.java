/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka.Palikat;

import java.awt.Color;
import tetrispeli.logiikka.Palikka;

/**
 *
 * @author annettek
 */
public class JPalikka extends Palikka {
    
    public JPalikka(int x, int y) {
        super(x, y);
        boolean[][] uusi = {
            { false, true, false },
            { false, true , false },
            { true, true, false }
        };
        super.ruudukko = uusi;
    }
}
