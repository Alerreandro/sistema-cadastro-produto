package programa;

import java.util.Locale;
import java.util.Scanner;
import dados.Cadastro;

public class Main {

	public static void main(String[] args) {

		// Define o padrão de localização para o formato numérico como US (ponto
		// decimal)
		Locale.setDefault(Locale.US);

		// Cria um scanner para entrada de dados do usuário
		Scanner scanner = new Scanner(System.in);

		// Instancia o objeto Cadastro para gerenciar os produtos
		Cadastro cadastro = new Cadastro();

		int escolha = 0; // Variável para armazenar a escolha do menu
		while (escolha != 99) { // Loop principal que mantém o programa em execução até o usuário escolher sair

			// Exibe o menu de opções para o usuário
			System.out.println("--------------------------");
			System.out.println("      OPÇÔES DE MENU      \n");
			System.out.println("1 - Cadastro de produto");
			System.out.println("2 - Listagem de produto");
			System.out.println("99 - Sair do programa");
			System.out.println("--------------------------\n");

			escolha = scanner.nextInt(); // Lê a opção escolhida pelo usuário

			switch (escolha) {
			case 1:
				// Caso o usuário escolha cadastrar um produto
				cadastro.cadastrarProduto();
				System.out.println("Produtos: ");
				cadastro.listagemProduto(); // Exibe a lista de produtos após o cadastro
				break;

			case 2:
				// Caso o usuário escolha listar os produtos
				System.out.println("Produtos: ");
				cadastro.listagemProduto(); // Exibe a lista de produtos
				break;

			case 99:
				// Caso o usuário escolha sair do programa
				System.out.println("Obrigado por ter usado o programa!");
				break;

			default:
				// Caso o usuário insira uma opção inválida
				System.out.println("Opção inválida! Por favor, tente novamente.");
			}
		}

		// Fecha o scanner para liberar recursos
		scanner.close();
	}
}
