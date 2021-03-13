package LPIILista2;

import java.util.Scanner;

public class ex12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] vet =  new int[10];
        preencherVetor(vet);
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i]);
        }
        System.out.println("\nvalor da soma dos valores de vetor "+somarVetor(vet));
    }
    static void preencherVetor(int[] v){
        for (int i = 0; i < v.length; i++) {
            v[i] = i;
        }
    }
    static int somarVetor(int[]v){
        int soma = 0;
        for (int i = 0; i < v.length; i++) {
            soma += v[i];
        }
        return soma;
    }
}
