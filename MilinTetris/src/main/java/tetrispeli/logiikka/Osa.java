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
    private Osa osa;
    private Suunta suunta;
    private ArrayList<Osa> osat;

    public Osa(int x, int y) {
        this.x = x;
        this.y = y;
        this.osat = osat;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public ArrayList<Osa> getOsat(int x, int y) {
        return osat;
    }
    
    public ArrayList<Osa> setOsat(int x, int y) {
        this.osat = osat;
        return osat;
    }

    public void siirra(int x, int y) {
        if (suunta == Suunta.OIKEA) {
            x += 1;
        } else if (suunta == Suunta.ALAS) {
            y += 1;
        } else if (suunta == Suunta.VASEN) {
            x -= 1;
        }
    }
    
    public void kaannaVasemmalle() {
        int uusiX = this.osa.getX();
        int uusiY = this.osa.getY();
        if (this.suunta == OIKEA) {
            uusiY -= 1;
        } else if (this.suunta == VASEN) {
            this.suunta = ALAS;
            uusiY += 1;
        } else if (this.suunta == ALAS) {
            this.suunta = VASEN;
            uusiX -= 1;
        } else {
            this.suunta = OIKEA;
            uusiX++;
        }      
        siirra(uusiX, uusiY);
    }
}
