package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Funcionario;
import entities.enuns.NivelFuncionario;

/*
Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário). Depois, solicitar
do usuário um mês e mostrar qual foi o salário do funcionário nesse mês
*/

public class ProgramaContratoFuncionario {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe os dados do funcionario: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Número do Nível [1-JUNIOR, 2-PLENO, 3-SENIOR]:");
		NivelFuncionario nivel = NivelFuncionario.porNumero(sc.nextInt());
		System.out.print("Salario base: ");
		double salario = sc.nextDouble();

		Funcionario funcionario = new Funcionario(nome, nivel, salario);

		// System.out.println("Dados do funcionario: " + funcionario.toString());

		System.out.print("Informar quantos contratos este funcionario possui: ");
		int totalContratos = sc.nextInt();

		for (int i = 0; i < totalContratos; i++) {
			System.out.println("Informar dados contrato " + (i + 1) + ":");
			System.out.print("Data <dd/mm/aaaa>: ");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataCont = sdf.parse(sc.next());

			System.out.println("Valor hora: ");
			double valorHora = sc.nextDouble();

			System.out.print("Duracao em horas: ");
			int duracao = sc.nextInt();

			ContratoHora contratoHora = new ContratoHora(dataCont, valorHora, duracao);

			funcionario.adicionarContrato(contratoHora);
		}

		System.out.println("");
		System.out.print("Informar mes e ano dos contratos para calular salario <mm/aaaa>: ");
		String dataValor = sc.next();
		Integer mes = Integer.parseInt(dataValor.substring(0, 2));
		Integer ano = Integer.parseInt(dataValor.substring(3));

		System.out.printf("Valores totais recebidos: R$%.2f", funcionario.valoresRecebidos(ano, mes));

		sc.close();

	}

}