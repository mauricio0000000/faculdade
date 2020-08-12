package entidade;

import entidade.Produto;

public class Produto {
	
private String nome;
	
	private Integer quantidadeEstoque;

	public Produto(String nome, Integer quantidadeEstoque) {
		this.nome = nome;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	@Override
	public boolean equals(Object produto) {
		if (this.nome == ((Produto) produto).getNome()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + "]";
	}
}
