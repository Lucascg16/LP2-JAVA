package LPIILista2;

import java.util.Scanner;

public class ex16 {
    static Scanner scan = new Scanner(System.in);
    static int cont = 0;

    public static void main(String[] args) {

        int tam = 1000;
        int[] vet = new int[tam];

        preencherVetor(vet);

        System.out.println("O maior numero digitado foi:" + maior(vet));

        System.out.println("O menor numero digitado foi:" + menor(vet));

        System.out.println("A media dos valores digitados e:" + media(vet));

        System.out.println("Valores digitados:");
        mostrar(vet);
    }
    
    static void preencherVetor(int[] v){
        for (int i = 0; i < v.length; i++) {
            System.out.println("Digite o " + (i + 1) + " valor do vetor:");
            v[i] = scan.nextInt();
            
            cont++;
            
            System.out.println("Quer continuar [S/N]:");
            String resp = scan.next();
            
            if (resp.equalsIgnoreCase("n")) {
                i = 1001;
            }
        }
    }

    static int maior(int[] v) {
        int maior = 0;
        for (int i = 0; i < cont; i++) {
            if (i == 0) {
                maior = v[i];
            } else if (v[i] > maior) {
                maior = v[i];
            }
        }
        return maior;
    }

    static int menor(int[] v) {
        int menor = 0;
        for (int i = 0; i < cont; i++) {
            if (i == 0) {
                menor = v[i];
            } else if (menor > v[i]) {
                menor = v[i];
            }
        }
        return menor;
    }

    static void mostrar(int[] v) {
        for (int i = 0; i < cont; i++) {
            System.out.println("Valor" + (i + 1) + "=" + v[i]);
        }
    }

    static double media(int[] v) {
        int count = 0;
        double media;
        for (int i = 0; i < cont; i++) {
            count += v[i];
        }
        media = count / cont;
        return media;
    }
}
