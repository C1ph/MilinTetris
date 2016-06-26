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
import tetrispeli.kayttoliittyma.KeyboardListener;

/**
 *
 * @author annettek
 */
/**
 * Pelin graafinen käyttöliittymä-luokka.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Ohjaaja ohjaaja;
    private KeyboardListener kuuntelija;

    public Kayttoliittyma(Ohjaaja ohjaaja) {
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
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addKeyListener(kuuntelija);
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
        //container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        //container.add(luoValikko());
        container.add(ohjaaja.getAlusta());
        frame.addKeyListener(ohjaaja.getNappainkuuntelija());
        frame.setFocusable(true);
    }
    
}
