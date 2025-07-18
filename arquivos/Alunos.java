package arquivos;

public class Alunos {
	private int codigo;
	private String nome;
	private double nota1;
	private double nota2;

	public Alunos(int cod, String nome, double nota1, double nota2) {
		this.codigo = cod;
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	public int getCodigo() {
		return this.codigo;
	}
	public void setCodigo(int cod) {
		this.codigo = cod;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNota1() {
		return this.nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return this.nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public String toString() {
		return this.codigo +"\t" +this.nome +"\t" + this.nota1+"\t" +this.nota2+"\n";
	}

}
