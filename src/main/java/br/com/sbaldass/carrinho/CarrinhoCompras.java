package br.com.sbaldass.carrinho;


import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Objects;

public class CarrinhoCompras {
	private LinkedHashMap<Produto, Item> itens = new LinkedHashMap<>();

    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
		try{
			if(itens.containsKey(produto)){
				Item existingItem = itens.get(produto);
				existingItem.addQuantidade(quantidade);

				if(!Objects.equals(existingItem.getValorUnitario(), valorUnitario)){
					existingItem.atualizarValor(valorUnitario);
				}
			}else{
				Item novoItem = new Item(produto, valorUnitario, quantidade);
				itens.put(produto, novoItem);
			}
		}catch(RuntimeException e){
			throw new RuntimeException("Não foi possível adicionar o item.");
		}
    }

    public boolean removerItem(Produto produto) {
		return itens.containsKey(produto);
    }

    public boolean removerItem(int posicaoItem) {
		return posicaoItem >= 0 && posicaoItem < itens.size();
    }

    public BigDecimal getValorTotal() {
		int sum = 0;
		for (Item entry : itens.values()){
			sum += Integer.parseInt(String.valueOf(entry.getValorTotal()));
		}

		return BigDecimal.valueOf(sum);
    }

    public Collection<Item> getItens() {
		return itens.values();
    }
}