/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.util.*;
import static tetrispeli.logiikka.Suunta.ALAS;
import static tetrispeli.logiikka.Suunta.OIKEA;
import static tetrispeli.logiikka.Suunta.VASEN;

/**
 *
 * @author annettek
 */
public class Logiikka {

    private Palikka palikka;
    private ArrayList<Osa> osat;
    private int leveys;
    private int korkeus;
    private int x;
    private int y;
    private Ajastin ajastin = null;

    public Logiikka(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.palikka = palikka;
        this.osat = new ArrayList<Osa>();
    }

    public void setAjastin(Ajastin ajastin) {
        this.ajastin = ajastin;
    }

    public Ajastin getAjastin() {
        return this.ajastin;
    }

    public int getLeveys() {
        return this.leveys;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public Palikka getPalikka() {
        return this.palikka;
    }

    public ArrayList<Osa> getPohjanPalat() {
        return this.osat;
    }

    public void setPalikka(Palikka palikka) {
        this.palikka = palikka;
    }

    public void setOsat(ArrayList<Osa> osat) {
        this.osat = osat;
    }

    /**
     * Metodi tarkistaa, osuuko palikka pohjaan, ja jos osuu, lisaa palikan
     * palat pohjan paloihin, luo uuden palikan ja saataa nopeutta. Jos
     * pelikentan alin kerros tayttyy paloista, metodi poistaa alimman
     * palakerroksen.
     */
    public void pelinLoppu() {
        if (osuuPohjaan()) {
            for (Osa o : palikka.getOsat()) {
                this.osat.add(o);
            }
            luoUusiPalikka();
        }
        while (pohjaTaynna()) {
            alinRiviPois();
        }
    }

    /**
     * Metodi luo peliin uuden palikan, ja jos uusi palikka asettuu pohjan
     * palojen paalle, estaa palikan liikkumisen alaspain
     */
    public void luoUusiPalikka() {
        Osa palikka = new Osa(0, 0);
        for (Osa o : this.palikka.getOsat()) {
            if (this.palikka.meneekoPaalle(this.osat, o)) {
                this.ajastin.paivita();
            }
        }
    }

    /**
     * Metodi poistaa pelkentän alareunasta alimman rivin palikoita ja siirtää
     * muita pohjan palikoita yhden askeleen alaspäin
     */
    public void alinRiviPois() {
        ArrayList<Osa> poistettavat = new ArrayList<>();
        for (Osa o : osat) {
            if (o.getY() >= (this.korkeus - 1)) {
                poistettavat.add(o);
            }
        }
        for (Osa o : poistettavat) {
            osat.remove(o);
        }
        for (Osa o : osat) {
            o.siirra(x, y);
        }
    }

    /**
     * Metodi kertoo, osuuko palikka koordinaatiston alareunaan tai pelikentällä
     * oleviin paloihin.
     *
     * @return true jos palikka osuu koordinaatiston alareunaan tai pelikentällä
     * oleviin paloihin, muuten false
     */
    public boolean osuuPohjaan() {
        boolean palautettava = false;
        for (Osa o : this.palikka.getOsat()) {
            if (o.getY() >= (this.korkeus - 2)) {
                palautettava = true;
            } else if (osuukoPohjanPaloihin(o, ALAS)) {
                palautettava = true;
            }
        }
        return palautettava;
    }

    /**
     * Metodi kertoo, osuuko pelin palikka siirrettäessä pohjan paloihin
     *
     * @param suunta suunta, johon palikkaa halutaan siirtää
     * @return true, jos pelin palikka osuu siirrettäessä pohjan paloihin,
     * muuten false
     */
    public boolean osuukoPohjanPaloihin(Suunta suunta) {
        for (Osa o : this.palikka.getOsat()) {
            if (osuukoPohjanPaloihin(o, suunta)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Metodi siirtää pelin palikkaa haluttuun suuntaan, mikäli tämä ei siirrä
     * palikkaa päällekkäin pohjan palojen kanssa
     *
     * @param suunta suunta, johon palikkaa halutaan siirtää
     */
    public void siirraPalikkaa(Suunta suunta) {
        if (!(osuukoPohjanPaloihin(suunta))) {
            this.palikka.siirra(x, y);
        }
    }

    /**
     * Metodi tarkistaa, osuuko yksi pala päällekäin pohjan palojen kanssa,
     * mikäli palaa siirretään yksi askel haluttuun suuntaan
     *
     * @param pala Pala, jota ollaan liikuttamassa
     * @param suunta Suunta, johon palaa ollaan liikuttamassa
     * @return true, jos pala osuu siirrettäessä päällekkäin pohjan palojen
     * kanssa, muuten false
     */
    public boolean osuukoPohjanPaloihin(Osa osa, Suunta suunta) {
        if (this.osat == null) {
            return false;
        } else if (this.osat.isEmpty()) {
            return false;
        } else if (suunta == ALAS) {
            return osuukoPaloihinAlhaalla(osa);
        } else if (suunta == OIKEA) {
            return osuukoPaloihinOikealla(osa);
        } else if (suunta == VASEN) {
            return osuukoPaloihinVasemmalla(osa);
        }
        return false;
    }

    /**
     * Metodi tarkistaa, osuuko yksi pala päällekkäin sen alapuolella olevien
     * pohjan palojen kanssa, mikäli palaa siirretään yksi askel haluttuun
     * suuntaan
     *
     * @param pala Pala, jota ollaan liikuttamassa
     * @return true, jos pala osuu siirrettäessä päällekkäin sen alapuolella
     * olevien pohjan palojen kanssa, muuten false
     */
    public boolean osuukoPaloihinAlhaalla(Osa osa) {
        for (Osa o : this.osat) {
            if ((o.getY() == osa.getY() + 1) && (osa.getX() == o.getX())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodi tarkistaa, osuuko yksi pala päällekkäin sen oikealla puolella
     * olevien pohjan palojen kanssa, mikäli palaa siirretään yksi askel
     * haluttuun suuntaan
     *
     * @param pala Pala, jota ollaan liikuttamassa
     * @return true, jos pala osuu siirrettäessä päällekkäin sen oikealla
     * puolella olevien pohjan palojen kanssa, muuten false
     */
    public boolean osuukoPaloihinOikealla(Osa osa) {
        for (Osa o : this.osat) {
            if ((o.getY() == osa.getY()) && (osa.getX() + 1 == o.getX())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodi tarkistaa, osuuko yksi pala päällekkäin sen vasemmalla puolella
     * olevien pohjan palojen kanssa, mikäli palaa siirretään yksi askel
     * haluttuun suuntaan
     *
     * @param pala Pala, jota ollaan liikuttamassa
     * @return true, jos pala osuu siirrettäessä päällekkäin sen vasemmalla
     * puolella olevien pohjan palojen kanssa, muuten false
     */
    public boolean osuukoPaloihinVasemmalla(Osa osa) {
        for (Osa o : this.osat) {
            if ((o.getY() == osa.getY()) && (osa.getX() - 1 == o.getX())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodi kertoo, onko pelikentän alin palarivi täynnä
     *
     * @return true, jos pelikentän alin palarivi on täynnä, muuten false
     */
    public boolean pohjaTaynna() {
        for (int i = 0; i < this.leveys; i++) {
            boolean taynna = false;
            for (Osa o : this.osat) {
                if (o.getX() == i && o.getY() == (this.korkeus - 2)) {
                    taynna = true;
                }
            }
            if (!taynna) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi kääntää pelin palikkaa vastapäivään, mikäli tämä ei saa palikan
     * paloja asettumaan päällekkäin pohjan palojen kanssa
     */
    public void kaannaVasemmalle() {
        this.palikka.kierraVasemmalle(this.leveys, this.korkeus);
        boolean osuuko = false;
        for (Osa o : this.palikka.getOsat()) {
            if (this.palikka.meneekoPaalle(this.osat, o)) {
                osuuko = true;
            }
        }
        if (osuuko) {
            for (int i = 1; i <= 3; i++) {
                this.palikka.kierraVasemmalle(this.leveys, this.korkeus);
            }
        }
    }
}
