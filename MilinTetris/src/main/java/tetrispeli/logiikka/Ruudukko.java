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
    
}
