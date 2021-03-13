package arquivos;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;
public class ExemploIncluir {
	static Scanner scan = new Scanner (System.in);
	public static void main(String args[]){
		try{
			//String arquivo = EscolherArquivo.caminho();
			BufferedWriter saida;
			saida = new BufferedWriter(new FileWriter("Agenda.txt",true));     ///"e:\\agenda.txt", true));
			String nome = JOptionPane.showInputDialog("Digite o nome").toUpperCase();
			System.out.println("Digite o endereço");
			String end = JOptionPane.showInputDialog("Digite o endereço").toUpperCase();
			System.out.println("Digite o telefone");
			String tel = JOptionPane.showInputDialog("Digite o telefone");
			RegAgenda regAg = new RegAgenda(nome, end, tel);
			saida.write (regAg.toString());
			saida.flush();
			saida.close();
			JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro na gravação.");
		}
	}
}
