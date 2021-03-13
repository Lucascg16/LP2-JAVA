package arquivos;
import java.io.*;
import java.util.Scanner;
public class ProdutosMain {
	static StringBuffer memoria = new StringBuffer();
	
	static Scanner scan = new Scanner(System.in); 
	
	public static void main(String[] args) {
		char opcao, resp='N';
		do{
			try{
				opcao = menu();
				switch(opcao){
				case '1':
					inserirProduto();
					break;
				case '2':
					alterarProduto();
					break;
				case '3':
					excluirProduto();
					break;
				case '4':
					consultarGeral();
					break;
				case '5':
					consultarProduto();
					break;
				case '6':
					System.out.println("Deseja sair?"+"\n"+"Digite S ou N");
					resp=Character.toUpperCase(scan.next().charAt(0));
					break;
				default:
					System.out.println("Opção inválida, tente novamente");
				}
			}catch(Exception erro3){
				System.out.println("Escolha uma alternativa do Menu!");
			}
		}while(resp!='S');
		System.exit(0);
	}
	/*
	 * METODO MENU:
	 */
	static char menu(){
		System.out.println("LOCADORA DE PRODUTOS PARA FESTA\n"
				+ "\nEscolha uma opção:\n"
				+ "1. Inserir novo produto\n"
				+ "2. Alterar um produto\n"
				+ "3. Excluir um produto\n"
				+ "4. Consultar estoque\n"
				+ "5. Consultar informações de um produto\n"
				+ "6. Sair");
		return scan.next().charAt(0);
	}
	//METODO PARA LIMPAR A VARIÁVEL MEMORIA E ATUALIZA-LA COM OS NOVOS DADOS
	static void iniciarArquivo(){
		String linha;
		try{
			BufferedReader arqEntrada;
			arqEntrada = new BufferedReader (new FileReader("Produto.txt"));
			linha = "";
			memoria.delete(0,memoria.length());
			while( (linha=arqEntrada.readLine()) != null){
				memoria.append(linha+"\n");
			}
			arqEntrada.close();
		}
		catch(FileNotFoundException erro1){
			System.out.println("Arquivo não encontrado.");
		}
		catch(Exception erro2){
			System.out.println("Erro de leitura!");
		}
	}
	//METODO PARA GRAVAR OS DADOS QUE ESTÃO NA VARIAVEL MEMORIA NO MEIO FISICO
	public static void gravarDados(){
		try{
			BufferedWriter arqSaida;
			arqSaida = new BufferedWriter(new FileWriter ("Produto.txt"));
			arqSaida.write(memoria.toString());
			arqSaida.flush();  //salva no dispositivo
			arqSaida.close();
		}catch(Exception erro3){
			System.out.println("Erro de gravação!");
		}
	}

	//1 - INSERIR DADOS:
	static void inserirProduto(){
		int codigo, quantidade;;
		String produto;
		double valor;
		try{
			BufferedWriter saida = new BufferedWriter(new FileWriter("Produto.txt", true));
                            
			System.out.println("Digite o código do produto");
			codigo = scan.nextInt();
			System.out.println("Digite o nome do produto");
			produto = scan.next();
			System.out.println("Digite o valor do produto");
			valor = scan.nextDouble();
			System.out.println("Digite a quantidade");
			quantidade = scan.nextInt();
			//VARIAVEL REG DO TIPO PRODUTOS RECEBE OS VALORES DIGITADOS PELO USUARIO:
			Produtos reg = new Produtos(codigo, produto, valor, quantidade);
			saida.write(reg.toString());
			saida.flush();
			saida.close();
		}
		catch(Exception erro4){
			System.out.println("Erro ao gravar, tente novamente.");
		}
	}

	//2 - ALTERAR PRODUTO:
	private static void alterarProduto() {
		String codigo, produto, valor, quantidade;
		int inicio, fim, ultimo, primeiro;
		iniciarArquivo();
		try{
			if (memoria.length()!=0) {
				System.out.println("Digite o código para alteração:");
				codigo = scan.next();
				produto = "";
				valor = "";
				quantidade = "";
				inicio = memoria.indexOf (codigo);
				if (inicio != -1){
					ultimo = memoria.indexOf("\t",inicio);
					codigo = memoria.substring(inicio, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t",primeiro);
					produto = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t", primeiro);
					valor = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					fim = memoria.indexOf("\n", primeiro);
					quantidade = memoria.substring(primeiro, fim);
					Produtos reg = new Produtos (Integer.parseInt(codigo), produto, Double.parseDouble(valor), Integer.parseInt(quantidade));
					System.out.println("Deseja alterar?"+"\n"+"Digite S ou N"+"\n\n"+
							"Nome do produto: " +reg.getProduto()+"\n"+
							"Valor: R$"+reg.getValor()+"\n"+
							"Quantidade: "+reg.getQuantidade());
					char resp = Character.toUpperCase(scan.next().charAt(0));		
					if (resp == 'S'){
						System.out.println("Entre com o novo valor: ");
						valor = scan.next();
						reg.setValor(Double.parseDouble(valor));
						System.out.println("Entre com a nova quantidade: ");
						quantidade = scan.next();
						reg.setQuantidade(Integer.parseInt(quantidade));
						memoria.replace(inicio, fim+1,reg.toString());

						System.out.println("Registro alterado.");
					} else{
						System.out.println("Alteração cancelada.");
					}	
					gravarDados();
				}else{
					System.out.println("Código não encontrado");
				}
			}else{
				System.out.println("Arquivo vazio.");
			}
		}catch(Exception erro2){
			System.out.println("Erro de leitura.");
		}
	}

	//3 - EXCLUIR PRODUTO:
	private static void excluirProduto() {
		String codigo, produto, valor, quantidade;
		int inicio, fim, ultimo, primeiro;
		iniciarArquivo();
		try{
			if (memoria.length()!=0) {
				System.out.println("Digite o código do produto que deseja excluir:");
				codigo= scan.next();
				produto = "";
				valor = "";
				quantidade = "";
				inicio = memoria.indexOf (codigo);
				if (inicio != -1){
					ultimo = memoria.indexOf("\t",inicio);
					codigo = memoria.substring(inicio, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t",primeiro);
					produto = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t", primeiro);
					valor = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					fim = memoria.indexOf("\n", primeiro);
					quantidade = memoria.substring(primeiro, fim);
					Produtos reg = new Produtos (Integer.parseInt(codigo), produto, Double.parseDouble(valor), Integer.parseInt(quantidade));
					System.out.println("Deseja excluir?"+"\n"+"Digite S ou N"+"\n\n"+"Código: "+reg.getCodigo()+"\n"+
							"Nome do produto: " +reg.getProduto()+"\n"+
							"Valor: R$"+reg.getValor()+"\n"+
							"Quantidade: "+reg.getQuantidade());
					char resp = Character.toUpperCase(scan.next().charAt(0));
					if (resp == 'S'){
						memoria.delete (inicio, fim + 1);	
						System.out.println("Registro excluido.");
						gravarDados(); 
					} else{
						System.out.println("Exclusão cancelada.");
					}
					
				}else{
					System.out.println("Código não encontrado");
				}
			}else{
				System.out.println("Arquivo vazio.");
			}
		}catch(Exception erro2){
			System.out.println("Erro de leitura.");
		}
	}

	//4 - CONSULTAR TUDO: 
	static private void consultarGeral(){
		String codigo, produto, valor, quantidade;
		String dados="\nEstoque:\n\n";
		int inicio, fim, ultimo, primeiro;
		iniciarArquivo();
		inicio = 0;
		try{
			if(memoria.length() != 0){
				while(inicio != memoria.length()){
					ultimo = memoria.indexOf("\t",inicio);
					codigo = memoria.substring(inicio, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t",primeiro);
					produto = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t", primeiro);
					valor = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					fim = memoria.indexOf("\n", primeiro);
					quantidade = memoria.substring(primeiro, fim);
					Produtos reg = new Produtos (Integer.parseInt(codigo), produto, Double.parseDouble(valor), Integer.parseInt(quantidade));
					dados+="Código: "+reg.getCodigo()+"\n"+"Produto: "+reg.getProduto()+"\n"+"Valor: R$"+reg.getValor()+"\n"+"Quantidade: "+reg.getQuantidade()+"\n\n";
					inicio = fim + 1;
				}
				System.out.println(dados);
			}else{
				System.out.println("Arquivo vazio.");
			}
		}catch(Exception erro2){
			System.out.println("Erro de leitura.");
		}
	} 

	//5 - CONSULTAR PRODUTO:
	private static void consultarProduto(){
		String codigo, produto, valor, quantidade;
		int inicio , fim, ultimo, primeiro;
		iniciarArquivo();
		try{
			if (memoria.length()!=0) {
				System.out.println("Digite o código do produto que deseja pesquisar: ");
				codigo = scan.next();
				inicio = memoria.indexOf (codigo);
				if(inicio != -1){
					ultimo = memoria.indexOf("\t",inicio);
					codigo = memoria.substring(inicio, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t",primeiro);
					produto = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t", primeiro);
					valor = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					fim = memoria.indexOf("\n", primeiro);
					quantidade = memoria.substring(primeiro, fim);
					Produtos reg = new Produtos (Integer.parseInt(codigo), produto, Double.parseDouble(valor), Integer.parseInt(quantidade));
					System.out.println("Código: "+reg.getCodigo()+"\n"+" Produto: "+reg.getProduto()+"\n"+" Valor: R$"+reg.getValor()+"\n"+" Quantidade: "+reg.getQuantidade());
				}else{
					System.out.println("Produto não cadastrado.");
				}
			}else{
				System.out.println("Arquivo vazio.");
			}

		}catch(Exception erro2){
			System.out.println("Erro de leitura.");
		}
	}
}