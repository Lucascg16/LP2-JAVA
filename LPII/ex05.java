package LPII;
//inserção direta e bolha.

import java.util.Scanner;

public class ex05 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] vet = {3, 54, 60, 50, 30, 20};
        int aux;
        int esc, count = 0;
        boolean fica = true;

        while (fica == true) {
            System.out.println("Escolha o algoritimo (1=bolha,2=insercao direta,3=sair)");
            esc = scan.nextInt();
            if (esc == 1) {
                for (int i = 0; i < vet.length - 1; i++) {
                    for (int j = 0; j < vet.length - 1 - i; j++) {
                        if (vet[j] > vet[j + 1]) {
                            aux = vet[j];
                            vet[j] = vet[j + 1];
                            vet[j + 1] = aux;
                        }
                    }
                    count += 1;
                }
                for (int i = 0; i < vet.length; i++) {
                    System.out.println(vet[i]);
                }
                System.out.println("quantidade de posicoes movidas="+count);
            } else {
                if (esc == 2) {
                    int i, j, temp;
                    for (i = 1; i < vet.length; i++) {
                        temp = vet[i];
                        j = i - 1;
                        while ((j >= 0) && (vet[j] > temp)) {
                            vet[j + 1] = vet[j--];
                        }
                        vet[j + 1] = temp;
                        count += 1;
                    }
                    for (i = 0; i < vet.length; i++) {
                        System.out.println(vet[i]);
                    }
                    System.out.println("quantidade de posicoes movidas="+count);
                } else {
                    if (esc == 3) {
                        fica = false;
                    }
                }
            }
        }
    }
}
