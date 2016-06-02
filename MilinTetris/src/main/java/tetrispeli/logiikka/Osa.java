/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.awt.Color;
import tetrispeli.logiikka.Palikka;
import tetrispeli.logiikka.Ruudukko;

/**
 *
 * @author annettek
 */
public class Osa {

    private int x;
    private int y;
    public boolean ruudukko[][];

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

    public void siirra(Suunta suunta) {
        if (suunta == Suunta.OIKEA) {
            x += 1;
        } else if (suunta == Suunta.ALAS) {
            y += 1;
        } else if (suunta == Suunta.VASEN) {
            x -= 1;
        }
    }

    public boolean[][] kaanna() {
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
