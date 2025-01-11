package dados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Cadastro {

	// Lista para armazenar os produtos cadastrados
	ArrayList<Produto> produto = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);

	// Construtor que permite inicializar a lista de produtos e o Scanner
	public Cadastro(ArrayList<Produto> produto, Scanner sc) {
		this.produto = produto;
		this.scanner = sc;
	}

	// Construtor padrão
	public Cadastro() {
	}

	// Método para cadastrar um novo produto
	public void cadastrarProduto() {

		System.out.println("Cadastrando o produto\n");
		System.out.println("Digite o nome do produto: ");
		String name = scanner.nextLine(); // Captura o nome do produto
		System.out.println("Digite a descrição do produto: ");
		String descricao = scanner.nextLine(); // Captura a descrição do produto
		System.out.println("Digite o valor do produto: ");
		double valor = cadastrarValor(); // Valida e captura o valor do produto
		scanner.nextLine(); // Limpa o buffer do Scanner
		System.out.println("O produto está disponível ? (sim/não) ");
		String dispo = scanner.nextLine(); // Captura a disponibilidade do produto

		String disponivel = validarDisponivel(dispo); // Valida a resposta de disponibilidade

		// Cria um novo objeto Produto com os dados fornecidos
		Produto produtNovo = new Produto(name, descricao, valor, disponivel);

		// Adiciona o novo produto à lista
		produto.add(produtNovo);

		System.out.println("\nProduto cadastrado com sucesso!");
	}

	// Método para listar os produtos cadastrados
	public void listagemProduto() {

		String opcao;
		if (produto.isEmpty()) {
			// Caso não haja produtos cadastrados
			System.out.println("Não há produtos cadastrados");
		} else {
			// Ordena os produtos pelo valor e exibe cada um deles
			produto.stream().sorted(Comparator.comparingDouble(Produto::getValor)).forEach(System.out::println);
		}

		System.out.println("Deseja cadastrar um novo produto ? Sim/Não");
		opcao = scanner.nextLine(); // Captura a resposta do usuário

		if (opcao.equals("Sim") || opcao.equals("sim")) {
			// Caso o usuário queira cadastrar um novo produto
			cadastrarProduto();
			listagemProduto(); // Exibe a lista atualizada
		} else if (opcao.equals("Não") || opcao.equals("não")) {
			// Volta ao menu principal
			System.out.println("Voltando para o menu\n");
		} else {
			// Resposta inválida
			System.out.println("Programa não reconhece esse comando, por favor responda com Sim ou Não.");
			listagemProduto(); // Solicita novamente a resposta
		}
	}

	// Método para capturar e validar o valor do produto
	double cadastrarValor() {

		double vlr = scanner.nextDouble();
		if (vlr < 0) {
			// Valor negativo não é permitido
			System.out.println("Valor inserido é negativo, insira um valor positivo");
			vlr = cadastrarValor(); // Solicita novamente
		}
		if (vlr == 0) {
			// Valor zero não é permitido
			System.out.println("Valor não pode ser nulo, insira um valor positivo");
			vlr = cadastrarValor(); // Solicita novamente
		}

		return vlr; // Retorna o valor válido
	}

	// Método para validar a resposta de disponibilidade do produto
	String validarDisponivel(String dispo) {

		String opcao = dispo;
		if (opcao.equals("Sim") || opcao.equals("sim") || opcao.equals("Não") || opcao.equals("não")) {
			// Resposta válida
			return opcao;
		} else {
			// Resposta inválida
			System.out.println("Programa não reconhece esse comando, por favor responda com Sim ou Não");
			String op = scanner.nextLine();
			opcao = validarDisponivel(op); // Solicita novamente
		}
		return opcao; // Retorna a resposta válida
	}
}
