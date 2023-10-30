package model;

public class Gerente extends Cargo {

	public static double VALOR_SALARIO = 1000.0;
	public static double VALOR_HORA_EXTRA = 250.0;
	public static double VALOR_PROJETOS_CONCLUIDOS = 100.0;

	double valorSubordinados;
	double valorProjetosConcluidos;

	public Gerente(int quantidadeHorasExtras, int numeroSubordinados, int projetosConcluidos) {
		super("Gerente", VALOR_SALARIO, quantidadeHorasExtras);
		this.valorSubordinados = (this.salario * 0.01) * numeroSubordinados;
		this.valorProjetosConcluidos = VALOR_PROJETOS_CONCLUIDOS * projetosConcluidos;
	}

	@Override
	public double getHorasExtras() {
		return this.quantidadeHoraExtra * VALOR_HORA_EXTRA;
	}

	@Override
	public double getSalario() {
		double salarioTotal = this.salario + this.getHorasExtras() + this.valorSubordinados
				+ this.valorProjetosConcluidos;
		return salarioTotal;
	}

}
