/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author annettek
 */
public class Kayttoliittyma {
    
    private JFrame frame;
    private int korkeus;
    private int leveys;
    private int koko;
    
    public Kayttoliittyma(int leveys, int korkeus, int koko) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.koko = koko;
    }

    private JPanel luoValikko() {       
        JPanel valikko = new JPanel();
        valikko.setLayout(new BoxLayout(valikko, BoxLayout.X_AXIS));
        JButton uusi = new JButton("Uusi peli");
        JButton stop = new JButton("Stop");       
        valikko.add(uusi);
        valikko.add(stop);
        
        return valikko;
    }
}
