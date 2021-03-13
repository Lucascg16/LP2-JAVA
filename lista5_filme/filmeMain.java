package lista5_filme;

import java.util.Scanner;

public class filmeMain {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        filmeVet locadora = new filmeVet(5);
        int opc = 0;
        while (opc != 4) {
            System.out.println("Digite uma opcao"
                    + "\n1 - Cadastrar filmes"
                    + "\n2 - Contar filmes de um deterinado genero"
                    + "\n3 - Excluir filme"
                    + "\n4 - Sair");
            opc = scan.nextInt();

            switch (opc) {
                case 1:
                    cadastrarFilme(locadora);
                    break;
                case 2:
                    contarGenero(locadora);
                    break;
                case 3:
                    System.out.println("digite o titulo do filme a ser excluido:");
                    String nome = scan.next();
                    System.out.println(locadora.excluirFilme(nome));
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

    public static void cadastrarFilme(filmeVet loc) {
        int cod;
        String titulo, genero;
        System.out.println("Digite o codigo:");
        cod = scan.nextInt();
        System.out.println("Digite o titulo:");
        titulo = scan.next();
        System.out.println("digite o genero: A – ação, T – terror, D – drama:");
        genero = scan.next();
        filme filme = new filme(cod, titulo, genero);
        if (loc.inserirDados(filme)) {
            System.out.println("inseriu com sucesso.");
        } else {
            System.out.println("não foi possivel realizar a operação.");
        }
    }

    static void contarGenero(filmeVet loc) {
        String genero;
        System.out.println("digite o genero que deseja: A – ação, T – terror, D – drama");
        genero = scan.next();
        System.out.println(loc.contarGenero(genero));
    }
}
