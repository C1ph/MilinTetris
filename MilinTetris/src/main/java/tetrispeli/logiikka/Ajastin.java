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
    private int aika;

    public Ajastin(Ohjaaja ohjaaja) {
        super(1000, null);
        this.aika = 0;
        this.addActionListener(this);
        this.ohjaaja = ohjaaja;
    }
    
    public void setAika(int aika) {
        this.aika = aika;
    }

    public int getAika(int aika) {
        return aika;
    }

    /**
     * Metodi, joka siirtaa palikkaa yhden askeleen alaspäin joka sekunnilla ja
     * päivittää pelialustan tilanteen.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.ohjaaja.getLogiikka().siirraAlas();
        this.ohjaaja.getAlusta().paivita();
    }

    /**
     *
     * Metodi, joka nopeuttaa palikan tippumisnopeutta.
     */
    public void nopeuta() {
        int vanha = this.getDelay();
        this.setDelay(vanha / 2);
    }

    /**
     * Kertoo kuinka kauan edellisestä päivityksestä on kulunut.
     *
     * @return aika.
     */
    public long paljonkoKulunut() {
        return System.currentTimeMillis();
    }

    /**
     * Kertoo, onko edellisestä päivityksestä kulunut tietty aika.
     *
     * @param aika Aika millisekunteina.
     * @return Palauttaa true, jos edellisestä päivityksestä on kulunut
     * vähintään parametrissa määritelty aika. Muutoin false.
     */
    public boolean kulunutAika(long aika) {
        return paljonkoKulunut() >= aika;
    }
}
