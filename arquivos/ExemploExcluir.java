package arquivos;
import javax.swing.JOptionPane;
import java.io.*;
public class ExemploExcluir {
	static StringBuffer memoria = new StringBuffer();
	//static String arquivo = EscolherArquivo.caminho();
	public static void main(String args[]){
		try{
			BufferedReader arqentrada;
			arqentrada = new BufferedReader(new FileReader("Agenda.txt"));
			String nome = JOptionPane.showInputDialog("Digite o nome");
			nome = nome.toUpperCase();
			String linha;
			String end = "";
			String tel = "";
			while((linha = arqentrada.readLine()) != null){
				memoria.append(linha + "\r\n");
			}
			int inicio = -1;
			inicio = memoria.indexOf (nome);
			if (inicio != -1){
				int ultimo = memoria.indexOf ("\t", inicio);
				nome = memoria.substring(inicio, ultimo);
				int primeiro = ultimo + 1;
				ultimo = memoria.indexOf ("\t", primeiro);
				end = memoria.substring(primeiro, ultimo);
				primeiro = ultimo + 1;
				int fim = memoria.indexOf ("\n", primeiro);
				tel = memoria.substring(primeiro, fim);
				RegAgenda regAg = new RegAgenda (nome, end, tel);
				int resp = JOptionPane.showConfirmDialog(null,
						"Deseja excluir?" + "\n" +regAg.getNome() + "\n" +regAg.getEnd() + "\n" +
						regAg.getTel());
				if(resp == 0){
					memoria.delete(inicio, fim + 1);
					gravar();
					JOptionPane.showMessageDialog(null,"Operação realizada com sucesso");
				}
			}else{
				JOptionPane.showMessageDialog(null,"Não cadastrado");
			}
			arqentrada.close ();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Erro de leitura");
		}
	}
	public static void gravar(){
		try{
			BufferedWriter saida;
			saida = new BufferedWriter (new FileWriter ("Agenda.txt"));
			saida.write (memoria.toString());
			saida.flush();
			saida.close();
		}catch (Exception erro){
			JOptionPane.showMessageDialog(null,"Erro de gravação");
		}
	}
}
