/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrispeli.logiikka;

import java.util.Random;

/**
 *
 * @author annettek
 */
public class Palikka {

    private int x;
    private int y;
    private boolean ruudukko[][];
    private int[][] palikat;

    public Palikka(int x, int y) {
        this.x = x;
        this.y = y;
        this.ruudukko = ruudukko;
        this.palikat = arvoPalikka();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean[][] getRuudukko() {
        return ruudukko;
    }

    public int[][] arvoPalikka() {
        Random palikka = new Random();
        int x = palikka.nextInt(6);
        if (x == 0) {
            return SPalikka();
        } else if (x == 1) {
            return LPalikka();
        } else if (x == 2) {
            return JPalikka();
        } else if (x == 3) {
            return TPalikka();
        } else if (x == 4) {
            return suoraPalikka();
        } else if (x == 5) {
            return nelioPalikka();
        } else {
            return ZPalikka();
        }
    }

    public void siirra(Suunta suunta) {
        if (suunta == Suunta.OIKEA) {
            x += 1;
        } else if (suunta == Suunta.ALAS) {
            y += 1;
        } else if (suunta == Suunta.VASEN) {
            x -= 1;
        }
    }

    private int[][] SPalikka() {
        int[][] S = new int[4][4];
        S[2][1] = 2;
        S[3][1] = 2;
        S[1][2] = 2;
        S[2][2] = 2;
        return S;
    }

    private int[][] LPalikka() {
        int[][] L = new int[4][4];
        L[0][1] = 2;
        L[1][1] = 2;
        L[2][1] = 2;
        L[0][2] = 2;
        return L;
    }

    private int[][] JPalikka() {
        int[][] J = new int[4][4];
        J[0][1] = 2;
        J[1][1] = 2;
        J[2][1] = 2;
        J[2][2] = 2;
        return J;
    }

    private int[][] TPalikka() {
        int[][] T = new int[4][4];
        T[1][1] = 2;
        T[0][2] = 2;
        T[1][2] = 2;
        T[2][2] = 2;
        return T;
    }

    private int[][] suoraPalikka() {
        int[][] suora = new int[4][4];
        suora[0][1] = 2;
        suora[1][1] = 2;
        suora[2][1] = 2;
        suora[3][1] = 2;
        return suora;
    }

    private int[][] nelioPalikka() {
        int[][] nelio = new int[4][4];
        nelio[1][1] = 2;
        nelio[2][1] = 2;
        nelio[1][2] = 2;
        nelio[2][2] = 2;
        return nelio;
    }

    private int[][] ZPalikka() {
        int[][] Z = new int[4][4];
        Z[1][1] = 2;
        Z[2][1] = 2;
        Z[2][2] = 2;
        Z[3][2] = 2;
        return Z;
    }
}
