/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.kayttoliittyma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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


    /**
     * Metodi päättää näppäimistötapahtuman, kun tiettyä näppäintä painetaan.
     *
     * @param e Keyevent
     *
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ohjaaja.getLogiikka().siirraVasemmalle();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ohjaaja.getLogiikka().siirraOikealle();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ohjaaja.getLogiikka().siirraAlas();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ohjaaja.getLogiikka().kierraOikealle();
        }
        this.ohjaaja.getAlusta().paivita();
    }

    @Override
    public void keyPressed(KeyEvent e) {
          }

    @Override
    public void keyReleased(KeyEvent e) {
         }

   
}
