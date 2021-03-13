package lista5_filme;

public class filmeVet {
    private filme [] vetor;
    private int quantVet;
    
    public filmeVet(int tamanho){
        this.vetor = new filme[tamanho];
        this.quantVet = 0;
    }
    public filme getVetor(int indice){
        return this.vetor[indice];
    }
    public filme setVetor(int indice, filme novoDado){
        return this.vetor[indice] = novoDado;
    }
    public int getQuantVet(){
        return quantVet;
    }
    public void setQuantVet(int quantVet){
        this.quantVet = quantVet;
    }
    public boolean eVazio(){
        return (this.quantVet == 0);
    }
    public boolean eCheio(){
        return (this.quantVet == this.vetor.length);
    }
    // letra a
    public boolean inserirDados (filme novoDado){
        if(this.eCheio()){
            return false;
        }else{
            this.vetor[this.quantVet] = novoDado;
            this.quantVet++;
            return true;
        }
    }
    //letra b
    public String contarGenero(String g){
        int cont = 0;
        for (int i = 0; i <this.quantVet; i++) {
            if(this.vetor[i].getGen().equalsIgnoreCase(g));
            cont++;
        }
        if(cont == 0){
            return "Nenhum filme encontrado no bando de dados.";
        }else{
            return "Encontramos "+cont+" deste genero, no banco de dados.";
        }
    }
    //letra c
    public boolean excluirFilme(String titulo){
        if(this.eVazio()){
            return false;
        }else{
            int i = 0;
            while(i<this.quantVet && !this.vetor[i].getName().equals(titulo)){
                i++;
            }
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
