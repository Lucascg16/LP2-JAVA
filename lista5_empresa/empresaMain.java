package lista5_empresa;

import java.util.Scanner;

public class empresaMain {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        empresaVet vendedor = new empresaVet(3);
        int opc = 0;
        while (opc != 4) {
            System.out.println("Digite uma opcao"
                    + "\n1 - Cadastrar uma venda"
                    + "\n2 - Consultar o numero de vendas por tipo de produto"
                    + "\n3 - Demitir vendedor"
                    + "\n4 - sair do programa:");
            opc = scan.nextInt();
            switch (opc) {
                case 1:
                    cadastrarDado(vendedor);
                    break;
                case 2:
                    contarVendedor(vendedor);
                    break;
                case 3:
                    System.out.println("digite o nome do vendedor a ser demitido:");
                    String nome = scan.next();
                    System.out.println(vendedor.excluirVendedor(nome));
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

    public static void cadastrarDado(empresaVet v) {
        int cod;
        String nome, tipo;
        System.out.println("Digite o nome do vendedor:");
        nome = scan.next();
        System.out.println("Digite o codigo do vendedor:");
        cod = scan.nextInt();
        System.out.println("Digite o tipo do produdo vendido(P – perecível, N – não perecível):");
        tipo = scan.next();
        empresa empresa = new empresa(cod, nome, tipo);
        if (v.inserirDados(empresa)){
            System.out.println("inseriu com sucesso.");
        } else {
            System.out.println("não foi possivel realizar a operação.");
        }
    }
    public static void contarVendedor(empresaVet v){
        String tipo;
        System.out.println("Digite o tipo de produto que deseja contar o numero de vendas:");
        tipo =  scan.next();
        System.out.println(v.contarVendedor(tipo));
    }
}
