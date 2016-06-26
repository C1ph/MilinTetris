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
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tetrispeli.logiikka.Osa;

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

    public Alusta(Ohjaaja ohjaaja) {
        this.ohjaaja = ohjaaja;
        // this.setLayout(new FlowLayout(FlowLayout.RIGHT));
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
        this.piirraLiikuteltavaPalikka(g);
    }

    @Override
    public void paivita() {
        this.repaint();
    }

    /**
     * Metodi piirtää palikan.
     *
     * @param piirrettava
     * @param g
     *
     */
    public void piirraLiikuteltavaPalikka(Graphics g) {
        for (Osa osa : ohjaaja.getLogiikka().getPalikka().getOsat()) {
            this.piirraOsa(osa, g);
        }
    }

        /**
     * Metodi piirtää palikan osan.
     *
     * @param osa
     * @param g
     *
     */
    public void piirraOsa(Osa osa, Graphics g) {
        g.fillRect(osa.getX() * 10, osa.getY() * 10, 10, 10);
    }
}
