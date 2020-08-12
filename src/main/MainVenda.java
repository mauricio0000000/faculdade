package main;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import dao.FormasPagamentoDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import entidade.Cliente;
import entidade.FormasPagamentos;
import entidade.Produto;
import entidade.Venda;
import util.Console;

public class MainVenda {
	
	public static void main(String[] args) {

		String[] opcoes = { "Cadastrar cliente", "Cadastrar produto",
				"Cadastrar forma de pagamento",
				"Cadastrar uma venda", "Listar vendas", "Listar vendas por forma de pagamento" };
		String titulo = "**** Supercado - Controlador ****";
		Boolean opcaoSair = true;
		Boolean continuar = true;
		
		do {
			/**
			 * O método abaixo monta o menú e espera a seleção do usuário.
			 */
			int opcao = Console.mostrarMenu(opcoes, titulo, opcaoSair);
			/**
			 * Após a seleção escolhida, faz-se um switch case para processar a opção do
			 * usuário. A opção -1 significa que o usuário escolheu a opção de saída.
			 */
			switch (opcao) {
			case 1:
				cadastrarCliente();
				break;	
			case 2:
				cadastrarProduto();
				break;	

			case 3:
				cadastrarFormaDePagamento();
				break;

			case 4:
				cadastrarVenda();
				break;

			case 5:
				imprimirVendas();
				break;

			case 6:
				System.out.println("****************** Lista de Vendas Efetuadas **************************");
				VendaDAO.getInstance().getListaDeVendas();
				System.out.println("\n\n\n");
			case -1:
				continuar = false;
				System.out.println("/*** Sistema encerrado ***/");
				break;
			}
			System.out.println();
		} while (continuar);

	}
	
	private static void cadastrarCliente() {
		String nome = Console.lerTexto("Informe o nome do cliente:");
		String cpf = Console.lerTexto("Informe o CPF do cliente:");
		Cliente cliente = new Cliente(nome, cpf);
		ClienteDAO.getInstance().adicionarCliente(cliente);
		System.out.println("Cliente cadastrado com sucesso!");
	}

	private static void cadastrarProduto() {
		String nome = Console.lerTexto("Informe o nome do produto:");
		Integer quantidade = Console.lerInteiroPositivo("Digite a quantidade do produto em estoque:");
		Produto produto = new Produto(nome, quantidade);
		ProdutoDAO.getInstance().adicionarNovoProduto(produto);
		System.out.println("Produto cadastrado com sucesso!");
	}
	
	private static void cadastrarFormaDePagamento() {
		String nome = Console.lerTexto("Informe 1 forma de pagamento:");
		FormasPagamentos formaPgto = new FormasPagamentos();
		FormasPagamentoDAO.getInstance().adicionarFormaDePagamento(formaPgto);
		System.out.println("Forma de pagamento cadastrada com sucesso!");
	}
	
	private static void cadastrarVenda() {
		Venda venda = new Venda();
		String nomeCliente = Console.lerTexto("Informe o nome do cliente:");
		
		if(ClienteDAO.getInstance().existeClienteByName(nomeCliente) != null) {
			venda.setCliente(ClienteDAO.getInstance().existeClienteByName(nomeCliente));
		}else {
			System.out.println("ERROR. Cliente não cadastrado, favor cadastrar Cliente antes de efetuar uma Venda.\n\n");
			return;
		}
		
		String nomeProduto = Console.lerTexto("Informe o produto:");
		List<Produto> produtos = new ArrayList<>();
		
		if(ProdutoDAO.getInstance().existeProdutoByName(nomeProduto) != null) {
			produtos.add(ProdutoDAO.getInstance().existeProdutoByName(nomeProduto));
		} else {
			System.out.println("ERROR. Produto não cadastrado, favor cadastrar produto antes de efetuar uma Venda.\n\n");
			return;
		}
		
		if(!produtos.isEmpty()) {
			venda.setProdutos(produtos);
		}
		
		System.out.println("*** Formas de pagamento ***");
		for (FormasPagamentos forma : FormasPagamentoDAO.getInstance().getListaDeFormasPagamento()) {
			System.out.println(forma.getForma());
		}
		String formaPgto = Console.lerTexto("Forma de pagamento: ");
		if(FormasPagamentoDAO.getInstance().existePagamentoByName(formaPgto) != null) {
			venda.setFormaDePagamento(FormasPagamentoDAO.getInstance().existePagamentoByName(formaPgto));
		}else {
			System.out.println("ERROR. Forma de pagamento selecionada não existe.\n\n");
			return;
		}
		
		VendaDAO.getInstance().adicionarVenda(venda);
	}
	
	private static void imprimirVendas() {
		VendaDAO.getInstance().listar();
	}
}

