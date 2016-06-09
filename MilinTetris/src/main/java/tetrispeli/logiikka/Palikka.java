/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.util.Random;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo abstraktin Palikka-käsitteen.
 */
public abstract class Palikka {

    public Osa[] osat;
    public boolean[][] ruudukko;
    private int x;
    private int y;
    

    public Palikka(int x, int y) {
        this.osat = osat;
        this.ruudukko = ruudukko;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void siirra(Suunta suunta) {
        for (Osa o : osat) {
            o.siirra(suunta);
        }
    }
    
    public void setRuudukko(boolean[][] kaannos) {
        
    }

    public boolean[][] getRuudukko() {
        return ruudukko;
    }
    // globaalit ja lokaalit paras tapa!
    // matriisikertolasku-taulukon teko

    public boolean onkoTyhja() {
        int rivi = 0;
        while (rivi < ruudukko.length) {
            rivi++;
            for (int sarake = 0; sarake < ruudukko.length; sarake++) {
                if (ruudukko[rivi][sarake]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean[][] kierraOikealle() {
        boolean[][] uusi = new boolean[ruudukko.length][ruudukko.length];
        int i = 0;
        int j = ruudukko.length - 1;
        int a = 0;
        int b = 0;
        while (a < ruudukko.length) {
            a++;
            i++;
            while (b < ruudukko.length) {
                j--;
                b++;
                uusi[a][b] = ruudukko[j][i];
            }
        }
        return uusi;
    }
}
