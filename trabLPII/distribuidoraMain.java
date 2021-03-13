package trabLPII;

import java.io.*;
import javax.swing.JOptionPane;

public class distribuidoraMain {

    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        int opc = 0;
        while (opc != 7) {
            try {
                opc = Integer.parseInt(JOptionPane.showInputDialog("Distribuidora de produtos\n"
                        + "\nEscolha uma opção:\n"
                        + "1. Inserir novo produto\n"
                        + "2. Alterar um produto\n"
                        + "3. Excluir um produto\n"
                        + "4. Consultar estoque\n"
                        + "5. Consultar informações de um produto\n"
                        + "6. consultar regiões\n"
                        + "7. Sair"));
                switch (opc) {
                    case 1:
                        inserirProduto();
                        break;
                    case 2:
                        alterarProduto();
                        break;
                    case 3:
                        excluirProduto();
                        break;
                    case 4:
                        ConsultarEstoque();
                        break;
                    case 5:
                        consultarProduto();
                        break;
                    case 6:
                        consultarRegiao();
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Fim do programa.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "opcão invalida");
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Escolha uma opção");
            }
        }
    }

    static void iniciarArquivo() {
        String linha;
        try {
            BufferedReader arqEntrada;
            arqEntrada = new BufferedReader(new FileReader("Produtos.txt"));
            linha = "";
            memoria.delete(0, memoria.length());
            while ((linha = arqEntrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }
            arqEntrada.close();

        } catch (FileNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na leitura");
        }
    }

    static void iniciarRegiao() {
        String linha;
        try {
            BufferedReader arqEntrada;
            arqEntrada = new BufferedReader(new FileReader("Regiao.txt"));
            linha = "";
            memoria.delete(0, memoria.length());
            while ((linha = arqEntrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }
            arqEntrada.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na leitura");
        }
    }

    static void gravarArquivo() {
        try {
            BufferedWriter arqSaida;
            arqSaida = new BufferedWriter(new FileWriter("Produtos.txt"));
            arqSaida.write(memoria.toString());
            arqSaida.flush();
            arqSaida.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na gravação.");
        }
    }

    static void inserirProduto() {
        int codigo, quantidade, codR;
        String produto;
        double valor;
        try {
            BufferedWriter saida = new BufferedWriter(new FileWriter("Produtos.txt", true));
            BufferedWriter saidaR = new BufferedWriter(new FileWriter("Regiao.txt", true));

            codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo Do produto:"));
            produto = JOptionPane.showInputDialog("Digite o nome do produto");
            quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade:"));
            valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto"));
            codR = Integer.parseInt(JOptionPane.showInputDialog("Codigo da região"));

            Produto reg = new Produto(codigo, produto, valor, quantidade, codR);
            Regiao Reg = new Regiao(codR);

            saidaR.write(Reg.toString());
            saidaR.flush();
            saidaR.close();
            saida.write(reg.toString());
            saida.flush();
            saida.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao gravar, tente novamente.");
        }
    }

    static void alterarProduto() {
        String codigo, quantidade, codigoReg, produto, valor, resp;
        int inicio, fim, ultimo, primeiro;
        boolean achou = false;
        int procura = 0;
        iniciarArquivo();

        if (memoria.length() != 0) {
            procura = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto para ser alterado: "));
            produto = "";
            valor = "";
            quantidade = "";
            codigoReg = "";
            inicio = 0;
            while ((inicio != memoria.length()) && (!achou)) {
                ultimo = memoria.indexOf("\t", inicio);
                codigo = memoria.substring(inicio, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                produto = memoria.substring(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                valor = memoria.substring(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                quantidade = memoria.substring(primeiro, ultimo);
                primeiro = ultimo + 1;

                fim = memoria.indexOf("\n", primeiro);
                codigoReg = memoria.substring(primeiro, fim);

                Produto Reg = new Produto(Integer.parseInt(codigo), produto,
                        Double.parseDouble(valor), Integer.parseInt(quantidade), Integer.parseInt(codigoReg));

                if (procura == Reg.getCod()) {
                    resp = JOptionPane.showInputDialog(null, "Deseja alterar?" + "\n" + "Digite S ou N" + "\n\n"
                            + "Nome do produto: " + Reg.getNome() + "\n"
                            + "Valor: R$" + Reg.getValor() + "\n"
                            + "Quantidade: " + Reg.getQtd());
                    if (resp.equalsIgnoreCase("S")) {
                        resp = JOptionPane.showInputDialog("Deseja trocar o nome? S ou N");
                        if (resp.equalsIgnoreCase("S")) {
                            produto = JOptionPane.showInputDialog("Digite o novo nome.");
                            Reg.setNome(produto);
                        }
                        valor = JOptionPane.showInputDialog("Digite o novo valor");
                        Reg.setValor(Double.parseDouble(valor));

                        quantidade = JOptionPane.showInputDialog("Digite a nova quantidade.");
                        Reg.setQtd(Integer.parseInt(quantidade));

                        memoria.replace(inicio, fim + 1, Reg.toString());

                        JOptionPane.showMessageDialog(null, "Produto alterado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Alteração cancelada");
                    }
                    gravarArquivo();
                    achou = true;
                }
                inicio = fim + 1;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não ah produtos no sistema");
        }
    }

    static void excluirProduto() {
        String codigo, produto, codigoReg, valor, quantidade, resp;
        int inicio = 0, fim, ultimo, primeiro;
        int procura = 0;
        boolean achou = false;
        iniciarArquivo();
        try {
            if (memoria.length() != 0) {
                procura = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto que deseja excluir"));
                produto = "";
                valor = "";
                quantidade = "";
                inicio = 0;
                while ((inicio != memoria.length()) && (!achou)) {
                    ultimo = memoria.indexOf("\t", inicio);
                    codigo = memoria.substring(inicio, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    produto = memoria.substring(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    valor = memoria.substring(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    ultimo = memoria.indexOf("\t", primeiro);
                    quantidade = memoria.substring(primeiro, ultimo);
                    primeiro = ultimo + 1;

                    fim = memoria.indexOf("\n", primeiro);
                    codigoReg = memoria.substring(primeiro, fim);

                    Produto Reg = new Produto(Integer.parseInt(codigo), produto,
                            Double.parseDouble(valor), Integer.parseInt(quantidade), Integer.parseInt(codigoReg));
                    if (procura == Reg.getCod()) {
                        resp = JOptionPane.showInputDialog("Deseja alterar?" + "\n" + "Digite S ou N" + "\n\n"
                                + "Nome do produto: " + Reg.getNome() + "\n"
                                + "Valor: R$" + Reg.getValor() + "\n"
                                + "Quantidade: " + Reg.getQtd());
                        if (resp.equalsIgnoreCase("S")) {
                            memoria.delete(inicio, fim + 1);
                            JOptionPane.showMessageDialog(null, "Produto excluido");
                            gravarArquivo();
                        } else {
                            JOptionPane.showMessageDialog(null, "Exclusão cancelada");
                        }
                    }
                    inicio = fim + 1;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não ah produtos no sistema");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura");
        }
    }

    static void ConsultarEstoque() {
        String codigo, produto, codigoReg, valor, quantidade, resp;
        String dados = "\nEstoque\n\n";
        int inicio = 0, fim, ultimo, primeiro;
        iniciarArquivo();
        if (memoria.length() != 0) {
            produto = "";
            valor = "";
            quantidade = "";
            inicio = 0;
            while ((inicio != memoria.length())) {
                ultimo = memoria.indexOf("\t", inicio);
                codigo = memoria.substring(inicio, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                produto = memoria.substring(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                valor = memoria.substring(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                quantidade = memoria.substring(primeiro, ultimo);
                primeiro = ultimo + 1;

                fim = memoria.indexOf("\n", primeiro);
                codigoReg = memoria.substring(primeiro, fim);

                Produto Reg = new Produto(Integer.parseInt(codigo), produto,
                        Double.parseDouble(valor), Integer.parseInt(quantidade), Integer.parseInt(codigoReg));
                dados += "Código: " + Reg.getCod() + "\n" + "Produto: " + Reg.getNome() + "\n" + "Valor: R$" + Reg.getValor()
                        + "\n" + "Quantidade: " + Reg.getQtd() + "\n\n";
                inicio = fim + 1;
            }
            JOptionPane.showMessageDialog(null, dados);
        } else {
            JOptionPane.showMessageDialog(null, "Não ah produtos no estoque.");
        }
    }

    static void consultarProduto() {
        String codigo, produto, codigoReg, valor, quantidade, resp;
        int inicio = 0, fim, ultimo, primeiro;
        int procura = 0;
        iniciarArquivo();
        if (memoria.length() != 0) {
            procura = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto que deseja consultar"));
            produto = "";
            valor = "";
            quantidade = "";
            inicio = 0;
            while ((inicio != memoria.length())) {
                ultimo = memoria.indexOf("\t", inicio);
                codigo = memoria.substring(inicio, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                produto = memoria.substring(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                valor = memoria.substring(primeiro, ultimo);
                primeiro = ultimo + 1;

                ultimo = memoria.indexOf("\t", primeiro);
                quantidade = memoria.substring(primeiro, ultimo);
                primeiro = ultimo + 1;

                fim = memoria.indexOf("\n", primeiro);
                codigoReg = memoria.substring(primeiro, fim);

                Produto Reg = new Produto(Integer.parseInt(codigo), produto,
                        Double.parseDouble(valor), Integer.parseInt(quantidade), Integer.parseInt(codigoReg));
                if (procura == Reg.getCod()) {
                    JOptionPane.showMessageDialog(null,
                            "Nome do produto: " + Reg.getNome() + "\n"
                            + "Valor: R$" + Reg.getValor() + "\n"
                            + "Quantidade: " + Reg.getQtd());
                }
                inicio = fim + 1;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não a produtos no estoque.");
        }
    }

    static void consultarRegiao() {
        String codigoReg;
        String dados = "\nRegiões\n\n";
        int inicio, fim, ultimo, primeiro;
        iniciarRegiao();
        try {
            if (memoria.length() != 0) {
                codigoReg = "";
                inicio = 0;
                while ((inicio != memoria.length())) {
                    ultimo = memoria.indexOf("\n", inicio);
                    codigoReg = memoria.substring(inicio, ultimo);
                    primeiro = ultimo + 1;

                    Regiao Reg = new Regiao(Integer.parseInt(codigoReg));
                    dados += "Código: " + Reg.getCodR() + "\n";
                    inicio = ultimo + 1;
                }
                JOptionPane.showMessageDialog(null, dados);
            } else {
                JOptionPane.showMessageDialog(null, "Não ah regiões cadastradas.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }
}
