package LPII;

import java.util.Random;
import java.util.Scanner;

public class ex11 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int temp, j = 0;
        int tam = 200;
        int[] vet = new int[tam];
        for (int i = 0; i < vet.length; i++) {
            int valor = new Random().nextInt(100) + 1;
            vet[i] = valor;
        }
        for (int i = 1; i < vet.length; i++) {
            temp = vet[i];
            j = i - 1;
            while ((j >= 0) && (vet[j] > temp)) {
                vet[j + 1] = vet[j--];
            }
            vet[j + 1] = temp;
        }
        for (int i = 0; i < vet.length; i++) {
            System.out.println(vet[i]);
        }
        System.out.println("Digite uma valor para procurar no vetor:");
        int valor = scan.nextInt();
        int x = 0, meio = 0, inicio = 0, fim = vet.length-1;
        boolean achou = false;
        while ((inicio <= fim) && (!achou)) {
            meio = (inicio + fim) / 2;
            if (valor == vet[meio]) {
                achou = true;
            }
            if (valor < vet[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        if (!achou) {
            System.out.println("não achou");
        } else {
            System.out.println("achou e está na posição " + meio);
        }
    }
}
