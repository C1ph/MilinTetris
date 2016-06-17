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

    private Palikka palikka;
    private Ohjaaja ohjaaja;
    private PalikkaArpoja arpoja;
    private Ruudukko ruudukko;

    public Logiikka(Ohjaaja ohjaaja) {
        this.ohjaaja = ohjaaja;
        this.ruudukko = new Ruudukko(10, 30);
        this.arpoja = new PalikkaArpoja(this.ruudukko.getLeveys());
        this.palikka = arpoja.arvoPalikka();
    }

    public Palikka getPalikka() {
        return this.palikka;
    }

    public void setPalikka(Palikka palikka) {
        this.palikka = palikka;
    }

    /**
     *
     * Metodit siirtävät palikkaa haluttuun suuntaan.
     */
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

    /**
     * Metodi kiertää palikkaa asteen verran oikealle.
     */
    public void kierraOikealle() {
        palikka.kierraOikealle();
    }

    /**
     * /**
     * Metodi tarkistaa, osuuko yksi pala päällekkäin sen alapuolella olevien
     * pohjan palojen kanssa, mikäli palaa siirretään yksi askel haluttuun
     * suuntaan
     *
     * @param pala Pala, jota ollaan liikuttamassa
     * @return true, jos pala osuu siirrettäessä päällekkäin sen alapuolella
     * olevien pohjan palojen kanssa, muuten false
     */
    
    public boolean onkoOsaPaalla(Osa osa) {
        if (ruudukko.onkoKohtaTyhja(osa.getX(), osa.getY())) {
            return false;
        }
        return true;
    }

    /**
     * Käy läpi tämänhetkisen liikuteltavan palikan osat, ja mikäli jokin osista
     * on päällekkäin jonkun ruudukon osan kanssa palauttaa true. (Käyttää hyväksi metodia onkoOsaPaalla())
     *
     * @param pala Pala, jota ollaan liikuttamassa
     * @return true, jos pala osuu siirrettäessä päällekkäin sen alapuolella
     * olevien pohjan palojen kanssa, muuten false
     */
    public boolean onkoPalikkaPaalla() {
        for (Osa osa : palikka.getOsat()) {
            if (onkoOsaPaalla(osa)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodi tarkistaa, onko se paikka tyhjä, johon palikka on menossa. Jos ei,
     * siirretään yksi ylöspäin, palikka liimataan paikalle ja liitetään se
     * osaksi pohjapala-ArrayListiä. Jos on, palikka liikkuu eteenpäin.
     */
   
    /**
     * Metodi liimaa palikan lautaan, jos vastaan tulee alhaalla palikka. 
     */
    public void liimaaPalikkaLautaan() {
        for (Osa osa : palikka.getOsat()) {
            liimaaOsaLautaan(osa);
        }
    }
    
    /**
     * Metodi liimaa osan lautaan.
     */
    public void liimaaOsaLautaan(Osa osa) {
        ruudukko.getRuudut()[osa.getX()][osa.getY()] = osa;
    }

    /**
     * Metodi tarkistaa, meneekö osa seinän läpi. Jos menee, estetään kulku
     * ja palikka jää alustan sisäpuolelle.
     */
    public boolean meneekoOsaYli(Osa osa) {
        if (osa.getX() < 0 || osa.getY() < 0 || osa.getX() >= ruudukko.getLeveys() || osa.getY() >= ruudukko.getKorkeus()) {
            return true;
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa, meneekö palikka seinän läpi. Jos menee, estetään kulku
     * ja palikka jää alustan sisäpuolelle.
     */
    public boolean meneekoPalikkaYli() {
        for (Osa osa : palikka.getOsat()) {
            if (meneekoOsaYli(osa)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodi tarkistaa, osuuko palikka pohjaan. Jos pelikentan alin kerros
     * tayttyy paloista, metodi poistaa alimman palakerroksen.
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
     * Metodi tarkistaa,mahtuuko pohjalle enempää palikoita. Jos pelikentan alin
     * kerros tayttyy paloista, metodi poistaa alimman palakerroksen.
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
    //**
    
}
