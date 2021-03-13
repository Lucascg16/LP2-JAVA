package arquivos;
import java.io.*;
import java.util.Scanner;
/*
Em uma institui��o de ensino, os dados necess�rios para calcular a m�dia final
 de um aluno foram agrupados da seguinte maneira:
	�	C�digo do aluno.
	�	Nome do aluno.
	�	Nota 1.
	�	Nota 2.
	a) Declare uma classe capaz de armazenar os valores. 
	b) Crie uma estrutura para armazenar as informa��es em um arquivo texto.
	c) Crie um menu com as op��es: 
	�	Inserir um novo registro.
	�	Alterar um registro.
	�	Calcular a m�dia final (neste item, a m�dia aritm�tica dever� ser calculada a partir das notas 1 e 2; 
	tamb�m dever�o ser emitidas as mensagens: �Aprovado�, para alunos com m�dia superior ou igual a 7,0,
	 e �N�o atingiu a m�dia� para os demais).
 */


public class AlunosMain {
	static StringBuffer memoria = new StringBuffer();
	static Scanner scan = new Scanner (System.in);
	public static void main(String[] args) {
		char opcao,resp='N';
		do{
			opcao = menu();
			switch (opcao){
			case '1' :
				inserirDados();
				break;
			case '2':
				alterarNotas();
				break;
			case '3':
				calcularMedia();
				break;
			case '4':
				System.out.println("Deseja realmente sair do programa? S/N");
				resp = Character.toUpperCase(scan.next().charAt(0));
				break;
			default: 
				System.out.println("op��o invalida, tente novamente");
			}
		} while	(resp!='S');
		System.exit(0);
	}

	static char menu(){
		System.out.println("\n\nEscolha uma Op��o:\n"+
				"1. Inserir novo aluno\n"+
				"2. Alterar notas do aluno\n"+
				"3. Calcular media final\n"+
				"4. Sair");
		return scan.next().charAt(0);
	} 
	static void iniciarArquivo(){
		try{
			BufferedReader arqEntrada;
			arqEntrada = new BufferedReader (new FileReader ("Alunos.txt"));
			String linha = "";
			memoria.delete(0,memoria.length());
			while ( (linha = arqEntrada.readLine()) != null ) {
				memoria.append (linha + "\n");
			}
			arqEntrada.close();
		} catch (FileNotFoundException erro){
			System.out.println("\nArquivo n�o encontrado");
		} catch (Exception e){
			System.out.println("\nErro de Leitura!");
		}
	}

	public static void gravar(){
		try{
			BufferedWriter arqSaida;
			arqSaida = new BufferedWriter(new FileWriter ("Alunos.txt"));
			arqSaida.write(memoria.toString());
			arqSaida.flush();
			arqSaida.close();
		} catch (Exception e){
			System.out.println("\nErro de gravacao!");
		}
	}
	static void inserirDados(){
		int cdaluno;
		String nome;
		double n1, n2;
		try{
			BufferedWriter saida;
			saida=new BufferedWriter(new FileWriter ("Alunos.txt",true));
			System.out.println("Digite o c�digo do aluno");
			cdaluno = scan.nextInt();
			System.out.println("Digite o nome");
			nome = scan.next();
			System.out.println("Digite a primeira nota");
			n1 = scan.nextDouble();
			System.out.println("Digite a segunda nota");
			n2 = scan.nextDouble();
			Alunos reg = new Alunos(cdaluno, nome, n1, n2);
			saida.write(reg.toString());
			saida.flush();
			saida.close();
		}catch (Exception e){
			System.out.println("\nErro de gravacao");
		}
	}	
	public static void alterarNotas() {
		String codigo, nome, n1, n2;
		int inicio, fim, ultimo, primeiro;
		boolean achou=false;
		int procura;
		iniciarArquivo();
		if (memoria.length()!=0) {
			System.out.println("\nDigite o codigo para altera��o:");
			procura= scan.nextInt();
			nome = "";
			n1 = "";
			n2 = "";
			inicio = 0;
			while ((inicio != memoria.length())&&(!achou)) {
				ultimo = memoria.indexOf ("\t", inicio);
				codigo = memoria.substring(inicio, ultimo);
				primeiro = ultimo + 1;
				ultimo = memoria.indexOf ("\t", primeiro); 
				nome = memoria.substring(primeiro, ultimo);		
				primeiro = ultimo + 1;
				ultimo = memoria.indexOf ("\t", primeiro);
				n1 = memoria.substring(primeiro, ultimo);;
				primeiro = ultimo + 1;
				fim = memoria.indexOf ("\n", primeiro);
				n2 = memoria.substring(primeiro, fim);
				Alunos reg = new Alunos (Integer.parseInt(codigo),nome,Double.parseDouble(n1),
						Double.parseDouble(n2));
				if (procura==reg.getCodigo()){
					System.out.println("\nC�digo: "+reg.getCodigo()+
							"  nome: " +reg.getNome()+
							"  nota1: "+reg.getNota1()+
							"  nota2: "+reg.getNota2());
					System.out.println("Entre com nova nota 1");
					n1= scan.next();
					reg.setNota1(Double.parseDouble(n1));
					System.out.println("Entre com nova nota 2");
					n2= scan.next();
					reg.setNota2(Double.parseDouble(n2));
					memoria.replace(inicio, fim,reg.toString());
					gravar();
					achou = true;
				}
				inicio = fim + 1;
			}
			if (achou){
				System.out.println("\naltera��o realizada com sucesso");
			}else{
				System.out.println("\nc�digo n�o encontrado");
			}
		}else{
			System.out.println("\narquivo vazio");
		}
	}

	static void calcularMedia(){
		String codigo, nome, n1, n2, resul;
		String msg= "C�digo   Nome   Nota1   Nota2   M�dia   resultado\n";
		int inicio, fim, ultimo, primeiro;
		double media;
		iniciarArquivo();
		inicio = 0;
		if (memoria.length()!=0){
			while (inicio != memoria.length()) {
				codigo="";
				nome = "";
				n1 = "";
				n2 = "";
				ultimo = memoria.indexOf ("\t", inicio);
				codigo = memoria.substring(inicio, ultimo);
				primeiro = ultimo + 1;
				ultimo = memoria.indexOf ("\t", primeiro); 
				nome = memoria.substring(primeiro, ultimo);		
				primeiro = ultimo + 1;
				ultimo = memoria.indexOf ("\t", primeiro);
				n1 = memoria.substring(primeiro, ultimo);;
				primeiro = ultimo + 1;
				fim = memoria.indexOf ("\n", primeiro);
				n2 = memoria.substring(primeiro, fim);
				Alunos reg = new Alunos (
						Integer.parseInt(codigo),
						nome,
						Double.parseDouble(n1),
						Double.parseDouble(n2));
				media = (reg.getNota1()+reg.getNota2())/2;
				if (media >= 7.0){
					resul = "Aprovado";
				}else{
					resul = "N�o atingiu a m�dia";	
				}
				msg += reg.getCodigo()+"   "+reg.getNome()+"   "+
						reg.getNota1()+"   "+reg.getNota2()+"   "+media+"   "+resul+"\n";
				inicio = fim +1;
			}	
			System.out.println(msg);
		}else{
			System.out.println("arquivo vazio");
		}
	}
}

