package gui;

import dados.Cadastro;
import dados.Produto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class InterfaceGrafica extends JFrame {

	private CardLayout cardLayout;
	private JPanel mainPanel;
	private JPanel cadastroPanel;
	private JPanel listagemPanel;
	private Cadastro cadastro;
	private JTextField txtNome;
	private JTextArea txtDescricao;
	private JTextField txtValor;
	private JComboBox<String> comboDisponibilidade;
	private JTable tableProdutos;
	private DefaultTableModel tableModel;

	public InterfaceGrafica() {
		cadastro = new Cadastro();
		setTitle("Cadastro de Produtos");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		criarCadastroPanel();
		criarListagemPanel();
		mainPanel.add(cadastroPanel, "cadastro");
		mainPanel.add(listagemPanel, "listagem");
		add(mainPanel);
	}

	private void criarCadastroPanel() {
		cadastroPanel = new JPanel(new BorderLayout());
		JPanel formPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		formPanel.add(new JLabel("Nome:"), gbc);
		txtNome = new JTextField(20);
		gbc.gridx = 1;
		formPanel.add(txtNome, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		formPanel.add(new JLabel("Descrição:"), gbc);
		txtDescricao = new JTextArea(5, 20);
		JScrollPane scrollDescricao = new JScrollPane(txtDescricao);
		gbc.gridx = 1;
		formPanel.add(scrollDescricao, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		formPanel.add(new JLabel("Valor:"), gbc);
		txtValor = new JTextField(20);
		gbc.gridx = 1;
		formPanel.add(txtValor, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		formPanel.add(new JLabel("Disponível:"), gbc);
		String[] opcoes = { "Sim", "Não" };
		comboDisponibilidade = new JComboBox<>(opcoes);
		gbc.gridx = 1;
		formPanel.add(comboDisponibilidade, gbc);
		JButton btnCadastrar = new JButton("Cadastrar Produto");
		btnCadastrar.addActionListener(e -> cadastrarProduto());
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		formPanel.add(btnCadastrar, gbc);
		cadastroPanel.add(formPanel, BorderLayout.CENTER);
	}

	private void criarListagemPanel() {
		listagemPanel = new JPanel(new BorderLayout());
		tableModel = new DefaultTableModel(new Object[] { "Nome", "Descrição", "Valor", "Disponível" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableProdutos = new JTable(tableModel);
		JScrollPane scrollTable = new JScrollPane(tableProdutos);
		listagemPanel.add(scrollTable, BorderLayout.CENTER);
		JButton btnNovoCadastro = new JButton("Cadastrar Novo Produto");
		btnNovoCadastro.addActionListener(e -> cardLayout.show(mainPanel, "cadastro"));
		listagemPanel.add(btnNovoCadastro, BorderLayout.SOUTH);
	}

	private void cadastrarProduto() {
		String nome = txtNome.getText().trim();
		String descricao = txtDescricao.getText().trim();
		String valorStr = txtValor.getText().trim();
		String disponivel = (String) comboDisponibilidade.getSelectedItem();
		if (nome.isEmpty() || descricao.isEmpty() || valorStr.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		double valor;
		try {
			valor = Double.parseDouble(valorStr);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (valor <= 0) {
			JOptionPane.showMessageDialog(this, "O valor deve ser maior que zero!", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Produto novoProduto = new Produto(nome, descricao, valor, disponivel);
		cadastro.adicionarProduto(novoProduto);
		limparCamposCadastro();
		atualizarTabela();
		cardLayout.show(mainPanel, "listagem");
	}

	private void limparCamposCadastro() {
		txtNome.setText("");
		txtDescricao.setText("");
		txtValor.setText("");
		comboDisponibilidade.setSelectedIndex(0);
	}

	private void atualizarTabela() {
		tableModel.setRowCount(0);
		ArrayList<Produto> lista = cadastro.getProdutos();
		lista.sort(Comparator.comparingDouble(Produto::getValor));
		for (Produto p : lista) {
			tableModel.addRow(new Object[] { p.getNome(), p.getDescricao(), String.format("R$ %.2f", p.getValor()),
					p.disponivel });
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new InterfaceGrafica().setVisible(true));
	}
}
