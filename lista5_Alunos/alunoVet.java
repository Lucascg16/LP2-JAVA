package lista5_Alunos;

public class alunoVet {
    private aluno [] vetor;
    private int quantVet;
    
    public alunoVet(int tamanho){
        this.vetor = new aluno[tamanho];
        this.quantVet = 0;
    }

    public aluno getVetor(int indice){
        return this.vetor[indice];
    }
    public aluno setVetor(int indice, aluno novoDado){
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
    public boolean inserirAluno(aluno novo){
        if(this.eCheio()){
            return false;
        }else{
            this.vetor[this.quantVet] = novo;
            this.quantVet++;
            return true;
        }
    }
    //letra b
    public String consultarAlunos(double valor){
        String resp = "";
        for (int i = 0; i < this.quantVet; i++) {
            if(this.vetor[i].getNota1()<valor && this.vetor[i].getNota2()<valor){
                resp += this.vetor[i].getNome()+ "\n";
            }
        }
        if(resp.equalsIgnoreCase("")){
            return "Nao a alunos com notar abaixo de "+valor;
        }else{
            return resp;
        }
    }
    //letra c
    public String calcularMedia(){
        String resp = "";
        for (int i = 0; i < this.quantVet; i++) {
            resp += this.vetor[i].getNome()+" Sua media e:"+(this.vetor[i].getNota1()+this.vetor[i].getNota2()/2)+"\n";
        }
        return resp;
    }
}
