package entidade;

import entidade.Cliente;

public class Cliente {
	
private String nome;
	
	private String cpf;

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public boolean equals(Object cliente) {
		if (this.nome == ((Cliente) cliente).getNome() && this.cpf == ((Cliente) cliente).getCpf()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Nome: " + getNome() + " - CPF: " + getCpf();
	}
}
