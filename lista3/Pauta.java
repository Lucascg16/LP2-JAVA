package lista3;
//esta comentado apenas o padrao do codigo, onde sempre sera o mesmo, musando apenas o tamanho e o nome dos atributos...
public class Pauta {

    //atributos, aqui são declaradas as "variaveis"
    private int matricula;
    private String nomeAluno;
    private int numFalta;
    private double nota1;
    private double nota2;

    //construtores, inicia as "variaveis" com um valor,
    public Pauta() {//inicia as os atributos/variaveis
        this.matricula = 0;
        this.nomeAluno = "";
        this.numFalta = 0;
        this.nota1 = 0;
        this.nota2 = 0;
    }
    //construtor com passagem de parametro, usado para dar nome aos atributos, que sera usado mais pra frent.
    public Pauta(int matricula, String nomeAluno, int numFalta, double nota1, double nota2) {
        this.matricula = matricula;
        this.nomeAluno = nomeAluno;
        this.numFalta = numFalta;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
//get, usado para pegar o valor presente no atributo.
    public int getMatricula() {
        return this.matricula;
    }

    public String getNomeAluno() {
        return this.nomeAluno;
    }

    public int getNumFaltas() {
        return this.numFalta;
    }

    public double getNota1() {
        return this.nota1;
    }

    public double getNota2() {
        return this.nota2;
    }
//set,usado para modificar/setar, um novo valor no atributo.
    public void setMatricula(int novo) {
        this.matricula = novo;
    }

    public void setNomeAluno(String novo) {
        this.nomeAluno = novo;
    }

    public void setNumFalta(int novo) {
        this.numFalta = novo;
    }

    public void setNota1(double novo) {
        this.nota1 = novo;
    }

    public void setNota2(double novo) {
        this.nota2 = novo;
    }
//toString apenas um metodo, usado para mostrar algo, apenas o que esta colocado nele, poder ser feito com o get tambem.
//retorna uma string com todas as informações dos atributos nele disponiveis.
    public String toString() {
        return " matricula: " + this.matricula
                + " nome: " + this.nomeAluno
                + " número de faltas: " + this.numFalta
                + " nota1: " + this.nota1
                + " nota2: " + this.nota2;
    }

    public boolean verificarReprovacaoFaltas() {
        if (this.numFalta > 25) {
            return true;
        } else {
            return false;
        }
    }

    public double calcularMedia() {
        return (this.nota1 + this.nota2) / 2;
    }

    public String verificarSituacao() {
        if (calcularMedia() >= 7 && !verificarReprovacaoFaltas()) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }
}
