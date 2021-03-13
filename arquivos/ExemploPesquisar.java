package arquivos;

import java.io.*;
import java.util.Scanner;
public class ExemploPesquisar {
  static StringBuffer memoria = new StringBuffer();
  static Scanner scan = new Scanner(System.in);
  public static void main(String args[]){
    try{
      String arquivo = EscolherArquivo.caminho();
      BufferedReader arqentrada;
      arqentrada = new BufferedReader( new FileReader(arquivo));
      System.out.println("Digite o nome a ser procurado");
      String nome = scan.next();
      nome = nome.toUpperCase();
      String linha;
      String end = "";
      String tel = "";
      while((linha = arqentrada.readLine()) != null){
        memoria.append(linha + "\n");
      }
      int inicio = -1;
      inicio = memoria.indexOf (nome);
      if (inicio != -1){
        int ultimo = memoria.indexOf ("\t", inicio);
        nome = memoria.substring(inicio, ultimo);
        int primeiro = ultimo + 1;
        ultimo = memoria.indexOf ("\t", primeiro);
        end = memoria.substring(primeiro, ultimo);
        primeiro = ultimo + 1;
        int fim = memoria.indexOf ("\n", primeiro);
        tel = memoria.substring(primeiro, fim);
        RegAgenda regAg = new RegAgenda (nome, end, tel);
        System.out.println(regAg.getEnd() + "\n" + regAg.getTel());
      }else{
    	  System.out.println("Não cadastrado");
      }
      arqentrada.close ();
    }catch (Exception e){
    	System.out.println("Erro de leitura");
    }
  }
}
