package prova0311;

import java.util.Scanner;

public class fabricaMain {
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        fabricaVet funcionario = new fabricaVet(100);
        int opc = 0;
        while (opc != 4) {
            System.out.println("Digite uma opcao"
                    + "\n1 - Cadastrar funcionario"
                    + "\n2 - Consultar o funcionario com menor salario"
                    + "\n3 - alterar salario de matriculas menores que 999 em 50%"
                    + "\n4 - sair do programa:");
            opc = scan.nextInt();
            switch (opc) {
                case 1:
                    cadastrarDado(funcionario);
                    break;
                case 2:
                    funcionario.mostrarSalario();
                    break;
                case 3:
                    funcionario.alterarSalario();
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
    public static void cadastrarDado(fabricaVet func){
        int matricula;
        String nome;
        double salario;
        System.out.println("Digite o seu nome:");
        nome = scan.next();
        System.out.println("Digite a sua matricula:");
        matricula = scan.nextInt();
        System.out.println("digite o salario:");
        salario = scan.nextDouble();
        fabrica fabrica = new fabrica(matricula, nome, salario);
        if (func.inserirDados(fabrica)) {
            System.out.println("inseriu com sucesso.");
        } else {
            System.out.println("não foi possivel realizar a operação.");
        }
    }
}
