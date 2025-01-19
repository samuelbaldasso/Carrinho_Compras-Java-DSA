package br.com.sbaldass.carrinho;

import java.util.Objects;

public class Produto {

	private Long codigo;
	private String descricao;

	public Produto(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Produto produto = (Produto) obj;
		return Objects.equals(this.codigo, produto.codigo);
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(String.valueOf(this.codigo));
	}
}