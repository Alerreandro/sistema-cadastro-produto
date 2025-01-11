package dados;

// Classe que representa um produto
public class Produto {

	// Atributos do produto
	String nome; // Nome do produto
	String descricao; // Descrição do produto
	Double valor; // Valor do produto
	String disponivel; // Disponibilidade (sim/não)

	// Construtor padrão
	public Produto() {
	}

	// Construtor parametrizado
	public Produto(String nome, String descricao, Double valor, String disponivel) {
		this.nome = nome; // Inicializa o nome do produto
		this.descricao = descricao; // Inicializa a descrição do produto
		this.valor = valor; // Inicializa o valor do produto
		this.disponivel = disponivel; // Inicializa a disponibilidade do produto
	}

	// Métodos getters para acessar os atributos
	public String getNome() {
		return nome; // Retorna o nome do produto
	}

	public String getDescricao() {
		return descricao; // Retorna a descrição do produto
	}

	public Double getValor() {
		return valor; // Retorna o valor do produto
	}

	// Sobrescreve o método toString para formatar a exibição do produto
	@Override
	public String toString() {
		return String.format("Nome: %s | Valor: R$ %.2f | Disponível: %s", nome, valor, disponivel);
	}
}
