package entities;

public class ItemPedido {

	private Integer quantidade;
	private Double preco;
	private Produto produto;

	public ItemPedido(Integer quantidade, Produto produto) {
		this.quantidade = quantidade;
		this.produto = produto;
		this.preco = calcularPrecoItem();
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public Double calcularPrecoItem() {
		return produto.getPreco() * quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

}
