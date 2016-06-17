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
    
    /**
     * 
     * Metodit siirtävät palikkaa yhden askeleen verran haluttuun suuntaan.
     */
    
    public void siirraAlas() {
        this.y = this.y + 1;
        for (Osa osa : osat) {
            osa.siirraAlas();
        }
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
    
    /**
     * 
     * Metodit pyörittävät palikkaa haluttuun suuntaan sen liikkuessa.
     */
    
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
