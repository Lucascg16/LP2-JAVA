package LPIILista2;

import java.util.Random;
import java.util.Scanner;

public class ex15 {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        boolean segunte = false;
        int tam = 10;
        int[] vet = new int[tam];

        for (int i = 0; i < vet.length; i++) {
            System.out.println("Digite um numero:");
            vet[i] = scan.nextInt();
        }
        if (verificar(vet)) {
            System.out.println("O vetor estar em ordem crescente.");
        } else {
            System.out.println("O vetor nao estar em ordem crescente.");
        }
    }

    static boolean verificar(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            if(v[i] > v[i + 1]){
                return false;
            }
        }
        return true;
    }
}
