package dados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Cadastro {

    ArrayList<Produto> produto = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Cadastro(ArrayList<Produto> produto, Scanner sc) {
        this.produto = produto;
        this.scanner = sc;
    }

    public Cadastro() {
    }

    public void cadastrarProduto() {
        System.out.println("Cadastrando o produto\n");
        System.out.println("Digite o nome do produto: ");
        String name = scanner.nextLine();
        System.out.println("Digite a descrição do produto: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite o valor do produto: ");
        double valor = cadastrarValor();
        scanner.nextLine(); 
        System.out.println("O produto está disponível ? (sim/não) ");
        String dispo = scanner.nextLine();
        String disponivel = validarDisponivel(dispo);
        Produto produtNovo = new Produto(name, descricao, valor, disponivel);
        produto.add(produtNovo);
        System.out.println("\nProduto cadastrado com sucesso!");
    }

    public void listagemProduto() {
        String opcao;
        if (produto.isEmpty()) {
            System.out.println("Não há produtos cadastrados");
        } else {
            produto.stream()
                   .sorted(Comparator.comparingDouble(Produto::getValor))
                   .forEach(System.out::println);
        }
        System.out.println("Deseja cadastrar um novo produto ? Sim/Não");
        opcao = scanner.nextLine();
        if (opcao.equalsIgnoreCase("Sim")) {
            cadastrarProduto();
            listagemProduto();
        } else if (opcao.equalsIgnoreCase("Não")) {
            System.out.println("Voltando para o menu\n");
        } else {
            System.out.println("Programa não reconhece esse comando, por favor responda com Sim ou Não.");
            listagemProduto();
        }
    }
    double cadastrarValor() {
        double vlr = scanner.nextDouble();
        if (vlr < 0) {
            System.out.println("Valor inserido é negativo, insira um valor positivo");
            vlr = cadastrarValor();
        }
        if (vlr == 0) {
            System.out.println("Valor não pode ser nulo, insira um valor positivo");
            vlr = cadastrarValor();
        }
        return vlr;
    }

    String validarDisponivel(String dispo) {
        String opcao = dispo;
        if (opcao.equalsIgnoreCase("Sim") || opcao.equalsIgnoreCase("Não")) {
            return opcao;
        } else {
            System.out.println("Programa não reconhece esse comando, por favor responda com Sim ou Não");
            String op = scanner.nextLine();
            opcao = validarDisponivel(op);
        }
        return opcao;
    }

    public void adicionarProduto(Produto p) {
        produto.add(p);
    }
    

    public ArrayList<Produto> getProdutos() {
        return produto;
    }
}