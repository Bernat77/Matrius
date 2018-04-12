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

    public Matrius(int a, int b) throws Exception {
        if (a % 2 != 0 || b % 2 != 0) {
            throw new Exception("impar");
        }
        this.matriu = new int[a][b];

    }

    public Matrius(int[][] matriu) {
        this.matriu = matriu;
    }

    public static void main(String[] args) {

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
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce números.");
                hola.next();
            }
            try {
                Matrius nueva = new Matrius(a, b);
                val = false;
                nueva.start();

            } catch (Exception e) {
                System.out.println("Por favor, introduce números pares");
            }
        } while (val);

    }

    public void start() {

        System.out.print("Matrices:\n");
        setMatriu(randomFill(getMatriu()));
        Matrius nueva = new Matrius(this.getMatriu());

        do {
            setMatriu(getMatrizReducida(getMatriu()));
            print(this.getMatriu());
            System.out.println();
        } while (getMatriu().length % 2 == 0 || getMatriu()[0].length % 2 == 0);
    }

    public int[][] randomFill(int[][] matriu) {

        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = (int) (Math.random() * 11);
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
