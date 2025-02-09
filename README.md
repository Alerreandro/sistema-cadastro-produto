# Sistema de Cadastro de Produtos

Este projeto é um sistema simples para cadastro e listagem de produtos em Java. Ele permite que o usuário cadastre produtos, visualize os produtos cadastrados e interaja com um menu de opções.

## 📋 Funcionalidades

- **Cadastro de Produto:** O sistema solicita informações como nome, descrição, valor e disponibilidade para cadastrar um novo produto.
- **Listagem de Produtos:** Exibe todos os produtos cadastrados, organizados por valor em ordem crescente.
- **Validação de Dados:**
  - Garante que o valor do produto seja positivo.
  - Aceita apenas "Sim" ou "Não" para a disponibilidade do produto.

## 🛠️ Estrutura do Projeto

A estrutura do projeto está organizada em três pacotes principais:

### Pacote `programa`

- **`Main.java`:** Contém o ponto de entrada do programa. Oferece um menu para o usuário interagir com o sistema e gerencia as chamadas para o pacote de dados.

### Pacote `dados`

- **`Produto.java`:** Representa um produto com atributos como nome, descrição, valor e disponibilidade. Inclui métodos para acessar os atributos e formatar a exibição do produto.
- **`Cadastro.java`:** Gerencia a lista de produtos, incluindo cadastro, validação e listagem.

### Pacote `gui`

- **`InterfaceGrafica.java`:** Implementa uma interface gráfica utilizando Swing para o cadastro e a listagem dos produtos.
  Permite o cadastro por meio de um formulário e a visualização dos produtos cadastrados em uma tabela ordenada pelo valor.

## 🚀 Como Executar

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/javase-jdk-downloads.html) instalado em sua máquina.
2. Clone este repositório:
   ```bash
   git clone https://github.com/Alerreandro/sistema-cadastro-produto.git
   ```

🖼️ Demonstração do Menu (Versão Console)
Ao executar o programa, o menu será exibido:

---

      OPÇÔES DE MENU

1 - Cadastro de produto
2 - Listagem de produto
99 - Sair do programa

Observação:
A versão principal do projeto atualmente utiliza uma interface gráfica (Swing) para facilitar o cadastro e a listagem dos produtos. Caso seja necessário testar a versão console, é possível utilizar os métodos da classe Cadastro diretamente.

---

🧪 Testes
Exemplos de Entrada
Cadastro de Produto:

Nome: "Notebook"
Descrição: "Notebook com 16GB de RAM e 512GB SSD."
Valor: 4500.00
Disponível: "Sim"
Listagem de Produtos:

Exibe todos os produtos cadastrados ordenados pelo valor.

Exemplo de saída:

Nome: Notebook | Valor: R$ 4500.00 | Disponível: Sim

🛡️ Validações Implementadas

Valor inválido: Se o valor inserido for negativo ou zero, o sistema solicitará que o usuário insira novamente.
Disponibilidade inválida: Aceita apenas "Sim" ou "Não". Caso contrário, será solicitado um novo valor.

📚 Tecnologias Utilizadas

Linguagem: Java
Paradigma: Programação Orientada a Objetos
Interface: Swing (para a interface gráfica)

✨ Melhorias Futuras
Adicionar persistência de dados (salvar e carregar produtos de um arquivo ou banco de dados).
Permitir a remoção e edição de produtos já cadastrados.
Aprimorar a interface gráfica e a experiência do usuário.

🧑‍💻 Autor
Desenvolvido por José Alerreandro Abreu Costa
