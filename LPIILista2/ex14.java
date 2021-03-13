package LPIILista2;

import java.util.Scanner;

public class ex14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a sua idade");
        int idade = scan.nextInt();
        categoria(idade);
    }
    static void categoria(int ida){
        if(5<=ida && ida<=7){
            System.out.println("pre-mirim");
        }else if(8<= ida && ida <=10){
            System.out.println("Mirim");
        }else if(11<= ida && ida <= 13){
            System.out.println("infantil");
        }else if(14<= ida && ida <= 17){
            System.out.println("juvenil");
        }else if(ida <= 18){
            System.out.println("adulto");
        }
    }
}
