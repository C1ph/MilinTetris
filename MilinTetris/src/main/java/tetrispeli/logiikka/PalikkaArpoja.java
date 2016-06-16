/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.util.Random;
import tetrispeli.logiikka.palikkatyypit.JPalikka;
import tetrispeli.logiikka.palikkatyypit.LPalikka;
import tetrispeli.logiikka.palikkatyypit.Neliopalikka;
import tetrispeli.logiikka.palikkatyypit.SPalikka;
import tetrispeli.logiikka.palikkatyypit.Suorapalikka;
import tetrispeli.logiikka.palikkatyypit.TPalikka;
import tetrispeli.logiikka.palikkatyypit.ZPalikka;

/**
 *
 * @author annettek
 */
/**
 * Luokka arpoo tietyn palikan laskeutuvaksi.
 */
public class PalikkaArpoja extends Palikka {

    public PalikkaArpoja(int x, int y) {
        super(x, y);
    }

    public Palikka arvoPalikka() {
        Random palikka = new Random();
        int i = palikka.nextInt(7);
        if (i == 0) {
            return new SPalikka(super.getX(), super.getY());
        } else if (i == 1) {
            return new LPalikka(super.getX(), super.getY());
        } else if (i == 2) {
            return new JPalikka(super.getX(), super.getY());
        } else if (i == 3) {
            return new TPalikka(super.getX(), super.getY());
        } else if (i == 4) {
            return new Suorapalikka(super.getX(), super.getY());
        } else if (i == 5) {
            return new Neliopalikka(super.getX(), super.getY());
        } else {
            return new ZPalikka(super.getX(), super.getY());
        }
    }
}
