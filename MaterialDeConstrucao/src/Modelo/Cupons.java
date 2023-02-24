package Modelo;

import java.time.LocalDate;

public class Cupons {
	
	private int codigoInicial;
	private int codigoCupom;
	private Double totalCupom;
	private LocalDate data;
	private int saidaProduto;
	private Double precoVenda;
	private Double totalItem;
	private String codigoProdtutoVenda;
	private String descricaoProdutoVenda;
	
	
		
	
	public int getCodigoInicial() {
		return codigoInicial;
	}

	public void setCodigoInicial(int codigoInicial) {
		this.codigoInicial = codigoInicial;
	}

	public String getCodigoProdtutoVenda() {
		return codigoProdtutoVenda;
	}
	
	public void setCodigoProdtutoVenda(String codigoProdtutoVenda) {
		this.codigoProdtutoVenda = codigoProdtutoVenda;
	}
	
	public String getDescricaoProdutoVenda() {
		return descricaoProdutoVenda;
	}
	
	public void setDescricaoProdutoVenda(String descricaoProdutoVenda) {
		this.descricaoProdutoVenda = descricaoProdutoVenda;
	}
	
	public Double getTotalCupom() {
		return totalCupom;
	}
	
	public void setTotalCupom(Double totalCupom) {
		this.totalCupom = totalCupom;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public int getSaidaProduto() {
		return saidaProduto;
	}
	
	public void setSaidaProduto(int saidaProduto) {
		this.saidaProduto = saidaProduto;
	}
	
	public Double getPrecoVenda() {
		return precoVenda;
	}
	
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public Double getTotalItem() {
		return totalItem;
	}
	
	public void setTotalItem(Double totalItem) {
		this.totalItem = totalItem;
	}

	public int getCodigoCupom() {
		return codigoCupom;
	}

	public void setCodigoCupom(int codigoCupom) {
		this.codigoCupom = codigoCupom;
	}
	
	

	
	
}
