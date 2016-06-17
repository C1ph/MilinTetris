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
import tetrispeli.logiikka.PalikkaArpoja;
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
    private Ajastin ajastin;
    private boolean paalla;
    private boolean tauko;
    private boolean loppu;
    private KeyboardListener nappainkuuntelija;

    public Ohjaaja() {
        
    }

    public Logiikka getLogiikka() {
        return logiikka;
    }

    public Alusta getAlusta() {
        return alusta;
    }

    public Ajastin getAjastin() {
        return ajastin;
    }
    
    
    /**
     * Metodi luo uuden pelin.
     *
     * @param args
     *
     */
    public void uusiPeli() {
        ajastin = new Ajastin(this);
        logiikka = new Logiikka(this);
        alusta = new Alusta(this);
        nappainkuuntelija = new KeyboardListener(this);
        Kayttoliittyma kali = new Kayttoliittyma(this);
        kali.run();
        ajastin.start();
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

    public KeyboardListener getNappainkuuntelija() {
        return nappainkuuntelija;
    }
    
    public void setLoppu(boolean loppu) {
        this.loppu = loppu;
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
    }
}