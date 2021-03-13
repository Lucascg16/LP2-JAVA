package lista5_empresa;

public class empresa {
    private int vendedor;
    private String nome;
    private String tipo;
    boolean getTipo;

    public empresa(int vendedor, String nome, String tipo) {
        this.vendedor = vendedor;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "empresa{" + "vendedor=" + vendedor + ", nome=" + nome + ", tipo=" + tipo + '}';
    }
}
