/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII.Ordena��o;

/**
 *
 * @author Lucas
 */
public class inser��o {

    public static void main(String[] args) {

        int vet[] = {23, 4, 33, 45, 19, 12, 28, 40};
        int i, j, temp;
        for (i = 1; i < vet.length; i++) {
            temp = vet[i];
            j = i - 1;
            while ((j >= 0) && (vet[j] > temp)) {
                vet[j + 1] = vet[j--];
            }
            vet[j + 1] = temp;
        }
        for (i = 0; i < vet.length; i++) {
            System.out.println(vet[i]);
        }
    }
}

