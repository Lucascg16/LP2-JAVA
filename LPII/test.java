/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII;

/**
 *
 * @author Lucas
 */
public class test {
   public static int d(int y){
       return y*3;
   }
   public static int e(int x){
       return x*4;
   }
   public static int g(int y, int x){
       x = x + 2;
       return 10 + e(y) + d(x);
   }
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(a +""+ b +"" + g(a,b));
    }
}