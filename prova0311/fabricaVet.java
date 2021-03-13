package prova0311;

public class fabricaVet {

    private fabrica[] vetor;
    private int quantVet;

    public fabricaVet(int tamanho) {
        this.vetor = new fabrica[tamanho];
        this.quantVet = 0;
    }

    public fabrica getVetor(int indice) {
        return this.vetor[indice];
    }

    public fabrica setVetor(int indice, fabrica novoDado) {
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
    public boolean inserirDados(fabrica novoDado) {
        if (this.eCheio()) {
            return false;
        } else {
            this.vetor[this.quantVet] = novoDado;
            this.quantVet++;
            return true;
        }
    }

    //letra b
    public void mostrarSalario() {
        if (this.quantVet != 0) {
            //procurar menor saldo
            int menor = 0;
            for (int i = 1; i < this.quantVet; i++) {
                if (this.vetor[i].getSalario() < this.vetor[menor].getSalario()) {
                    menor = i;
                }
            }
            System.out.println(this.vetor[menor].getNome());
        }
    }
    //letra c
public void alterarSalario(){
        for (int i = 0; i < this.quantVet; i++) {
            if(this.vetor[i].getSalario() < 999){
                this.vetor[i].setSalario(this.vetor[i].getSalario() + this.vetor[i].getSalario()*0.50);
            }
        }
    }
}

