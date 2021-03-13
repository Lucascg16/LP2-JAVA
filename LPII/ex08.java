package LPII;

import java.util.Scanner;

public class ex08 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tam = 5;
        int[] vet = new int[tam];
        boolean boo = true, preen = false;
        while (boo == true) {
            System.out.println("Menu:"
                    + "\n1:preencher o vetor"
                    + "\n2:ordenar os dados"
                    + "\n3:pesquisar um dado no vetor'um numero'"
                    + "\n4:sair do programa");
            System.out.println("Sua escolha:");
            int esc = scan.nextInt();

            switch (esc) {
                case 1:
                    for (int i = 0; i < vet.length; i++) {
                        System.out.println("Digite um valor para preencher a " + (i + 1) + " posicao do vetor:");
                        vet[i] = scan.nextInt();
                    }
                    preen = true;
                    break;
                case 2:
                    if (preen == true) {
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
                    }else{
                        System.out.println("Dados nao cadastrados.");
                    }
                    break;
                case 3:
                    System.out.println("Digite um valor para procurar no vetor:");
                    int va  = scan.nextInt();
                    int count = 0;
                    for (int i = 0; i < vet.length; i++) {
                        if (vet[i] == va) {
                            System.out.println("O valor " + va+  "foi encontrado na posicao" + (i + 1));
                            count += 1;
                        }
                    }
                    if (count == 0) {
                        System.out.println("O valor " + va+  " nao foi encontrado");
                    }
                    break;
                case 4:
                    for (int i = 0; i < vet.length; i++) {
                        System.out.print(vet[i]);
                    }
                    boo = false;
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        }
    }
}
