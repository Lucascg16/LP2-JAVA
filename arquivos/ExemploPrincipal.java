package arquivos;

import java.io.*;
import java.util.Scanner;

public class ExemploPrincipal {
	
	static StringBuffer memoria = new StringBuffer();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		char op;
		do{
			op = menu();
			switch(op){
			case '1':
				incluirDados();
				break;
			case '2':
				mostrarAgenda();
				break;
			case '3':
				excluirAgenda();
				break;
			case '4':
				alterarAgenda();
				break;
			case '5':
				System.out.println("fim");
				break;
			default:
				System.out.println("Opção inválida");
			}
		}while(op!='5');
	}
	private static void incluirDados() {
		String nome, end, tel;
		try{
			BufferedWriter saida;
			saida=new BufferedWriter(new FileWriter ("Agenda.txt",true));
			System.out.println("Digite o nome");
			nome = scan.next();
			System.out.println("Digite o endereço");
			end = scan.next();
			System.out.println("Digite o telefone");
			tel = scan.next();
			RegAgenda reg = new RegAgenda(nome, end, tel);
			saida.write (reg.toString());
			saida.flush ();
			saida.close ();
		}catch (Exception e){
			System.out.println("Erro de gravacao");
		}

	}
	private static void mostrarAgenda() {
		String nome, end, tel;
		String msg= "Agenda\n";
		int inicio, fim, ultimo, primeiro;
		iniciarArquivo();
		inicio = 0;
		if (memoria.length()!=0){
			while (inicio != memoria.length()) {
				nome="";
				end = "";
				tel = "";
				ultimo = memoria.indexOf ("\t", inicio);
				nome = ler (inicio, ultimo);
				primeiro = ultimo + 1;
				ultimo = memoria.indexOf ("\t", primeiro); 
				end = ler (primeiro, ultimo);		
				primeiro = ultimo + 1;
				fim = memoria.indexOf ("\n", primeiro);
				tel = ler (primeiro, fim);
				RegAgenda reg = new RegAgenda(nome, end, tel);
				msg+=reg.toString();
				inicio = fim +1;
			}	
			System.out.println(msg);
		}else{
			System.out.println("arquivo vazio");
		}

	}
	private static void excluirAgenda() {
		String nome,linha;
		char resp;
		int inicio , fim;
		iniciarArquivo();
		if (memoria.length()!=0) {
			System.out.println("Digite o nome para exclusão:");
			nome = scan.next();
			inicio = memoria.indexOf (nome);
			if (inicio != -1){
				fim = memoria.indexOf ("\n", inicio);
				linha = ler (inicio, fim);
				System.out.println("Deseja excluir? Digite S ou N \n"+linha);
				resp = Character.toUpperCase(scan.next().charAt(0));
				if (resp == 'S'){
					memoria.delete (inicio, fim + 1);
					gravar(); 
					System.out.println("Registro excluido.");
				} else{
					System.out.println("Exclusão cancelada.");
				}
			}else{
				System.out.println("pessoa nao encontrado");
			}
		}

	}
	private static void alterarAgenda() {
		String nome, end, tel;
		int inicio, fim, ultimo, primeiro;
		iniciarArquivo();
		if (memoria.length()!=0) {
			System.out.println("Digite o nome para alteração:");
			nome= scan.next();
			end = "";
			tel = "";
			inicio = memoria.indexOf (nome);
			if (inicio != -1){
				ultimo = memoria.indexOf ("\t", inicio);
				nome = ler (inicio, ultimo);
				primeiro = ultimo + 1;
				ultimo = memoria.indexOf ("\t", primeiro); 
				end = ler (primeiro, ultimo);		
				primeiro = ultimo + 1;
				fim = memoria.indexOf ("\n", primeiro);
				tel = ler (primeiro, fim);
				RegAgenda reg = new RegAgenda (nome, end, tel);
				System.out.println("nome: "+reg.getNome()+
						"endereço: " +reg.getEnd()+
						"telefone: "+reg.getTel());
				System.out.println("Entre com novo nome");
				nome= scan.next();
				reg.setNome(nome);
				System.out.println("Entre com novo endereço");
				end=scan.next();
				reg.setEnd(end);
				System.out.println("Entre com novo telefone");
				tel=scan.next();
				reg.setTel(tel);
				memoria.replace(inicio, fim+1,reg.toString());
				gravar(); 
			}else{
				System.out.println("código não encontrado");
			}
		}

	}
	private static char menu() {
		System.out.println("Menu Principal\n" +
				"1 - Incluir pessoa\n" +
				"2 - Mostrar Agenda\n" +
				"3 - Excluir pessoa\n" +
				"4 - Alterar dados por pessoa\n"+
				"5 - Sair");
		return scan.next().charAt(0);
	}
	static void iniciarArquivo(){
		String linha;
		try{
			BufferedReader arqEntrada;
			arqEntrada = new BufferedReader (new FileReader ("Agenda.txt"));
			linha = "";
			memoria.delete(0,memoria.length());
			while ( (linha = arqEntrada.readLine()) != null ) {
				memoria.append (linha + "\n");
			}
			arqEntrada.close();
		} catch (FileNotFoundException erro){
			System.out.println("Arquivo nao encontrado");
		} catch (Exception e){
			System.out.println("Erro de Leitura !");
		}
	}
	public static String ler (int primeiro, int ultimo){
		String dados = "";
		dados = memoria.substring(primeiro, ultimo);
		return dados;
	}

	public static void gravar (){
		try{
			BufferedWriter arqSaida;
			arqSaida = new BufferedWriter (new FileWriter ("Agenda.txt"));
			arqSaida.write (memoria.toString ());
			arqSaida.flush ();
			arqSaida.close ();
		} catch (Exception erro){
			System.out.println("Erro de gravacao!");
		}
	}
}