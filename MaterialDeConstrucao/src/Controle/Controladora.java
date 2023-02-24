package Controle;

import java.time.LocalDate;

import Modelo.Cupons;
import Modelo.Loja;
import Modelo.Produto;
import Visualisacao.EntradaSaida;

public class Controladora {

	public void exibeMenu() {
		// TODO Auto-generated method stub

		// menu de Escolha
		Loja loja = new Loja();

		int opcao;
		do {
			opcao = EntradaSaida.solicitaOpcao();
			switch (opcao) {

			case 0:
				Produto produto = new Produto();
				String descricaoCadastroProduto;
				String codigoCadastroProduto;
				boolean validaCodigoCasdastro;
				boolean validaDescricao;
				do {
					validaCodigoCasdastro = true;
					codigoCadastroProduto = EntradaSaida.solicitaCodigoCasdastroProduto();
					if (codigoCadastroProduto.isBlank()) {
						validaCodigoCasdastro = false;
						EntradaSaida.codigoForaDosParametros();
					}

					if (validaCodigoCasdastro == true) {
						validaCodigoCasdastro = loja.validaCodigosCadastrados(codigoCadastroProduto);
						if (validaCodigoCasdastro == false) {
							EntradaSaida.codigoJaCadastrado();
						}
					}
				} while (validaCodigoCasdastro != true);

				do {
					validaDescricao = true;
					descricaoCadastroProduto = EntradaSaida.solicitaDescricaoCasdastroProduto();
					if (descricaoCadastroProduto.isBlank()) {
						validaDescricao = false;
						EntradaSaida.descricaoForaDosParametros();
					}
				} while (validaDescricao != true);

				produto.setCodigoProduto(codigoCadastroProduto);
				produto.setDescricaoProduto(descricaoCadastroProduto);
				loja.adicionaProdutoLista(produto);
				break;

			case 1:
				String ListadeProdutos = loja.geraListaDeProdutosCadastrados();
				EntradaSaida.imprimeListaDeprodutos(ListadeProdutos);
				break;

			case 2:
				String codigoDeConsulta = "";
				int quantidadeDeEntrada;
				boolean validaCodigo;

				codigoDeConsulta = EntradaSaida.solicitaCodigoCasdastroProduto();
				validaCodigo = loja.validaCodigoProduto(codigoDeConsulta);
				if (validaCodigo == true) {
					do {
						quantidadeDeEntrada = EntradaSaida.informeQuantidade();
						if (quantidadeDeEntrada <= 0) {
							EntradaSaida.quantidadeInformadaInvalida();
						}

					} while (quantidadeDeEntrada <= 0);

					loja.adicionaEstoque(codigoDeConsulta, quantidadeDeEntrada);
				} else {
					EntradaSaida.avisoDeNaoEncontradoItem();
				}
				break;

			case 3:
				String listaDeEstoque = loja.geraListaDeEstoque();
				EntradaSaida.imprimeListaDeprodutos(listaDeEstoque);
				break;

			case 4:
				Cupons cupons = new Cupons();
				String codigoDeVenda = "";
				String descricaoProdutoDeVenda = "";
				String geraNotaFiscal="";
				int quantidadeDeVenda;
				Double precoDeVenda;
				Double totalVendaPorItem;
				boolean validaCodigoVenda;
				boolean validaEstoques;
				boolean validaSaldoEstoque;
				boolean validaEncerraAVenda = true;
				LocalDate data = EntradaSaida.buscaData();
					
				do {
					do {
						do {
							codigoDeVenda = EntradaSaida.solicitaCodigoCasdastroProduto();
							validaCodigoVenda = loja.validaCodigoProduto(codigoDeVenda);
							if (validaCodigoVenda == true) {
								descricaoProdutoDeVenda = loja.buscaDescricao(codigoDeVenda);
							} else {
								EntradaSaida.avisoDeNaoEncontradoItem();
							}
						} while (validaCodigoVenda != true);

						validaEstoques = true;
						quantidadeDeVenda = EntradaSaida.informeQuantidade();
						if (quantidadeDeVenda <= 0) {
							validaEstoques = false;
							EntradaSaida.quantidadeInformadaInvalida();
						}
					} while (validaEstoques != true);

					validaSaldoEstoque = true;
					validaSaldoEstoque = loja.validaSaldoEstoque(codigoDeVenda, quantidadeDeVenda);
					if (validaSaldoEstoque == false) {
						EntradaSaida.avisoEstoqueNegativo();
					}
				} while (validaSaldoEstoque != true);

				precoDeVenda = EntradaSaida.informePrecoDeVenda();
				
				totalVendaPorItem = EntradaSaida.calculaTotalVendaPorItem(quantidadeDeVenda, precoDeVenda);
				loja.baixaEstoque(codigoDeVenda, quantidadeDeVenda);
				cupons.setData(data);
				cupons.setCodigoProdtutoVenda(codigoDeVenda);
				cupons.setDescricaoProdutoVenda(descricaoProdutoDeVenda);
				cupons.setSaidaProduto(quantidadeDeVenda);
				cupons.setPrecoVenda(precoDeVenda);
				cupons.setTotalItem(totalVendaPorItem);
				loja.adicionaCupomALista(cupons);
				

				validaEncerraAVenda = true;
				EntradaSaida.vendaEncerrada();

				geraNotaFiscal = EntradaSaida.geraNotaFiscalDaVenda(data,codigoDeVenda,descricaoProdutoDeVenda,quantidadeDeVenda,precoDeVenda,totalVendaPorItem);
				EntradaSaida.imprimeListaDeprodutos(geraNotaFiscal);
				

				break;

			case 5:
				double totalDeVendas;
				totalDeVendas = loja.totalizadorDeVendas();
				EntradaSaida.imprimeTotalDeVendas(totalDeVendas);
				break;

			}
		} while (opcao != 6);
		EntradaSaida.exibeMsgEncerraPrograma();

	}

}
