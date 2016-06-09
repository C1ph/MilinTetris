/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tetrispeli.kayttoliittyma.Ohjaaja;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo pelin sisältämien nappien kuuntelijan.
 */
public class ButtonListener implements ActionListener {

    private Ohjaaja ohjaaja;
    private JFrame frame;
    private JButton tauko;
    private JButton paalla;
    private JButton loppu;
    private JButton uusiPeli;

    public ButtonListener(JButton tauko, JButton paalla, JButton loppu, JButton uusiPeli, Ohjaaja ohjaaja, JFrame frame) {
        this.tauko = tauko;
        this.paalla = paalla;
        this.loppu = loppu;
        this.uusiPeli = uusiPeli;
        this.ohjaaja = ohjaaja;
        this.frame = frame;
    }

    /**
     * Metodi määrittää kutsujan avulla mikä komento nappia painettaessa suoritetaan.
     *
     * @param e napin takana oleva tapahtuma
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton kutsuja = (JButton) e.getSource();
        boolean paalla = ohjaaja.getPaalla();

        if (kutsuja == uusiPeli) {
            ohjaaja.uusiPeli();
        } else if (kutsuja == tauko) {
            ohjaaja.setPaalla(!ohjaaja.getPaalla());
        } else if (kutsuja == loppu) {
            ohjaaja.setPaalla(false);
            JOptionPane.showMessageDialog(frame, ohjaaja.getLoppu(), "Loppu!", JOptionPane.PLAIN_MESSAGE);
            if (!ohjaaja.getLoppu()) {
                ohjaaja.setPaalla(true);
            }
        }
    }
}
