/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import tetrispeli.kayttoliittyma.*;
import tetrispeli.logiikka.Ajastin;
import tetrispeli.logiikka.Palikka;
import tetrispeli.logiikka.Ruudukko;
import tetrispeli.logiikka.Suunta;

/**
 *
 * @author annettek
 */
/**
 * Pelin graafinen käyttöliittymä-luokka.
 */
public class Kayttoliittyma implements Runnable, Paivitys {

    private JFrame frame;
    private int korkeus;
    private int leveys;
    private int koko;
    private Alusta alusta;
    private Ohjaaja ohjaaja;
    private JPanel valikko;

    public Kayttoliittyma(int leveys, int korkeus, int koko, Ohjaaja ohjaaja) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.koko = koko;
        this.ohjaaja = ohjaaja;
    }

    /**
     * Metodi luo käyttöliittymä-valikon.
     *
     * @param args
     *
     * @return JPanel-tyyppinen valikko
     */
    private JPanel luoValikko() {
        JPanel valikko = new JPanel();
        valikko.setLayout(new BoxLayout(valikko, BoxLayout.X_AXIS));
        JButton uusi = new JButton("Uusi peli");
        JButton stop = new JButton("Pysäytä peli");
        valikko.add(uusi);
        valikko.add(stop);
        return valikko;
    }

    /**
     * Metodi ajaa uuden ikkunan.
     *
     * @param args
     *
     */
    public void run() {
        frame = new JFrame("Tetrispeli");
        int leveys2 = leveys * koko + (int) (koko * 0.5);
        int korkeus2 = korkeus * koko + (int) (koko * 1.5) + 29;
        frame.setPreferredSize(new Dimension(leveys2, korkeus2));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        ohjaaja.lisaaPaivitettava(this);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Metodi päivittää käyttöliittymän.
     *
     * @param args
     *
     */
    public void paivitaKayttoliittyma() {
        if (!ohjaaja.getPaalla()) {
            frame.setFocusable(false);
        } else {
            frame.setFocusable(true);
            frame.requestFocusInWindow();
        }
    }

    /**
     * Metodi luo käyttöliittymälle tarvittavat komponentit.
     *
     * @param container Container
     *
     */
    public void luoKomponentit(Container container) {
        Alusta alusta = new Alusta(ohjaaja);
        alusta.setBorder(BorderFactory.createEtchedBorder());
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        valikko = luoValikko();
        container.add(luoValikko());
        container.add(alusta);
        ohjaaja.lisaaPaivitettava(alusta);
        container.add(alusta);
        frame.addKeyListener(new KeyboardListener(ohjaaja));
        frame.setFocusable(true);
    }

    /**
     * Metodi päivittää ohjaajan tilan ikkunassa.
     *
     * @param args
     *
     */
    public void paivita() {
        if (!ohjaaja.getPaalla()) {
            frame.setFocusable(false);
        } else {
            frame.setFocusable(true);
            frame.requestFocusInWindow();
        }
    }
}
