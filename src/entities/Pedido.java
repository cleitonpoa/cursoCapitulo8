package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enuns.StatusPedido;

public class Pedido {

	public static final SimpleDateFormat FORMATACAO_DATA = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date data;
	private StatusPedido status;
	private List<ItemPedido> itens = new ArrayList<>();
	private Cliente cliente;

	public Pedido(Date data, StatusPedido status, Cliente cliente) {
		this.data = data;
		this.status = status;
		this.cliente = cliente;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void adicionarItens(ItemPedido itemPedido) {
		itens.add(itemPedido);
	}

	public void removerItens(ItemPedido itemPedido) {
		itens.remove(itemPedido);
	}

	public Double precoTotalPedido() {
		Double soma = 0.0;
		for (ItemPedido itemPedido : itens) {
			soma += itemPedido.getPreco();
		}
		return soma;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RESUMO DO PEDIDO:\n");
		sb.append("Data do pedido: " + Pedido.FORMATACAO_DATA.format(data) + "\n");
		sb.append("Status Pedido: " + status + "\n");
		sb.append("Cliente: " + cliente.getNome());
		sb.append(" (" + Cliente.FORMATO_DATA_NASCIMENTO.format(cliente.getDataNascimento()) + ") - ");
		sb.append(cliente.getEmail() + "\n");

		if (!itens.isEmpty()) {
			sb.append("ITENS DO PEDIDO:\n");
			for (ItemPedido itemPedido : itens) {
				sb.append(itemPedido.getProduto().getNome() + ", ");
				sb.append("R$" + String.format("%.2f", itemPedido.getProduto().getPreco()) + ", ");
				sb.append("Quantidade: " + itemPedido.getQuantidade() + ", ");
				sb.append("Preço parcial: R$" + String.format("%.2f", itemPedido.getPreco()) + "\n");
			}
		}
		sb.append("Preço total do pedido: R$" + String.format("%.2f", precoTotalPedido()));

		return sb.toString();
	}

}
