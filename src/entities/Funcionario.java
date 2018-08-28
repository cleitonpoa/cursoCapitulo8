package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enuns.NivelFuncionario;

public class Funcionario {

	private String nome;
	private NivelFuncionario nivelFuncionario;
	private Double salarioBase;
	private List<ContratoHora> contratosHora;

	public Funcionario(String nome, NivelFuncionario nivelFuncionario, Double salarioBase) {
		this.nome = nome;
		this.nivelFuncionario = nivelFuncionario;
		this.salarioBase = salarioBase;
		this.contratosHora = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelFuncionario getNivelFuncionario() {
		return nivelFuncionario;
	}

	public void setNivelFuncionario(NivelFuncionario nivelFuncionario) {
		this.nivelFuncionario = nivelFuncionario;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public void adicionarContrato(ContratoHora contratoHora) {
		this.contratosHora.add(contratoHora);
	}

	public void removerContrato(ContratoHora contratoHora) {
		this.contratosHora.remove(contratoHora);
	}

	@Override
	public String toString() {
		return "" + (nome != null ? "nome=" + nome + ", " : "")
				+ (nivelFuncionario != null ? "nivelFuncionario=" + nivelFuncionario + ", " : "")
				+ (salarioBase != null ? "salarioBase=R$" + String.format("%.2f", salarioBase) : "") + "]";
	}

	public Double valoresRecebidos(Integer anoContrato, Integer mesContrato) {
		Double valorTotal = this.salarioBase;
		Calendar cal = Calendar.getInstance();

		for (ContratoHora contratoHora : contratosHora) {
			cal.setTime(contratoHora.getData());
			int ano = cal.get(Calendar.YEAR);
			int mes = cal.get(Calendar.MONTH + 1);

			if (anoContrato == ano && mesContrato == mes) {
				valorTotal += contratoHora.valorTotal();
			}
		}
		return valorTotal;
	}

}