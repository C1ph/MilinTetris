/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka.palikkatyypit;

import java.awt.Color;
import tetrispeli.logiikka.Osa;
import tetrispeli.logiikka.Palikka;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo J-muotoisen palikan.
 */
public class JPalikka extends Palikka {
    
    public JPalikka(int x, int y) {
        super(x, y);
        super.getOsat().add(new Osa(0,0));
        super.getOsat().add(new Osa(-1,0));
        super.getOsat().add(new Osa(0,1));
        super.getOsat().add(new Osa(0,2));
    }
}

