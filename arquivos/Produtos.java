package arquivos;
public class Produtos {
	private int codigo;
	private String produto;
	private double valor;
	private int quantidade;
	
	//CONSTRUTOR:
	public Produtos(int codigo, String produto, double valor, int quantidade) {
		super();
		this.codigo = codigo;
		this.produto = produto;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	//METODOS DE ACESSO AOS ATRIBUTOS:
	public int getCodigo() {
		return codigo;
	}
	public String getProduto() {
		return produto;
	}
	public double getValor() {
		return valor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	//METODOS DE ALTERAÇÃO DOS ATRIBUTOS:
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	//METODO DE VISUALIZAÇÃO DO CONTEUDO DA CLASSE:
	public String toString(){
		return this.codigo+"\t"+this.produto+"\t"+this.valor+"\t"+this.quantidade+"\n";
	}
	
	
}
