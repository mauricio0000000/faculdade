package dao;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import entidade.Cliente;

public class ClienteDAO {
	
	private static ClienteDAO instance;
	List<Cliente> listaDeClientes = new ArrayList<>();

	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}

	public void adicionarCliente(Cliente cliente) {
		if (cliente != null && !listaDeClientes.contains(cliente)) {
			listaDeClientes.add(cliente);
		}
	}

	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(List<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
	
	public Cliente existeClienteByName(String nome) {
		for (Cliente cliente : listaDeClientes) {
			if(cliente.getNome().equalsIgnoreCase(nome)) {
				return cliente;
			}
		}
		return null;
	}
}

