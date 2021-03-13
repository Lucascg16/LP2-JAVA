package LPII.Ordenação;

import java.util.Scanner;

public class bubbleSort {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] vet = {9, 3, 1, 5, 8, 5, 0, 7, 8, 1};
        int aux;
        for (int i = 0; i < vet.length - 1; i++) {
            for (int j = 0; j < vet.length - 1 - i; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i]+",");
        }
    }
}
