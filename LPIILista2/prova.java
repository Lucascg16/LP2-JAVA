package LPIILista2;

import java.util.Scanner;

public class prova {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int tam = 3;
        String[] nome = new String[tam];
        int[] sala = new int[tam];
        double[] nota = new double[tam];

        boolean sair = false;
        int opc = 0;
        while (sair == false) {
            System.out.println("1:Cadastrar aluno"
                    + "\n2:alterar sala"
                    + "\n3:Mostrar aprovados"
                    + "\n4:sair");
            opc = scan.nextInt();

            switch (opc) {
                case 1:
                    cadastrarAluno(nome, sala, nota);
                    break;
                case 2:
                    alterarSala(nome, sala);
                    break;
                case 3:
                    System.out.println(mostrarAprovados(nome, nota));
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

    static void cadastrarAluno(String[] n, int[] sa, double[] n1) {
        for (int i = 0; i < n.length; i++) {
            System.out.println("Digite o nome do " + (i + 1) + " aluno:");
            n[i] = scan.next();
            System.out.println("Digite a nota do " + (i + 1) + " aluno:");
            n1[i] = scan.nextDouble();
            System.out.println("Digite a sala do " + (i + 1) + " aluno:");
            sa[i] = scan.nextInt();
        }
    }

    static void alterarSala(String[] n, int[] sa) {
        String procura;
        int i = 0;
        System.out.println("Digite o nome do aluno que deseja modificar:");
        procura = scan.next();
        while (i < n.length && !procura.equalsIgnoreCase(n[i])) {
            i++;
        }
        if (i == n.length) {
            System.out.println("Aluno nao encontrado.");
        } else {
            System.out.println("DIgite o numero da nova sala:");
            sa[i] = scan.nextInt();
        }
    }

    static String mostrarAprovados(String[] n, double[] n1) {
        String resposta = "";
        for (int i = 0; i < n.length; i++) {
            if (n1[i] >= 7) {
                resposta += n[i] + "\n";
            }
        }
        return resposta; 
   }
}
