/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrius;

import java.util.*;

/**
 *
 * @author dam1a14
 */
public class Matrius {

    private int[][] matriu;

    public Matrius(int a, int b) {
        this.matriu = new int[a][b];
    }

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        
        Scanner hola = new Scanner(System.in);
        Matrius nueva;
        boolean val = true;
        int a = 0;
        int b = 0;

        do {
            try {
                System.out.print("Introduce número de filas");
                a = hola.nextInt();
                System.out.print("Introduce número de columnas");
                b = hola.nextInt();
                val = false;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce números.");
                hola.next();
            }
        } while (val);

        nueva = new Matrius(a, b);
        nueva.setMatriu(randomFill(nueva.getMatriu()));
        empezar();
    }
    
    public void empezar(Matrius matriu) {

        Matrius adios = matriu;

        while (adios.getMatriu().length % 2 != 0 || matriu.getMatriu()[0].length % 2 != 0) {
            adios.setMatriu(adios.getMatrizReducida(adios.getMatriu()));
            print(adios.getMatriu());
        }

    }

    public int[][] randomFill(int[][] matriu) {

        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = (int) Math.random() * 100;
            }
        }
        return matriu;
    }

    public int[][] getMatrizReducida(int[][] matriu) {
        int[][] nmatriu = new int[matriu.length / 2][matriu[0].length / 2];

        for (int i = 0; i < nmatriu.length; i++) {
            for (int j = 0; j < nmatriu[i].length; j++) {
                nmatriu[i][j] = matriu[2 * i][2 * j] * matriu[(2 * i) + 1][2 * j] * matriu[2 * i][(2 * j) + 1] * matriu[(2 * i) + 1][(2 * j) + 1];
            }
        }

        return nmatriu;

    }

    public void print(int[][] matriu) {

    }

    public int[][] getMatriu() {
        return matriu;
    }

    public void setMatriu(int[][] matriu) {
        this.matriu = matriu;
    }

}
