package arquivos;
import java.io.*;
//import javax.swing.JOptionPane;
import java.util.Scanner;

public class TremMain {

	static StringBuffer memoria = new StringBuffer();
	static Scanner scan = new Scanner(System.in); 

	public static void main(String[] args) {
		char opcao,resp='N';
		do{
			opcao = menu();
			switch (opcao){
			case '1':
				inserirDados();
				break;
			case '2':
				alterarDados();
				break;
			case '3':
				excluirDados();
				break;
			case '4':
				consultarGeral();
				break;
			case '5':
				consultarDestino();
				break;
			case '6':
				consultarTurno();
				break;
			case '7':
				System.out.println("Deseja realmente sair do programa? S/N");
				resp = Character.toUpperCase(scan.next().charAt(0));
				break;
			default: 
				System.out.println("opção invalida. Escolha outra opção do menu.");
			}
		} while	(resp!='S');
		System.out.println("Programa finalizado.\n"+
				"Feito por Mariah e Wellington.");
		System.exit(0);

	}

	// MENU:
	static char menu(){
		System.out.println("\n\nEscolha uma Opção:\n"+
				"1. Inserir dados do trem\n"+
				"2. Alterar dados do trem\n"+
				"3. Excluir dados do cadastro\n"+
				"4. Consultar dados do trem\n"+
				"5. Pesquisar um destino\n"+
				"6. Pesquisar um turno\n"+
				"7. Sair");
		return scan.next().charAt(0);
	} 

	// 1 - INICIAR ARQUIVO: (METODO PARA LIMPAR A VARIÁVEL MEMORIA E ATUALIZA-LA COM OS NOVOS DADOS)
	static void iniciarArquivo(){
		try{
			BufferedReader arqEntrada;
			arqEntrada = new BufferedReader (new FileReader ("Trem.txt"));
			String linha = "";
			memoria.delete(0,memoria.length());
			while ( (linha = arqEntrada.readLine()) != null ) {
				memoria.append (linha + "\n");
			}
			arqEntrada.close();
		} catch (FileNotFoundException erro){
			System.out.println("\nArquivo nao encontrado");
		} catch (Exception e){
			System.out.println("\nErro de Leitura !");
		}
	}

	// 2 - GRAVAR:
	public static void gravarDados (){
		try{
			BufferedWriter arqSaida;
			arqSaida = new BufferedWriter(new FileWriter ("Trem.txt"));
			arqSaida.write(memoria.toString());
			arqSaida.flush();
			arqSaida.close();
		} catch (Exception e){
			System.out.println("\nErro de gravacao!");
		}
	}

	//3 - INSERIR DADOS:
	static void inserirDados() {
		String numeroTrem, destino, classe, turno; 
		try{
			BufferedWriter saida;
			saida=new BufferedWriter(new FileWriter ("Trem.txt",true));
			System.out.println("Digite o numero do trem");
			numeroTrem = scan.next();
			System.out.println("Digite o destino");
			destino = scan.next();
			System.out.println("Digite o turno escolhido");
			turno = scan.next();
			System.out.println("Digite o classe");
			classe = scan.next();
			Trem reg = new Trem (Integer.parseInt(numeroTrem), destino, turno, classe);
			saida.write (reg.toString());
			saida.flush ();
			saida.close ();
			System.out.println("Operação realizada com sucesso");
		}catch (Exception e){
			System.out.println("Erro de gravacao");
		}

	}

	// 4- ALTERAR DADOS:
	static void alterarDados() {
		String numeroTrem, destino, classe, turno;
		int inicio, fim, ultimo, primeiro;
		iniciarArquivo();

		try{
			if (memoria.length()!=0) {
				System.out.println("Digite o número do trem que deseja alterar:");
				numeroTrem = scan.next();
				destino = "";
				classe = "";
				turno = "";
				inicio = memoria.indexOf (numeroTrem);
				if (inicio != -1){
					ultimo = memoria.indexOf("\t",inicio);
					numeroTrem = memoria.substring(inicio, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t",primeiro);
					destino = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t", primeiro);
					classe = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					fim = memoria.indexOf("\n", primeiro);
					turno = memoria.substring(primeiro, fim);
					Trem reg = new Trem (Integer.parseInt(numeroTrem), destino, classe, turno);
					System.out.println("Deseja alterar?"+"\n"+"Digite S ou N"+"\n\n"+
							"Destino: "+reg.getDestino()+"\n"+
							"Classe: "+reg.getClasse()+"\n"+
							"Turno: "+reg.getTurno());
					char resp = Character.toUpperCase(scan.next().charAt(0));		
					if (resp == 'S'){
						System.out.println("Entre com o novo destino: ");
						destino = scan.next();
						reg.setDestino(destino);
						System.out.println("Entre com a nova classe: ");
						classe = scan.next();
						reg.setClasse(classe);
						System.out.println("Entre com o novo turno: ");
						turno = scan.next();
						reg.setTurno(turno);
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


	//5 - EXCLUIR DADOS
	private static void excluirDados() {
		String numeroTrem, destino, classe, turno;
		int inicio, fim, ultimo, primeiro;
		iniciarArquivo();
		try{
			if (memoria.length()!=0) {
				System.out.println("Digite o número do trem que deseja excluir:");
				numeroTrem= scan.next();
				destino = "";
				classe = "";
				turno = "";
				inicio = memoria.indexOf (numeroTrem);
				if (inicio != -1){
					ultimo = memoria.indexOf("\t",inicio);
					numeroTrem = memoria.substring(inicio, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t",primeiro);
					destino = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t", primeiro);
					classe = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					fim = memoria.indexOf("\n", primeiro);
					turno = memoria.substring(primeiro, fim);
					Trem reg = new Trem (Integer.parseInt(numeroTrem), destino, classe, turno);
					System.out.println("Deseja excluir?"+"\n"+"Digite S ou N"+"\n\n"+
							"Número do trem: " +reg.getNumeroTrem()+"\n"+
							"Destino: "+reg.getDestino()+"\n"+
							"Classe: "+reg.getClasse()+"\n"+
							"Turno: "+reg.getTurno());
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

	// 6 - CONSULTA GERAL
	static private void consultarGeral(){
		String numeroTrem, destino, classe, turno;
		String dados="\nTrens cadastrados:\n\n";
		int inicio, fim, ultimo, primeiro;
		iniciarArquivo();
		inicio = 0;
		try{
			if(memoria.length() != 0){
				while(inicio != memoria.length()){
					ultimo = memoria.indexOf("\t",inicio);
					numeroTrem = memoria.substring(inicio, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t",primeiro);
					destino = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t", primeiro);
					classe = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					fim = memoria.indexOf("\n", primeiro);
					turno = memoria.substring(primeiro, fim);
					Trem reg = new Trem(Integer.parseInt(numeroTrem), destino, classe, turno);
					dados+="Número do trem: "+reg.getNumeroTrem()+"\n"+
							"Destino: "+reg.getDestino()+"\n"+
							"Classe: "+reg.getClasse()+"\n"+
							"Turno: "+reg.getTurno()+"\n\n";
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

	// 7 - CONSULTA ESPECÍFICA PARA O DESTINO DO TREM
	private static void consultarDestino(){
		String destinoPesquisa, destino, classe, turno, numeroTrem;
		int inicio , fim, ultimo, primeiro;
		iniciarArquivo();
		inicio = 0;
		boolean achou = false;
		try{
			if (memoria.length()!=0) {
				System.out.println("Digite o destino que deseja pesquisar: ");
				destinoPesquisa = scan.next();
				while (inicio != memoria.length() && !achou) {
					ultimo = memoria.indexOf("\t",inicio);
					numeroTrem = memoria.substring(inicio, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t",primeiro);
					destino = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t", primeiro);
					turno = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					fim = memoria.indexOf("\n", primeiro);
					classe = memoria.substring(primeiro, fim);
					Trem reg = new Trem (Integer.parseInt(numeroTrem), destino, classe, turno);
					if (reg.getDestino().equalsIgnoreCase(destinoPesquisa)) {
						System.out.println("Destino: "+reg.getDestino()+"\n"+
								"Classe: "+reg.getClasse()+"\n"+
								"Turno: "+reg.getTurno()+"\n"+ 
								"NumeroTrem: "+reg.getNumeroTrem()+"\n\n");
						achou = true;
					}
					inicio = fim + 1;
				}
				if (!achou){
					System.out.println("Destino não encontrado.");
				}
			}
		}catch(Exception erro2){
			System.out.println("Erro de leitura.");
		}
	}


	// 8 - CONSULTA ESPECÍFICA PARA O TURNO DO TREM
	private static void consultarTurno(){
		String turnoPesquisa, numeroTrem, destino, classe, turno;
		int inicio , fim, ultimo, primeiro;
		iniciarArquivo();
		inicio = 0;
		try{
			if (memoria.length()!=0) {
				System.out.println("Digite o turno que deseja pesquisar: ");
				turnoPesquisa = scan.next();
				while (inicio != memoria.length()) {
					ultimo = memoria.indexOf("\t",inicio);
					numeroTrem = memoria.substring(inicio, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t",primeiro);
					destino = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					ultimo = memoria.indexOf("\t", primeiro);
					turno = memoria.substring(primeiro, ultimo);
					primeiro = ultimo + 1;
					fim = memoria.indexOf("\n", primeiro);
					classe = memoria.substring(primeiro, fim);
					Trem reg = new Trem (Integer.parseInt(numeroTrem), destino, turno, classe);
					if (reg.getTurno().equalsIgnoreCase(turnoPesquisa)) 
						System.out.println("Destino: "+reg.getDestino()+"\n"+
								"Classe: "+reg.getClasse()+"\n"+
								"Turno: "+reg.getTurno()+"\n"+ 
								"Destino: "+reg.getDestino()+"\n\n");
					inicio = fim +1;
				}
			}else{
				System.out.println("Arquivo vazio.");
			}

		}catch(Exception erro2){
			System.out.println("Erro de leitura.");
		}
	}
}
