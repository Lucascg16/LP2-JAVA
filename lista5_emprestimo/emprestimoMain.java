package lista5_emprestimo;

import java.util.Scanner;

public class emprestimoMain {
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        emprestimoVet cliente = new emprestimoVet(3);
        int opc = 0;
        while (opc != 4) {
            System.out.println("Digite uma opcao"
                    + "\n1 - Cadastrar novo emprestimo"
                    + "\n2 - Consultar os juros mensais"
                    + "\n3 - alterar valor do maior emprestimo"
                    + "\n4 - sair do programa:");
            opc = scan.nextInt();
            switch (opc) {
                case 1:
                    cadastrarDado(cliente);
                    break;
                case 2:
                    cliente.calcularJuros();
                    break;
                case 3:
                    System.out.println("digite o valor a ser alterado:");
                    double valor = scan.nextDouble();
                    cliente.alterarValor(valor);
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
    public static void cadastrarDado(emprestimoVet c) {
        double valor, juros;
        String nome;
        System.out.println("Digite o nome do cliente:");
        nome = scan.next();
        System.out.println("Digite o valor do emprestimo:");
        valor = scan.nextDouble();
        System.out.println("Digite a taxa de juros:");
        juros = scan.nextDouble();
        emprestimo emprestimo = new emprestimo(nome, valor, juros);
        if (c.inserirDados(emprestimo)){
            System.out.println("inseriu com sucesso.");
        } else {
            System.out.println("não foi possivel realizar a operação.");
        }
    }
}
