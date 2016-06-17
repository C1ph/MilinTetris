/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.util.ArrayList;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo peliruudukon.
 */
public class Ruudukko {

    private Osa[][] ruudut;
    private int leveys;
    private int korkeus;

    public Ruudukko(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudut = new Osa[leveys][korkeus];
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public Osa[][] getRuudut() {
        return ruudut;
    }

    public void setRuudut(Osa[][] ruudut) {
        this.ruudut = ruudut;
    }

    public void tyhjennaRuudut() {
        ruudut = new Osa[leveys][korkeus];
    }

    public boolean onkoKohtaTyhja(int x, int y) {
        return ruudut[x][y] == null;
    }
}
