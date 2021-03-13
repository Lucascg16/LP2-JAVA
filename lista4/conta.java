package lista4;

public class conta {
    private int numeroConta;
    private String titular;
    private double saldo;
    boolean fazerSaque;
    
    public conta(){
        this.numeroConta = 0;
        this.titular = "";
        this.saldo = 0;
        this.fazerSaque = false;
    }
    
    public conta(int numeroConta, String titular, double saldo, boolean fazerSaque){
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
        this.fazerSaque = fazerSaque;
    }
    public int getNumeroConta(){
        return this.numeroConta;
    }
    public String getTitular(){
        return this.titular;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public boolean getfazerSaque(){
        return this.fazerSaque;
    }
    public void setNumeroConta(int novo){
        this.numeroConta = novo;
    }
    public void setTitular(String novo){
        this.titular = novo;
    }
    public void setSaldo(double novo){
        this.saldo = novo;
    }
    public void setfazerSaque(boolean novo){
        this.fazerSaque = novo;
    }
    public String toString(){
        return "Nº da conta:"+this.numeroConta+"\nNome do titular:"+this.titular+
                "\nSaldo da conta:"+this.saldo;
    }
    public boolean fazerSaque(double s){
        if (s < saldo){
            saldo -= s;
            return this.fazerSaque = true;
        }
        else{
            return this.fazerSaque = false;
        }
    }
    public double fazerDeposito(double d){
        saldo += d;
        return saldo;
    }
}
