package lista5_Alunos;

import java.util.Scanner;
import static lista5_filme.filmeMain.cadastrarFilme;

public class alunoMain {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        alunoVet turma = new alunoVet(5);
        int opc = 0;
        while (opc != 4) {
            System.out.println("Digite uma opcao"
                    + "\n1 - Cadastrar aluno"
                    + "\n2 - consutar notas abaixo de 6"
                    + "\n3 - mostrar media de notas dos alunos"
                    + "\n4 - Sair");
            opc = scan.nextInt();

            switch (opc) {
                case 1:
                    cadastrarAluno(turma);
                    break;
                case 2:
                    int valorDeMedia = 6;
                    System.out.println(turma.consultarAlunos(valorDeMedia));
                    break;
                case 3:
                    System.out.println(turma.calcularMedia());
                    break;
                case 4:
                    System.out.println("Fim do programa...");
                    break;
                default:
                    System.out.println("opc invalida.");
                    break;
            }
        }
    }
    static void cadastrarAluno(alunoVet turma){
        int matricula;
        String nome;
        double nota1, nota2;
        System.out.println("Digite a matricula:");
        matricula = scan.nextInt();
        System.out.println("Digite o nome do aluno:");
        nome = scan.next();
        System.out.println("Digite a nota 1 do aluno:");
        nota1 = scan.nextDouble();
        System.out.println("Digite a nota 2 do aluno:");
        nota2 = scan.nextDouble();
        aluno aluno = new aluno(matricula, nome, nota1, nota2);
        if(turma.inserirAluno(aluno)){
            System.out.println("inseriu com sucesso.");
        }else{
            System.out.println("nao foi possivel realizar a operação.");
        }
    }
}
