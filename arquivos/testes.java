package arquivos;


import java.util.Scanner;
import java.util.Arrays;

// as vezes eu mistruro ingles com portugues, qualquer duvida so entrar em contato ;)

class testes
{

	static int i = 0;
	// variavel global aqui para gravar quantas iteracoes o metodo signData teve

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.printf("Cadastrando. . .\n\n");

		String[][] aux = signData();
		String[] names = Arrays.copyOfRange(aux[0], 0, i + 1);
		String[] phone = Arrays.copyOfRange(aux[1], 0, i + 1);
		String[] code = Arrays.copyOfRange(aux[2], 0, i + 1);
		/*
	          usando o copyOf para evitar alocar mais slots na memoria principal do que serao usados,
	          isso seria mais legivel se usando um ArrayList
		 */
		int menu;

		while (true) {
			System.out.printf("1 -> usuarios com codigo entre 50 e 100\n"
					+ "2 -> mostrar telefone de um cliente\n"
					+ "3 -> sair\n\n"
					+ "Escolha:");
			menu = scan.nextInt();

			switch (menu) {
			case 1:
				listClients(names, code);
				break;
			case 2:
				System.out.printf("Digite o nome:");
				scan.nextLine(); // limpando a newline do buffer again
				getPhone(scan.nextLine(), phone, names);
				break;
			case 3:
				System.exit(0);
			default:
				System.out.printf("Escolha uma opcao valida!\n\n");
			}
		}
	}

	static String[][] signData()
	{
		/*
	          retorno uma matriz nessa metodo para que eu possa retornar varios valores simultaneamente
	          como o numero de iteracoes dentro do for-loop, e cada um dos tres vetores que foram preenchidos
		 */

		Scanner scan = new Scanner(System.in);
		/*
	          inicializado o 'i' fora do escopo do for-loop para que esteja disponivel dentro da funcao e possa ser retornado
	          e criando como instanciacao inves de primitivo para que a conversao de String para int seja mais facil
		 */


		String[] names = new String[3];
		String[] phoneNumber = new String[3]; //using String[] so it supports "-" separator
		String[] referenceNumbers = new String[3];

		for (; i < names.length; i++) {
			System.out.printf("Digite o nome do usuario numero %d:", i + 1);
			names[i] = scan.nextLine();

			System.out.printf("Digite telefone do usuario %s:", names[i]); // doesn't throw an exception since names[i] is designated above
			phoneNumber[i] = scan.nextLine();

			System.out.printf("Digite o codigo do usuario %s:", names[i]); // doesn't throw an exception since names[i] is designated above
			referenceNumbers[i] = scan.nextLine();

			System.out.printf("Deseja parar? [s/*]:");
			/*
	              o caracter '*' significa que qualquer coisa que o usuario digitar que nao
	              for 'n' ira sair da iteracao e retornar os valores
	              semelhante a '.*' em uma regEx
			 */
			if ((scan.next().charAt(0) == 's') || (i == names.length)) {
				return new String[][] {names, phoneNumber, referenceNumbers};
			} else {
				scan.nextLine();
				// flushes the \n character out of the buffer
				// o else aqui eh desnecessario para performance e funcionamento mas faz o codigo ligeiramente mais legivel
			}
		}
		return new String[][] {names, phoneNumber, referenceNumbers};
	}

	static void listClients(String[] client, String[] code) // between 50 and 150
	{
		for (int j = 0; j < client.length; j++) {
			if ((Integer.parseInt(code[j])) >= 50 && (Integer.parseInt(code[j]) <= 150)) {
				System.out.printf("cliente %s\ncodigo: %s\n", client[j], code[j]);
			}
		}
	}

	static void getPhone(String nameToSearch, String[] phone, String[] client)
	{
		int j = 0;

		for (; !nameToSearch.equals(client[j]); j++);
		// for loop vazio

		if ((j == client.length) && (!nameToSearch.equals(client[j]))) {
			System.out.printf("Cliente nao encontrado :(\n");
		} else {
			System.out.printf("cliente %s \nnumero %s\n", client[j], phone[j]);
		}
	}
}

