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
 * Luokka luo T-muotoisen palikan.
 */
public class TPalikka extends Palikka {

    public TPalikka(int x, int y) {
        super(x, y);
        boolean[][] uusi = {
            { false, true, false },
            { true, true , true },
            { false, false, false }
        };
        super.ruudukko = uusi;
    }   
}