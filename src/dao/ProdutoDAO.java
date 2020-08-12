package dao;

import java.util.ArrayList;
import java.util.List;

import dao.ProdutoDAO;
import entidade.Produto;

public class ProdutoDAO {
	
	private static ProdutoDAO instance;
	List<Produto> listaDeProdutos = new ArrayList<>();

	public static ProdutoDAO getInstance() {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}

	public void adicionarNovoProduto(Produto produto) {
		if (produto != null && !listaDeProdutos.contains(produto)) {
			listaDeProdutos.add(produto);
		}
	}

	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	public Produto existeProdutoByName(String nome) {
		for (Produto produto : listaDeProdutos) {
			if(produto.getNome().equalsIgnoreCase(nome)) {
				return produto;
			}
		}
		return null;
	}
}

