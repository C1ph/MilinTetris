/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo abstraktin Palikka-käsitteen.
 */
public abstract class Palikka {

    private ArrayList<Osa> osat;
    public boolean[][] ruudukko;
    private int x;
    private int y;
    private Osa osa;
    

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
    
    public ArrayList<Osa> getOsat() {
        return osat;
    }
    
    public void siirra(int x, int y) {
        for (Osa o : osat) {
            o.siirra(x, y);
        }
    }
    
    public void setRuudukko(boolean[][] kaannos) {
        
    }

    public boolean[][] getRuudukko() {
        return ruudukko;
    }
    // globaalit ja lokaalit paras tapa!
    // matriisikertolasku-taulukon teko
    
    public boolean meneekoPaalle(ArrayList<Osa> osat, Osa osa) {
        for (Osa o : osat) {
            if (o.getX() == osa.getX() && o.getY() == osa.getY()) {
                return true;
            }
        }
        return false;
    }

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
    
    public void kierraVasemmalle(int leveys, int korkeus) {   
        kierraKerran();
        if (meneekoSeinastaLapi(Suunta.VASEN, leveys, korkeus)
                || meneekoSeinastaLapi(Suunta.OIKEA, leveys, korkeus)
                || meneekoSeinastaLapi(Suunta.ALAS, leveys, korkeus)) {
            for (int i = 1; i <= 3; i++) {
                kierraKerran();
            }
        } 
    }
    
    public void kaanna() {
        for (int i = 1; i < osat.size(); i++) {
            Osa o = (Osa) osat.get(i);
            osat.get(i - 1);
            o.kaannaVasemmalle();
        }
    }
    
    public boolean meneekoSeinastaLapi(Suunta suunta, int leveys, int korkeus) {
        if (suunta == Suunta.ALAS) {
            return (this.y > (korkeus - 2));
        } else if (suunta == Suunta.OIKEA) {
            return (this.x > (leveys - 1));
        } else if (suunta == Suunta.VASEN) {
            return (this.x < 0);
        } else {
            return (this.y < 0);
        }
    }
    
    public void kierraKerran() {
        for (int i = 1; i < osat.size(); i++) {
            Osa osa = (Osa) osat.get(i);
            osat.get(i - 1);
            osa.kaannaVasemmalle();
        }
    }
}
