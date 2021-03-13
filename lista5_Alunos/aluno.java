package lista5_Alunos;

public class aluno {

    private int matricula;
    private String nome;
    private double nota1;
    private double nota2;

    public aluno(int matricula, String nome, double nota1, double nota2) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
    public aluno(){
        this.matricula = 0;
        this.nome = "";
        this.nota1 = 0;
        this.nota2 = 0;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("alunos{matricula=").append(matricula);
        sb.append(", nome=").append(nome);
        sb.append(", nota1=").append(nota1);
        sb.append(", nota2=").append(nota2);
        sb.append('}');
        return sb.toString();
    }
}
