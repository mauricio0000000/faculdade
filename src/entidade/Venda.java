package entidade;

import java.util.List;

import entidade.Cliente;
import entidade.FormasPagamentos;
import entidade.Produto;

public class Venda {
	
private Cliente cliente;
	
	private List<Produto> produtos;
	
	private FormasPagamentos formaDePagamento;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public FormasPagamentos getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormasPagamentos formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	@Override
	public String toString() {
		return "Venda: " + this.cliente + " " + this.formaDePagamento + " " + this.produtos + ".";
	}
}

