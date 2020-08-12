package dao;

import java.util.ArrayList;
import java.util.List;

import dao.VendaDAO;
import entidade.Venda;

public class VendaDAO {
	
	private static VendaDAO instance;
	List<Venda> listaDeVendas = new ArrayList<>();

	public static VendaDAO getInstance() {
		if (instance == null) {
			instance = new VendaDAO();
		}
		return instance;
	}

	public void adicionarVenda(Venda venda) {
		if (venda != null) {
			listaDeVendas.add(venda);
		}
	}

	public List<Venda> getListaDeVendas() {
		return listaDeVendas;
	}

	public void setListaDeVendas(List<Venda> listaDeVendas) {
		this.listaDeVendas = listaDeVendas;
	}
	
	public void listar() {
		for (Venda venda : listaDeVendas) {
			System.out.println(venda);
		}
	}
}
