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
public class Palikka {

    private int x;
    private int y;

    public Palikka(int x, int y) {
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
}
