/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.util.*;
import tetrispeli.kayttoliittyma.Alusta;
import tetrispeli.kayttoliittyma.Ohjaaja;
import static tetrispeli.logiikka.Suunta.ALAS;
import static tetrispeli.logiikka.Suunta.OIKEA;
import static tetrispeli.logiikka.Suunta.VASEN;

/**
 *
 * @author annettek
 */
public class Logiikka {

    private Logiikka logiikka;
    private Ajastin ajastin;
    private Alusta alusta;
    private Palikka palikka;
    private Ohjaaja ohjaaja;
    private PalikkaArpoja arpoja;
    private Ruudukko ruudukko;
    private ArrayList<Osa> osat;

    public Logiikka(Ohjaaja ohjaaja) {
        this.ohjaaja = ohjaaja;
        this.ruudukko = new Ruudukko(10, 25);
        this.arpoja = new PalikkaArpoja(this.ruudukko.getLeveys());
        this.palikka = arpoja.arvoPalikka();
        this.osat = new ArrayList<>();
        this.logiikka = new Logiikka(this);
        this.alusta = new Alusta(this);
        this.ajastin = new Ajastin(this);
    }

    public Palikka getPalikka() {
        return this.palikka;
    }

    public void setPalikka(Palikka palikka) {
        this.palikka = palikka;
    }
    
    public Ajastin getAjastin() {
        return ajastin;
    }

    public Alusta getAlusta() {
        return alusta;
    }

    public Logiikka getLogiikka() {
        return logiikka;
    }

    public void siirraAlas() {
        palikka.siirraAlas();
    }

    public void siirraYlos() {
        palikka.siirraYlos();
    }

    public void siirraVasemmalle() {
        palikka.siirraVasemmalle();
    }

    public void siirraOikealle() {
        palikka.siirraOikealle();
    }

    public void kierraOikealle() {
        palikka.kierraOikealle();
    }

    /**
     * Metodi tarkistaa, osuuko palikka toisen palikan päälle. Jos osuu, siirretään yksi ylöspäin, 
     * palikka liimataan paikalle ja liitetään se osaksi pohjapala-ArrayListiä. Jos ei, palikka liikkuu eteenpäin.
     */
    public boolean meneekoPaalle(ArrayList<Osa> osat, Osa osa) {
        for (Osa o : osat) {
            if (o.getX() == osa.getX() && o.getY() == osa.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodi tarkistaa, onko se paikka tyhjä, johon palikka on menossa. Jos ei, siirretään yksi ylöspäin, 
     * palikka liimataan paikalle ja liitetään se osaksi pohjapala-ArrayListiä. Jos on, palikka liikkuu eteenpäin.
     */
    public boolean onkoTyhja() {
        int rivi = 0;
        while (rivi < ruudukko.getLeveys()) {
            rivi++;
            for (int sarake = 0; sarake < ruudukko.getKorkeus(); sarake++) {
                if (ruudukko.palaTaulukko()[rivi][sarake] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodi tarkistaa, meneekö palikka seinän läpi. Jos menee, estetään kulku ja palikka jää alustan sisäpuolelle.
     */
//    public boolean meneekoSeinastaLapi(Suunta suunta, int leveys, int korkeus) {
//        if (suunta == Suunta.ALAS) {
//            return (this.y > (korkeus - 2));
//        } else if (suunta == Suunta.OIKEA) {
//            return (this.x > (leveys - 1));
//        } else if (suunta == Suunta.VASEN) {
//            return (this.x < 0);
//        } else {
//            return (this.y < 0);
//        }
//    }

    /**
     * Metodi tarkistaa, osuuko palikka pohjaan. Jos pelikentan alin kerros tayttyy paloista, metodi poistaa alimman
     * palakerroksen.
     */
//    public void pelinLoppu() {
//        if (osuukoPohjaan()) {
//            for (Osa o : palikka.getOsat()) {
//                this.osat.add(o);
//            }
//            luoUusiPalikka();
//        }
//        while (eiMahduEnempaa()) {
//            alinRiviPois();
//        }
//    }
    
    /**
     * Metodi tarkistaa,mahtuuko pohjalle enempää palikoita. 
     * Jos pelikentan alin kerros tayttyy paloista, metodi poistaa alimman
     * palakerroksen.
     */
//    public void eiMahduEnempaa() {
//        for (int i = 0; i < this.leveys; i++) {
//            boolean mahtuu = false;
//            for (Osa o : this.osat) {
//                if (o.getX() == i & o.getY() == (this.korkeus / 2)) {
//                    mahtuu = true;
//                }
//            }
//            if (!mahtuu) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /**
//     * Metodi luo peliin uuden palikan, ja jos uusi palikka asettuu pohjan
//     * palojen paalle, estaa palikan liikkumisen alaspain
//     */

//    public void luoUusiPalikka() {
//        palikka.arvoPalikka();
//    }

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
}
