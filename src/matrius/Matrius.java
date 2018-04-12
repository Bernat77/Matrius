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

    public Matrius() {
    }

    public static void main(String[] args) {

        Matrius nueva = new Matrius();
        nueva.start();
    }

    public void start() {

        Scanner hola = new Scanner(System.in);
        boolean val = true;
        int a = 0;
        int b = 0;

        System.out.println("Bienvenido a la reducción de matrices!");
        System.out.println("Deberás insertar dos números, para filas y columnas, ambos deben ser números pares\n");
        do {
            try {
                System.out.println("Introduce número de filas:");
                a = hola.nextInt();
                System.out.println("Introduce número de columnas:");
                b = hola.nextInt();
                if (a % 2 == 0 && b % 2 == 0) {
                    val = false;
                } else {
                    System.out.println("Por favor, introduce valores pares...\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce números.");
                hola.next();
            }
        } while (val);
        System.out.print("Matrices:\n");
        setMatrizDim(a, b);
        setMatriu(randomFill(getMatriu()));
        print(getMatriu());
        System.out.println();

        while (getMatriu().length % 2 == 0 || getMatriu()[0].length % 2 == 0) {
            setMatriu(getMatrizReducida(getMatriu()));
            print(this.getMatriu());
            System.out.println();
        }
    }

    public int[][] randomFill(int[][] matriu) {

        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = (int) (Math.random() * 10);
            }
        }
        return matriu;
    }

    public int[][] getMatrizReducida(int[][] matriu) {
        int[][] nmatriu = new int[matriu.length / 2][matriu[0].length / 2];

        for (int i = 0; i < nmatriu.length; i++) {
            for (int j = 0; j < nmatriu[i].length; j++) {
                nmatriu[i][j] = matriu[2 * i][2 * j]
                        * matriu[(2 * i) + 1][2 * j]
                        * matriu[2 * i][(2 * j) + 1]
                        * matriu[(2 * i) + 1][(2 * j) + 1];
            }
        }

        return nmatriu;

    }

    public void setMatrizDim(int a, int b) {
        this.matriu = new int[a][b];
    }

    public void print(int[][] matriu) {

        for (int i = 0; i < matriu.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriu[i].length; j++) {
                System.out.print(matriu[i][j] + "\t");
            }
            System.out.print("|");
            System.out.println();
        }

    }

    public int[][] getMatriu() {
        return matriu;
    }

    public void setMatriu(int[][] matriu) {
        this.matriu = matriu;
    }

}
