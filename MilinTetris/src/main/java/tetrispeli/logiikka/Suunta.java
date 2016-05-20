/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

/**
 *
 * @author annettek
 */
public class Suunta {

    public static Suunta OIKEA;
    public static Suunta ALAS;
    public static Suunta VASEN;
    
    private int siirto;
    
    public Suunta (int siirto) {
        this.siirto = siirto;
    }
    
    public int getSiirto () {
        return siirto;
    }
    
}
