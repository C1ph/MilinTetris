/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka.palikkatyypit;

import tetrispeli.logiikka.Palikka;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo neliön muotoisen palikan.
 */
public class Neliopalikka extends Palikka {

    public Neliopalikka(int x, int y) {
        super(x, y);
        boolean[][] uusi = {
            {true, true},
            {true, true}
        };

        super.ruudukko = uusi;
    }
}
