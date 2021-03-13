//Eu não uso acentos no codido, mesmo nos prints, por que o NetBeans não aceita.
package LPIILista2;

import java.util.Scanner;

public class ex19 {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int tam = 2;
        String[] sexo = new String[tam];
        int[] idade = new int[tam];
        double[] altura = new double[tam];

        boolean sair = false;
        int opc = 0;
        while (sair == false) {
            System.out.println("1:preencher o vetor"
                    + "\n2:mostrar os valores cadastrados"
                    + "\n3:Mostrar a quantidade de indivíduos do sexo feminino cuja idade"
                    + " esteja entre 20 a 45 anos e altura inferior a 1,70 m."
                    + "\n4:sair");
            opc = scan.nextInt();

            switch (opc) {
                case 1:
                    preencherVetor(sexo, idade, altura);
                    break;
                case 2:
                    mostrarVetor(sexo, idade, altura);
                    break;
                case 3:
                    mostrarRequisitos(sexo, idade, altura);
                    break;
                case 4:
                    sair = true;
                    System.out.println("Fim do programa...");
                    break;
                default:
                    System.out.println("opcao invalida.");
                    break;
            }
        }
    }

    static void preencherVetor(String[] s, int[] id, double[] al) {
        for (int i = 0; i < s.length; i++) {
            System.out.println("Digite o sexo do " + (i + 1) + " habitante:");
            s[i] = scan.next();
            System.out.println("Digite o idade do " + (i + 1) + " habitante:");
            id[i] = scan.nextInt();
            System.out.println("Digite o altura do " + (i + 1) + " habitante(use virgula):");
            al[i] = scan.nextDouble();
        }
    }

    static void mostrarVetor(String[] s, int[] id, double[] al) {
        for (int i = 0; i < s.length; i++) {
            System.out.println((i + 1) + " Habitante: sexo " + s[i] + ", idade " + id[i] + ", altura " + al[i]);
        }
    }

    static void mostrarRequisitos(String[] s, int[] id, double[] al) {
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if ((s[i] == "f") && (id[i] >= 20 && id[i] <= 45) && (al[i] < 1.7)) {
                count += 1;
            }
        }
        System.out.println("Habitantes encontrados com esses requisitos:" + count);
    }
}
