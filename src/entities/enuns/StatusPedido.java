package entities.enuns;

public enum StatusPedido {

	PENDENTE_PAGAMENTO(1), PROCESSANDO(2), ENVIADO(3), ENTREGUE(4);

	private int numStatus;

	StatusPedido(int numStatus) {
		this.numStatus = numStatus;
	}

	public int getNumStatus() {
		return numStatus;
	}

	public static StatusPedido criarPorNumero(int numStatus) {
		for (StatusPedido status : StatusPedido.values()) {
			if (status.getNumStatus() == numStatus) {
				return status;
			}
		}
		throw new IllegalArgumentException("codigo pedido invalido");

	}

}
