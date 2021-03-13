package LPIILista2;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class ex11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um Numero");
        int num1 = scan.nextInt();
        System.out.println("Digite outro Numero");
        int num2 = scan.nextInt();
        maiorValor(num1, num2);
    }
    static void maiorValor(int a, int b){
        if (a > b){
            System.out.println("O valor "+a+" e maior");
        }else{
            System.out.println("O valor "+b+" e maior");
        }
    }
}
