package lista5_empresa;

public class empresaVet {
    private empresa [] vetor;
    private int quantVet;
    
    public empresaVet(int tamanho){
        this.vetor = new empresa[tamanho];
        this.quantVet = 0;
    }
    public empresa getVetor(int indice){
        return this.vetor[indice];
    }
    public empresa setVetor(int indice, empresa novoDado){
        return this.vetor[indice] = novoDado;
    }
    public int getQuantVet() {
        return quantVet;
    }
    public void setQuantVet(int quantVet) {
        this.quantVet = quantVet;
    }
    public boolean eVazio(){
        return (this.quantVet == 0);
    }
    public boolean eCheio(){
        return (this.quantVet == this.vetor.length);
    }
    //letra a
    public boolean inserirDados(empresa novo){
        if (this.eCheio()){
            return false;
        }else{
            this.vetor[this.quantVet] = novo;
            this.quantVet += 1;
            return true;
        }
    }
    //letra b
    public String contarVendedor(String v){
        int cont = 0;
        for (int i = 0; i < this.quantVet; i++) {
            if(this.vetor[i].getTipo().equalsIgnoreCase(v)){
                cont += 1;
            }
        }
        if (cont == 0){
            return "Nenhum produto deste tipo foi vendido ainda.";
        }else{
            return "Foi encontradas "+cont+"vendas deste tipo.";
        }
    }
    public boolean excluirVendedor(String nome){
        if(this.eVazio()){
            return false;
        }else{
            int i = 0;
            while (i<this.quantVet && !this.vetor[i].getNome().equalsIgnoreCase(nome));
            i++;
            if(i == this.quantVet){
                return false;
            }else{
                this.vetor[i] = this.vetor[this.quantVet - 1];
                this.quantVet --;
                return false;
            }
        }
    }
}