package lista3;

import java.util.Scanner;

public class PautaMain {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Pauta aluno = new Pauta();//deve instaciar o não sei o nome, assim ganha-se o acesso as variaveis do objeto.
        int opc = 0;
        while (opc != 6) {
            System.out.println("Digite uma opcao"
                    + "\n1. Cadastrar um aluno"
                    + "\n2. Mostrar todos os dados do aluno"
                    + "\n3. Verificar se o aluno esta reprovado por falta"
                    + "\n4. Mostrar a media do aluno"
                    + "\n5. Mostrar situacao de aprovacao ou reprovacao"
                    + "\n6. Finalizar operacoes");
            opc = scan.nextInt();

            switch (opc) {
                case 1:
                    cadastrarAluno(aluno);
                    break;
                case 2:
                    System.out.println(aluno.toString());
                    break;
                case 3:
                    aluno.verificarReprovacaoFaltas();
                    break;
                case 4:
                    System.out.println(aluno.calcularMedia());
                    break;
                case 5:
                    System.out.println(aluno.verificarSituacao());
                    break;
                case 6:
                    System.out.println("Fim do programa.");
                    break;
                default:
                    System.out.println("Opscao invalida.");
                    break;
            }
        }
    }

    private static void cadastrarAluno(Pauta a) {
        System.out.println("Digite a matricula do aluno:");
        a.setMatricula(scan.nextInt());
        System.out.println("Digite o nome do aluno:");
        a.setNomeAluno(scan.next());
        System.out.println("Digite o numero de faltas:");
        a.setNumFalta(scan.nextInt());
        System.out.println("Digite a nota 1");
        a.setNota1(scan.nextDouble());
        System.out.println("Digite a nota 2");
        a.setNota2(scan.nextDouble());
    }
}
