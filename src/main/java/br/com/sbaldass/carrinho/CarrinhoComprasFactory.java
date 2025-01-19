package br.com.sbaldass.carrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;


public class CarrinhoComprasFactory {

	private Map<String, CarrinhoCompras> carrinhos = new HashMap<>();
	private Map<String, Boolean> statusCliente = new HashMap<>();

	public CarrinhoComprasFactory() {
	}

	public CarrinhoCompras criar(String identificacaoCliente) {
		if (identificacaoCliente == null) {
			throw new NullPointerException("identificacaoCliente cannot be null");
		}

		if (carrinhos.containsKey(identificacaoCliente)) {
			return carrinhos.get(identificacaoCliente);
		}

		CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
		carrinhos.put(identificacaoCliente, carrinhoCompras);
		statusCliente.put(identificacaoCliente, true);
		return carrinhoCompras;
	}

	public BigDecimal getValorTicketMedio() {
		BigDecimal somaTotal = BigDecimal.ZERO;
		int qtdItens = 0;

		for (CarrinhoCompras carrinho : carrinhos.values()) {
			for (Item item : carrinho.getItens()) {
				BigDecimal valorTotalItem = item.getValorUnitario().multiply(BigDecimal.valueOf(item.getQuantidade()));
				somaTotal = somaTotal.add(valorTotalItem);
				qtdItens += item.getQuantidade();
			}
		}
		return qtdItens == 0 ? BigDecimal.ZERO : somaTotal.divide(BigDecimal.valueOf(qtdItens), 2, RoundingMode.HALF_UP);
	}

	public boolean invalidar(String identificacaoCliente) {
		if (statusCliente.containsKey(identificacaoCliente)) {
			statusCliente.put(identificacaoCliente, false);
			return true;
		} else {
			return false;
		}
	}
}
