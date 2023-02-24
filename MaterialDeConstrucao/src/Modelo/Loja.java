package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import Modelo.Produto;
import Modelo.Cupons;

public class Loja {

	private ArrayList<Produto> listaProdutosCadastrados = new ArrayList<Produto>();
	private ArrayList<Cupons> listaCuponsGerados = new ArrayList<Cupons>();

	public ArrayList<Cupons> getListaCuponsGerados() {
		return listaCuponsGerados;
	}

	public void setListaCuponsGerados(ArrayList<Cupons> listaCuponsGerados) {
		this.listaCuponsGerados = listaCuponsGerados;
	}

	public void adicionaCupomALista(Cupons cupons) {
		listaCuponsGerados.add(cupons);
	}

	public ArrayList<Produto> getListaProdutosCadastrados() {
		return listaProdutosCadastrados;
	}

	public void setListaProdutosCadastrados(ArrayList<Produto> listaProdutosCadastrados) {
		this.listaProdutosCadastrados = listaProdutosCadastrados;
	}

	public void adicionaProdutoLista(Produto produto) {
		listaProdutosCadastrados.add(produto);
	}

	public String geraListaDeProdutosCadastrados() {
		String escreveDeProdutosCadastrados = "Codigo do Produto" + " | " + "Descrição" + "\n";
		for (Produto produto : listaProdutosCadastrados) {
			escreveDeProdutosCadastrados += produto.getCodigoProduto() + " | " + produto.getDescricaoProduto() + "\n";
		}
		return escreveDeProdutosCadastrados;
	}

	public boolean validaCodigoProduto(String codigoDeConsulta) {
		String codigoDeValidacao = "";
		codigoDeValidacao = codigoDeConsulta;
		boolean validaCodigo = false;
		for (Produto produto : listaProdutosCadastrados) {
			if (produto.getCodigoProduto().equals(codigoDeValidacao)) {
				validaCodigo = true;
				return validaCodigo;
			}
		}
		return validaCodigo;
	}

//Adiciona estoque porem nao controla historico de movimentação
	public void adicionaEstoque(String codigoDeConsulta, int quantidadeDeEntrada) {
		String codigoDeValidacao = "";
		codigoDeValidacao = codigoDeConsulta;
		int quantidadeDeproduto = quantidadeDeEntrada;
		boolean validaCodigo = false;
		for (Produto produto : listaProdutosCadastrados) {
			if (produto.getCodigoProduto().equals(codigoDeValidacao)) {
				quantidadeDeproduto += produto.getSaldoEstoque();
				produto.setSaldoEstoque(quantidadeDeproduto);
			}
		}
	}

	public String geraListaDeEstoque() {

		String escreveEstoque = "Codigo do Produto" + " | " + "Descrição" + " | " + "Saldo De Estoque" + "\n";
		for (Produto produto : listaProdutosCadastrados) {
			if (produto.getSaldoEstoque() > 0) {
				escreveEstoque += produto.getCodigoProduto() + " | " + produto.getDescricaoProduto() + " | "
						+ produto.getSaldoEstoque() + "\n";
			}
		}
		return escreveEstoque;
	}

	public void baixaEstoque(String codigoDeVenda, int quantidadeDeVenda) {
		String validaCodigoVenda;
		int quantidadeVendas;
		validaCodigoVenda = codigoDeVenda;
		quantidadeVendas = quantidadeDeVenda;
		boolean validaVenda = false;
		for (Produto produto : listaProdutosCadastrados) {
			if (produto.getCodigoProduto().equals(validaCodigoVenda)) {
				quantidadeVendas = produto.getSaldoEstoque() - quantidadeVendas;
				produto.setSaldoEstoque(quantidadeVendas);
			}
		}
	}

	public String buscaDescricao(String codigoDeVenda) {
		String codigoDeValidacao = "";
		codigoDeValidacao = codigoDeVenda;
		String descricaoProduto = "";
		for (Produto produto : listaProdutosCadastrados) {
			if (produto.getCodigoProduto().equals(codigoDeValidacao)) {
				descricaoProduto = produto.getDescricaoProduto();
				return descricaoProduto;
			}
		}
		return descricaoProduto;
	}

	/*public String geraNotaFiscalDaVenda() {
		String codigoNotaFiscal = "";
		String escreveNotaFiscal = "";
		Double totalNotaFiscal = 0.00;
		for (Cupons cupons : listaCuponsGerados) {
			codigoNotaFiscal += cupons.getCodigoCupom();
			escreveNotaFiscal = "";

			escreveNotaFiscal += "Nota Fiscal " + codigoNotaFiscal + "\n";
			escreveNotaFiscal += "Data" + " | " + "Codigo De item " + " | " + "Descrição de Produto" + " | "
					+ "Quantidade de Saida" + " | " + "Preço de Venda" + "|" + "Preço total de venda por Item" + "\n";
			for (Cupons cupon : listaCuponsGerados) {
				totalNotaFiscal += cupons.getTotalItem();
				escreveNotaFiscal += cupons.getData() + " | " + cupons.getCodigoProdtutoVenda() + " | "
						+ cupons.getDescricaoProdutoVenda() + " | " + cupons.getSaidaProduto() + " | "
						+ cupons.getPrecoVenda() + " | " + cupons.getTotalItem() + "\n";

				escreveNotaFiscal += "Total da NF " + totalNotaFiscal + "\n";

				return escreveNotaFiscal;

			}
		}
		return escreveNotaFiscal;
	}*/

	public double totalizadorDeVendas() {
		double totalVenda = 0.00;
		double vendaCupom;
		for (Cupons cupons : listaCuponsGerados) {
			vendaCupom = cupons.getTotalItem();
			totalVenda += vendaCupom;
		}
		return totalVenda;
	}

	public boolean validaCodigosCadastrados(String codigoCadastroProduto) {
		String codigoDeValidacao = "";
		codigoDeValidacao = codigoCadastroProduto;
		boolean validaCodigo = true;
		for (Produto produto : listaProdutosCadastrados) {
			if (produto.getCodigoProduto().equals(codigoDeValidacao)) {
				validaCodigo = false;
				return validaCodigo;
			}
		}
		return validaCodigo;
	}

	public boolean validaSaldoEstoque(String codigoDeVenda, int quantidadeDeVenda) {
		boolean validaSaldoEstoque = true;
		String codigoDeValidacao = "";
		codigoDeValidacao = codigoDeVenda;
		int volumeDeVendas = quantidadeDeVenda;
		for (Produto produto : listaProdutosCadastrados) {
			if (produto.getCodigoProduto().equals(codigoDeValidacao)) {
				if (produto.getSaldoEstoque() < quantidadeDeVenda) {
					validaSaldoEstoque = false;
				}
			}
		}

		return validaSaldoEstoque;

	}

}
