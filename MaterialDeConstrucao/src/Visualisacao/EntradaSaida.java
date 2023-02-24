package Visualisacao;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import Modelo.Produto;
import java.text.DecimalFormat;

public class EntradaSaida {

	static DecimalFormat formatacaoMoeda = new DecimalFormat("R$ 0.00");

	public static int solicitaOpcao() {
		String[] opcoes = { "Cadastra Produtos", "Lista Produtos", "Alimenta Estoque", "Lista Estoque",
				"Vende Produtos", "Total de Vendas", "Sair do programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);

		return menu.getSelectedIndex();
	}

	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O Programa sera encerrado");
	}

	public static String solicitaCodigoCasdastroProduto() {
		String codigoProduto = JOptionPane.showInputDialog("Informe o codigo para o produto");
		return codigoProduto;
	}

	public static String solicitaDescricaoCasdastroProduto() {
		String descricaoProduto = JOptionPane.showInputDialog("Informe o Descrição para o produto");
		return descricaoProduto;
	}

	public static void imprimeListaDeprodutos(String ListadeProdutos) {
		JOptionPane.showMessageDialog(null, ListadeProdutos, "Lista de Produtos:", JOptionPane.INFORMATION_MESSAGE);
	}

	public static int informeQuantidade() {
		int quantidade;
		quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de produtos"));
		return quantidade;
	}

	public static void avisoDeNaoEncontradoItem() {
		JOptionPane.showMessageDialog(null, "O codigo de produto não esta cadastrado");

	}

	public static Double informePrecoDeVenda() {
		Double precoVenda;
		precoVenda = Double.parseDouble(JOptionPane.showInputDialog("O preço unitario de venda"));
		return precoVenda;

	}

	public static Double calculaTotalVendaPorItem(int quantidadeDeVenda, Double precoDeVenda) {
		Double totalDeVendaPorItem;
		totalDeVendaPorItem = quantidadeDeVenda * precoDeVenda;
		return totalDeVendaPorItem;
	}

	public static LocalDate buscaData() {
		LocalDate data = LocalDate.now();
		return data;
	}

	public static void imprimeTotalDeVendas(double totalDeVendas) {
		double vendas = totalDeVendas;
		JOptionPane.showMessageDialog(null, "O total de vendas no periodo é " +  formatacaoMoeda.format(vendas));

	}

	public static void codigoForaDosParametros() {
		JOptionPane.showMessageDialog(null, "O codigo de produto  esta fora dos parametros");

	}

	public static void codigoJaCadastrado() {
		JOptionPane.showMessageDialog(null, "O codigo de produto ja cadastrado");

	}

	public static void quantidadeInformadaInvalida() {
		JOptionPane.showMessageDialog(null, "Quantidade de Items Fora dos parametros");

	}

	public static void descricaoForaDosParametros() {
		JOptionPane.showMessageDialog(null, "Descrição dos produtos fora dos parametros");

	}

	public static void avisoEstoqueNegativo() {
		JOptionPane.showMessageDialog(null, "Saldo do Estoque insuficiente");

	}

	public static void vendaEncerrada() {
		JOptionPane.showMessageDialog(null, "A Venda Sera Encerrada");

	}

	public static String geraNotaFiscalDaVenda(LocalDate data, String codigoDeVenda, String descricaoProdutoDeVenda,
			int quantidadeDeVenda, Double precoDeVenda, Double totalVendaPorItem) {
		String escreveNotaFiscal = "";
		escreveNotaFiscal += "Data" + " | " + "Codigo De item " + " | " + "Descrição de Produto" + " | "
				+ "Quantidade de Saida" + " | " + "Preço de Venda" + "|" + "Preço total de venda por Item" + "\n";
		escreveNotaFiscal += data + " | " + codigoDeVenda + " | " + descricaoProdutoDeVenda + " | " + quantidadeDeVenda
				+ " | " + formatacaoMoeda.format( precoDeVenda) + " | " +  formatacaoMoeda.format(totalVendaPorItem) + "\n";

		escreveNotaFiscal += "Total da NF " +  formatacaoMoeda.format(totalVendaPorItem) + "\n";

		return escreveNotaFiscal;
	}

}
