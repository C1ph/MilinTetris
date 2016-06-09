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
public abstract class Ajastin extends Timer implements ActionListener {

    private Ohjaaja ohjaaja;
    private Timer ajastin;
    private TimerTask ajastinTehtava;
    private long aloitusaika;

    public Ajastin(Ohjaaja ohjaaja) {
        super(1000, null);
        this.ohjaaja = ohjaaja;
        this.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ohjaaja.ajastinSiirto();
    }

    public void paivita() {
        int aika = 1000;
        aika--;
        if (aika < 100) {
            aika = 100;
        }
        super.setDelay(aika);
    }

    public void kaynnista() {
        if (!this.ajastin.isRunning()) {
            this.aloitusaika = System.currentTimeMillis();
            this.ajastin.start();
        }
    }

    public void pysayta() {
        if (this.ajastin.isRunning()) {
            this.ajastin.stop();
        }
    }
    
    @Override
    public String toString() {
        return "000";
    }

}
