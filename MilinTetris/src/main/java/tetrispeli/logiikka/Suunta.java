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
/**
 * Luokka luo ja määrää palikan suunnan.
 */
public enum Suunta {

    OIKEA(1), VASEN(-1), ALAS(1);

    private int siirto;

    private Suunta(int siirto) {
        this.siirto = siirto;
    }

    public int getSiirto() {
        return siirto;
    }

    public Suunta getVasen() {
        return VASEN;
    }

    public Suunta getOikea() {
        return OIKEA;
    }

    public Suunta getAlas() {
        return ALAS;
    }
}
