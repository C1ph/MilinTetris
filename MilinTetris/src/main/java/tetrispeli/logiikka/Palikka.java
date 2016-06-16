/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author annettek
 */
/**
 * Luokka luo abstraktin Palikka-käsitteen.
 */
public abstract class Palikka {

    private ArrayList<Osa> osat;
    private int x;
    private int y;

    public Palikka(int x, int y) {
        this.osat = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public ArrayList<Osa> getOsat() {
        return osat;
    }
    
    public void siirraAlas() {
        this.y += 1;
    }
    
    public void siirraYlos() {
        this.y -= 1;
    }
    
    public void siirraVasemmalle() {
        this.x -= 1;
    }
    
    public void siirraOikealle() {
        this.x += 1;
    }
    
    public void kierraOikealle() {
        for (Osa osa : osat) {
            int vanhaX = osa.getX();
            int vanhaY = osa.getY();
            osa.setX(vanhaY);
            osa.setY(-vanhaX);
        }
    }
    
    public void kierraVasemmalle(int leveys, int korkeus) {   
        for (int i = 0; i < 3; i++) {
            kierraOikealle();
        }
    }
}
