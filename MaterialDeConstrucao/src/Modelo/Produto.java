package Modelo;

import java.time.LocalDate;

public class Produto {

	private String descricaoProduto;
	private String codigoProduto;
	private int saldoEstoque;
	
	
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	
	public String getCodigoProduto() {
		return codigoProduto;
	}
	
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public int getSaldoEstoque() {
		return saldoEstoque;
	}
	
	public void setSaldoEstoque(int quantidadeDeEntrada) {
		this.saldoEstoque = quantidadeDeEntrada;
	}
	
	
}
