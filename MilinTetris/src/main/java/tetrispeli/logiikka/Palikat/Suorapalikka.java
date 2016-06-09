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
 * Luokka luo suoran palikan.
 */
public class Suorapalikka extends Palikka {

    public Suorapalikka(int x, int y) {
        super(x, y);
        boolean[][] uusiRuudukko = {
            {false, true, false, false},
            {false, true, false, false},
            {false, true, false, false},
            {false, true, false, false}
        };
        super.ruudukko = uusiRuudukko;
    }
}