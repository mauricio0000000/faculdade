package dao;

import java.util.ArrayList;
import java.util.List;

import dao.FormasPagamentoDAO;
import entidade.FormasPagamentos;

public class FormasPagamentoDAO {
	
	private static FormasPagamentoDAO instance;
	List<FormasPagamentos> listaDeFormasDePagamento = new ArrayList<>();

	public static FormasPagamentoDAO getInstance() {
		if (instance == null) {
			instance = new FormasPagamentoDAO();
		}
		return instance;
	}

	public void adicionarFormaDePagamento(FormasPagamentos formas) {
		if (formas != null && !listaDeFormasDePagamento.contains(formas)) {
			listaDeFormasDePagamento.add(formas);
		}else {
			System.out.println("Já foi cadastrado esta forma de pagamento: " + formas.getForma());
		}
	}

	public List<FormasPagamentos> getListaDeFormasPagamento() {
		return listaDeFormasDePagamento;
	}

	public void setListaDeFormasPagamento(List<FormasPagamentos> listaDeFormasDePagamento) {
		this.listaDeFormasDePagamento = listaDeFormasDePagamento;
	}

	public FormasPagamentos existePagamentoByName(String nomePgto) {
		for (FormasPagamentos f : listaDeFormasDePagamento) {
			if(f.getForma().equalsIgnoreCase(nomePgto)) {
				return f;
			}
		}
		return null;
	}

	public void adicionarFormaDePagamento1(FormasPagamentos formaPgto) {
		// TODO Auto-generated method stub
		
	}

	public void adicionarFormaDePagamento1(FormasPagamentos formaPgto) {
		// TODO Auto-generated method stub
		
	}
}

