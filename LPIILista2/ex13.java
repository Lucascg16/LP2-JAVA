package LPIILista2;
import java.util.Random;

public class ex13 {
    public static void main(String[] args) {
        int[] vet = new int[50];
        for (int i = 0; i < vet.length; i++) {
            int valor = new Random().nextInt(100) + 1;
            vet[i] = valor;
        }
        maiorValor(vet);
    }
    static void maiorValor(int[] v){
        int maior = 0, posicao = 0;
        for (int i = 0; i < v.length; i++) {
            if(v[i]>maior){
                maior = v[i];
                posicao = i;
            }
        }
        System.out.println("O maior numero e "+maior+" e esta na posicao "+posicao);
    }
}
