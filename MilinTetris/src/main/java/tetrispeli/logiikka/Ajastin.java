/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import tetrispeli.kayttoliittyma.Ohjaaja;
import java.util.TimerTask;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo pelissä tarvittavan ajastimen.
 */
public class Ajastin extends Timer implements ActionListener {

    private Ohjaaja ohjaaja;

    public Ajastin(Ohjaaja ohjaaja) {
        super(1000, null);
        this.addActionListener(this);
        this.ohjaaja = ohjaaja;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.ohjaaja.getLogiikka().siirraAlas();
        this.ohjaaja.getAlusta().paivita();
    }
    
    public void nopeuta() {
        int vanha = this.getDelay();
        this.setDelay(vanha / 2);
    }
}
