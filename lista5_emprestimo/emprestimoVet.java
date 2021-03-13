package lista5_emprestimo;

public class emprestimoVet {

    private emprestimo[] vetor;
    private int quantVet;

    public emprestimoVet(int tamanho) {
        this.vetor = new emprestimo[tamanho];
        this.quantVet = 0;
    }

    public emprestimo getVetor(int indice) {
        return this.vetor[indice];
    }

    public emprestimo setVetor(int indice, emprestimo novoDado) {
        return this.vetor[indice] = novoDado;
    }

    public int getQuantVet() {
        return quantVet;
    }

    public void setQuantVet(int quantVet) {
        this.quantVet = quantVet;
    }

    public boolean eVazio() {
        return (this.quantVet == 0);
    }

    public boolean eCheio() {
        return (this.quantVet == this.vetor.length);
    }

    //letra a
    public boolean pesquisarNome(String nome) {
        int i = 0;
        while (i < this.quantVet && !nome.equalsIgnoreCase(this.vetor[i].getNome())) {
            i++;
        }
        if (i == this.quantVet) {
            return false;
        } else {
            return true;
        }
    }

    public boolean inserirDados(emprestimo novo) {
        if (this.quantVet == this.vetor.length) {
            return false;
        } else {
            this.vetor[this.quantVet] = novo;
            this.quantVet++;
            return true;
        }
    }

    //letra b
    public void calcularJuros() {
        for (int i = 0; i < this.quantVet; i++) {
            double juros = 0;
            juros = this.vetor[i].getValor() * this.vetor[i].getJuros();
            System.out.println("o cliente " + this.vetor[i].getNome() + " ira pagar " + juros + " de juros por mes.");
        }
    }

    //letra c
    public void alterarValor(double valor) {
        int maior = 0;
        if (!eVazio()) {     
            for (int i = 0; i < this.quantVet; i++) {
                if (i == 0) {
                    maior = i;
                }
                if (this.vetor[i].getValor() > this.vetor[maior].getValor()) {
                    maior = i;
                }
            }
            this.vetor[maior].setValor(valor);
        }
    }
}
