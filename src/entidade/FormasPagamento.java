package entidade;

import entidade.FormasPagamentos;

public class FormasPagamento {
	
	private String forma;

	public FormasPagamento(String forma) {
		this.forma = forma;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.forma == ((FormasPagamentos) obj).getForma()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "FormasPagamentos = " + forma;
	}
	
}
