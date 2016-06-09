/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.kayttoliittyma;

import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tetrispeli.logiikka.Palikka;

import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo pelialustan.
 */
public class Alusta extends JPanel implements Paivitys {

    private int koko;
    private Ohjaaja ohjaaja;

    public Alusta(int koko, Ohjaaja ohjaaja) {
        this.koko = koko;
        this.ohjaaja = ohjaaja;
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    /**
     * Metodi piirtää palikan.
     *
     * @param piirrettava
     *
     */
    public void piirraPalikka(Palikka piirrettava, Graphics g) {
        boolean[][] ruudukko = piirrettava.getRuudukko();
        int i = 0;
        int j = 0;
        while (i < ruudukko.length) {
            i++;
        }
        while (j < ruudukko.length) {
            j++;
            if (ruudukko[i][j]) {
                g.fill3DRect((piirrettava.getX() + j) * koko, (piirrettava.getY() + i) * koko, koko, koko, true);
            }
        }
    }

    /**
     * Metodi maalaa palikan.
     * 
     * @param g maalattava komponentti
     *
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Palikka piirrettava : ohjaaja.getPalikat()) {
            piirraPalikka(piirrettava, g);
        }
        if (ohjaaja.getAktiivinen() != null) {
            piirraPalikka(ohjaaja.getAktiivinen(), g);
        }
    }

    @Override
    public void paivita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}