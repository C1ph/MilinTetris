/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.kayttoliittyma;

import tetrispeli.logiikka.palikkatyypit.ZPalikka;
import tetrispeli.logiikka.palikkatyypit.SPalikka;
import tetrispeli.logiikka.palikkatyypit.LPalikka;
import tetrispeli.logiikka.palikkatyypit.Neliopalikka;
import tetrispeli.logiikka.palikkatyypit.JPalikka;
import tetrispeli.logiikka.palikkatyypit.TPalikka;
import tetrispeli.logiikka.palikkatyypit.Suorapalikka;
import java.util.*;
import tetrispeli.logiikka.Ajastin;
import tetrispeli.logiikka.Logiikka;
import tetrispeli.logiikka.Palikka;
import tetrispeli.logiikka.Ruudukko;
import tetrispeli.logiikka.Suunta;
import tetrispeli.logiikka.Osa;
/**
 *
 * @author annettek
 */
/**
 * Luokka luo peliohjaajan, joka päivittää pelitilannetta ja ajastaa pelinkulun.
 */
public class Ohjaaja {

    private Alusta alusta;
    private Logiikka logiikka;
    private Palikka palikka;
    private Ruudukko ruudukko;
    private ArrayList<Palikka> palikat;
    private ArrayList<Paivitys> paivitykset;
    private int leveys;
    private Ajastin ajastin;
    private boolean[][] taulukko;
    private boolean paalla;
    private boolean tauko;
    private boolean loppu;

    public Ohjaaja(int leveys, int korkeus) {
        palikat = new ArrayList<Palikka>();
        paivitykset = new ArrayList<Paivitys>();
        ruudukko = new Ruudukko(leveys, korkeus);
        leveys = this.leveys;
        ajastin.addActionListener(ajastin);
    }

    public Logiikka getLogiikka() {
        return logiikka;
    }

    public Alusta getAlusta() {
        return alusta;
    }

    public Palikka getPalikka() {
        return palikka;
    }
    
    
    /**
     * Metodi luo uuden pelin.
     *
     * @param args
     *
     */
    
    
    public void uusiPeli() {
        palikat.clear();
        ruudukko.tyhjennaRuudukko();
        palikka = luoPalikka();
        paalla = true;
        tauko = false;
        loppu = false;
        paivitaKayttoliittyma();
    }

    /**
     * Metodi lisää palikan ArrayListiin.
     *
     * @param palikka Palikka
     *
     */
    public void lisaaPalikka(Palikka palikka) {
        palikat.add(palikka);
    }
    /**
     * Metodi lisää päivityksen ArrayListiin.
     *
     * @param paivitys Paivitys
     *
     */
    public void lisaaPaivitettava(Paivitys paivitys) {
        paivitykset.add(paivitys);
    }
    public ArrayList<Palikka> getPalikat() {
        return palikat;
    }
    
    public boolean getPaalla() {
        return paalla;
    }
    public boolean getTauko() {
        return tauko;
    }
    public boolean getLoppu() {
        return loppu;
    }
    public void setLoppu(boolean gameover) {
        loppu = gameover;
    }
    /**
     * Metodi päivittää käyttöliittymän tilanteen.
     *
     * @param args
     */
    public void paivitaKayttoliittyma() {
        for (Paivitys paivitettava : paivitykset) {
            paivitettava.paivita();
        }
    }
    /**
     * Metodi luo aktiivisen palikan.
     *
     * @param args
     * @return aktiivinen Palikka
     */
    public Palikka luoPalikka() {
        palikka.arvoPalikka();
    }
    /**
     * Metodi siirtää palikkaa haluttuun suuntaan.
     *
     * @param suunta Suunta
     *
     * @return false
     */
    public boolean siirraPalikka(Suunta suunta) {
        if (suunta == Suunta.ALAS) {
            if (ruudukko.siirtyminenOnnistuu(taulukko, aktiivinen.getX(), aktiivinen.getY() + suunta.getSiirto())) {
                aktiivinen.siirra(suunta);
                paivitaKayttoliittyma();
                return true;
            } else if (ruudukko.siirtyminenOnnistuu(taulukko, aktiivinen.getX() + suunta.getSiirto(), aktiivinen.getY())) {
                aktiivinen.siirra(suunta);
                paivitaKayttoliittyma();
                return true;
            }
        }
        return false;
    }
    /**
     * Metodi vaihtaa aktiivisen palikan.
     *
     * @param args
     */
    public void vaihdaPalikka() {
        palikat.add(aktiivinen);
        ruudukko.paivitaListanPalikat(palikat);
        poistaakoRiveja();
        aktiivinen = luoPalikka();
        if (!ruudukko.siirtyminenOnnistuu(taulukko, aktiivinen.getX(), aktiivinen.getY())) {
            ajastin.stop();
            aktiivinen = null;
            tauko = true;
            loppu = true;
            paalla = false;
            paivitaKayttoliittyma();
            return;
        }
        paivitaKayttoliittyma();
        ajastin.paivita();
    }
    /**
     * Metodi kääntää aktiivisen palikan.
     *
     * @param args
     */
    public void kaannaPalikka() {
        boolean[][] kaannos = aktiivinen.kierraOikealle();
        if (ruudukko.siirtyminenOnnistuu(kaannos, aktiivinen.getX(), aktiivinen.getY())) {
            aktiivinen.setRuudukko(kaannos);
            paivitaKayttoliittyma();
        }
    }
    /**
     * Metodi siirtää ajastimen aikaa.
     *
     * @param args
     */
    public void ajastinSiirto() {
        if (!siirraPalikka(Suunta.ALAS)) {
            vaihdaPalikka();
        }
    }
    /**
     * Metodi tarkistaa, onko poistettavia rivejä.
     *
     * @param args
     */
    private void poistaakoRiveja() {
        int poistettava = ruudukko.palautaRivi();
        int poistettuja = 0;
        while (poistettava != -1) {
            for (Palikka palikka : palikat) {
                ruudukko.pudotaRivi(poistettava);
            }
            ruudukko.tyhjennaRuudukko();
            ruudukko.paivitaListanPalikat(palikat);
            poistettuja++;
            poistettava = ruudukko.palautaRivi();
        }
        poistaTyhjia();
        paivitaKayttoliittyma();
    }
    /**
     * Metodi poistaa turhan rivin.
     *
     * @param args
     */
    public void poistaTyhjia() {
        int i = 0;
        while (i < palikat.size()) {
            i++;
            if (palikat.get(i).onkoTyhja()) {
                palikat.remove(i);
            }
        }
    }
    /**
     * Metodi asettaa ajastimen päälle tai pois.
     *
     * @param paalla boolean
     */
    public void setPaalla(boolean paalla) {
        if (paalla == false) {
            ajastin.stop();
        } else {
            ajastin.start();
        }
        paivitaKayttoliittyma();
    }

}