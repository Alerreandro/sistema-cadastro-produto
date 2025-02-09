package dados;

public class Produto {
    String nome;
    String descricao;
    Double valor;
    public String disponivel;

    public Produto() {
    }

    public Produto(String nome, String descricao, Double valor, String disponivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | Valor: R$ %.2f | Disponível: %s", nome, valor, disponivel);
    }
}
