/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.kayttoliittyma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetrispeli.logiikka.Suunta;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo nuolinäppäinten kuuntelijan.
 */
public class KeyboardListener implements KeyListener {

    private Ohjaaja ohjaaja;

    public KeyboardListener(Ohjaaja ohjaaja) {
        this.ohjaaja = ohjaaja;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    /**
     * Metodi päättää näppäimistötapahtuman, kun tiettyä näppäintä painetaan.
     *
     * @param e Keyevent
     *
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ohjaaja.siirraPalikka(Suunta.VASEN);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ohjaaja.siirraPalikka(Suunta.OIKEA);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ohjaaja.siirraPalikka(Suunta.ALAS);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ohjaaja.kaannaPalikka();
        }
    }
}
