package lista4;

import java.util.Scanner;

public class contaMain {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        conta cliente = new conta();
        int opc = 0;
        while (opc != 5) {
            System.out.println("Digite uma opcao"
                    + "\n1 - Cadastrar uma conta de cliente"
                    + "\n2 - Mostrar saldo da conta"
                    + "\n3 - Sacar dinheiro da conta"
                    + "\n4 - Depositar dinheiro na conta"
                    + "\n5 - Finalizar operacoes");
            opc = scan.nextInt();
            
            switch(opc){
                case 1:
                    cadastrarCliente(cliente);
                    break;
                case 2:
                    System.out.println(cliente.getSaldo());
                    break;
                case 3:
                    System.out.println("Digite o valor a ser sacado:");
                    double saque = scan.nextDouble();
                    cliente.fazerSaque(saque);
                    if(cliente.fazerSaque == true){
                        System.out.println("Saque feito com sucesso");
                    }
                    else{
                        System.out.println("Saldo insuficiente");
                    }
                    break;
                case 4:
                    System.out.println("Digite o valor a ser depositado:");
                    double depo = scan.nextDouble();
                    cliente.fazerDeposito(depo);
                    System.out.println("Valor depositado com sucesso.");
                    break;
                case 5:
                    System.out.println("Fim do programa...");
                    break;
                default:
                    System.out.println("opc invalida.");
                    break;
            }
        }
    }
    private static void cadastrarCliente(conta a){
        System.out.println("Digite o numero da conta:");
        a.setNumeroConta(scan.nextInt());
        System.out.println("Digite o nome do titular:");
        a.setTitular(scan.next());
        System.out.println("Digite o saldo disponivel(ignora essa, apenas aprendizado...):");
        a.setSaldo(scan.nextDouble());
    }
}

