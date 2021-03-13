package lista5_emprestimo;

public class emprestimo {
    private String nome;
    private double valor;
    private double juros;

    public emprestimo(String nome, double valor, double juros) {
        this.nome = nome;
        this.valor = valor;
        this.juros = juros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    @Override
    public String toString() {
        return "emprestimo{" + "nome=" + nome + ", valor=" + valor + ", juros=" + juros + '}';
    }
    
}
