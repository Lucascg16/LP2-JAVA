package arquivos;

import javax.swing.JOptionPane;

public class ExemploJOptionPane {

	public static void main(String[] args) {
		String nome;
	    int numero;
		double numeroReal;
		char achou;
		
		nome = JOptionPane.showInputDialog("Digite o nome:");
		
		numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um n�mero:"));
		
		numeroReal = Double.parseDouble(JOptionPane.showInputDialog("Digite um n�mero real:"));
		
		achou = JOptionPane.showInputDialog("Digite o caracter:").charAt(0);
				
		JOptionPane.showMessageDialog(null,"nome:"+ nome + 
				"\nnumero:"+ numero +
				"\nreal:" + numeroReal);
	}
}
