/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class ex09 {

    public static void main(String[] args) {
        String[] v = {"Mario", "Valdir", "Carlos", "Jorge", "Bia", "Ana", "Zelia", "Manuel", "Carla"};
        String aux;
        for (int i = 0; i <= v.length; i++) {
            for (int c = i + 1; c < v.length; c++) {
                if (v[i].compareTo(v[c]) > 0) {
                    aux = v[i];
                    v[i] = v[c];
                    v[c] = aux;
                }
            }
        }
        for(int i = 0; i < v.length; i++){
            System.out.println(v[i]);
        }
    }
}
