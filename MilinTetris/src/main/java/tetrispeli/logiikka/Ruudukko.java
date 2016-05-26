/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

/**
 *
 * @author annettek
 */
public class Ruudukko {

    private boolean[][] ruudukko;
    private int leveys;
    private int korkeus;

    public Ruudukko(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudukko = new boolean[korkeus][leveys];
    }
    
    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }
    
    public boolean[][] getRuudukko() {
        return ruudukko;
    }

    public void tyhjennaRuudukko() {
        ruudukko = new boolean[korkeus][leveys];
    }

    public int palautaRivi() {
        int palikat;
        int i = 0;
        int j = 0;
        while (i < korkeus) {
            i++;
            palikat = 0;
            while (j < leveys) {
                j++;
                if (ruudukko[i][j]) {
                    palikat++;
                }
            }
            if (palikat == leveys) {
                return i;
            }
        }
        return -1;
    }

    private boolean onkoSisalla(boolean[][] ruudukko, int x, int y) {
        int i = 0;
        int j = 0;
        while (i < ruudukko.length) {
            i++;
            while (j < ruudukko.length) {
                j++;
                if (ruudukko[i][j]) {
                    if ((x + j < 0) || (x + j >= leveys)) {
                        return false;
                    } else if ((y + i < 0) || (y + i >= korkeus)) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public boolean siirtyminenOnnistuu(boolean[][] ruudukko, int x, int y) {
        int i = 0;
        int j = 0;
        if (!onkoSisalla(ruudukko, x, y)) {
            return false;
        }
        while (i < ruudukko.length) {
            i++;
            while (j < ruudukko.length) {
                j++;
                if (ruudukko[i][j] && ruudukko[y + i][x + j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
