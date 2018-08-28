package entities.enuns;

public enum NivelFuncionario {

	JUNIOR(1), PLENO(2), SENIOR(3);

	private final int nivel;

	NivelFuncionario(int nivel) {
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}

	public static NivelFuncionario porNumero(int numeroNivel) {
		for (NivelFuncionario nivel : NivelFuncionario.values()) {
			if (numeroNivel == nivel.getNivel()) {
				return nivel;
			}
		}
		throw new IllegalArgumentException("codigo invalido");
	}

}
