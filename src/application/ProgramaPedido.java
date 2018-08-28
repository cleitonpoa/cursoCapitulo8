package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import entities.enuns.StatusPedido;

/*
Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um
sumário do pedido conforme exemplo (próxima página). Nota: o instante do pedido deve ser
o instante do sistema: new Date()
*/
public class ProgramaPedido {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		Cliente cliente;
		System.out.println("Informe os dados do cliente: ");
		System.out.print("Nome: ");
		String nomeCliente = sc.next();
		System.out.print("E-mail: ");
		String emailCliente = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Data Nascimento (DD/MM/AAAA): ");
		Date dataNascCliente = sdf.parse(sc.next());
		cliente = new Cliente(nomeCliente, emailCliente, dataNascCliente);

		Pedido pedido;
		System.out.println("Informe o número do status do Pedido:");
		System.out.print("[PENDENTE_PAGAMENTO(1), PROCESSANDO(2), ENVIADO(3), ENTREGUE(4)]");
		StatusPedido statusPedido = StatusPedido.criarPorNumero(sc.nextInt());
		pedido = new Pedido(new Date(), statusPedido, cliente);

		System.out.print("Quantos tipos de itens o pedido possui?");
		int numItens = sc.nextInt();
		for (int i = 0; i < numItens; i++) {
			System.out.println("Informar dados do item " + (i + 1) + ":");
			System.out.print("Nome produto: ");
			String nomeProduto = sc.next();
			System.out.print("Preço produto: ");
			double precoProduto = sc.nextDouble();
			System.out.print("Quantidade: ");
			int qtdProduto = sc.nextInt();
			Produto produto = new Produto(nomeProduto, precoProduto);
			ItemPedido itemPedido = new ItemPedido(qtdProduto, produto);
			pedido.adicionarItens(itemPedido);
		}

		System.out.printf("%n" + pedido.toString());

		sc.close();

	}

}
