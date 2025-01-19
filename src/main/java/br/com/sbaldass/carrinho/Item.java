package br.com.sbaldass.carrinho;

import java.math.BigDecimal;

public class Item {

	private Produto produto;
	private BigDecimal valorUnitario;
	private int quantidade;

	public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void addQuantidade(int qtd){
		this.quantidade += qtd;
	}

	public void atualizarValor(BigDecimal novoValor){
		this.valorUnitario = novoValor;
	}

	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public BigDecimal getValorTotal() {
		double res = Double.parseDouble(String.valueOf(this.quantidade)) * Double.parseDouble(String.valueOf(this.valorUnitario));
		return BigDecimal.valueOf(res);
	}
}
