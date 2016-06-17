/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.awt.Color;
import tetrispeli.logiikka.Palikka;
import tetrispeli.logiikka.Ruudukko;
import java.util.*;
import static tetrispeli.logiikka.Suunta.ALAS;
import static tetrispeli.logiikka.Suunta.OIKEA;
import static tetrispeli.logiikka.Suunta.VASEN;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo osan, joista palikka koostuu.
 */
public class Osa {

    private int x;
    private int y;

    public Osa(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void siirraAlas() {
        this.y = this.y + 1;
    }
    
    public void siirraYlos() {
        this.y = this.y - 1;
    }
    
    public void siirraVasemmalle() {
        this.x = this.x - 1;
    }
    
    public void siirraOikealle() {
        this.x = this.x + 1;
    }
}
