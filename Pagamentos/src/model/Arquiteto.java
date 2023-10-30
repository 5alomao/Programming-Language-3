package model;

public class Arquiteto extends Cargo {

	public static double VALOR_SALARIO = 1000.0;
	public static double VALOR_HORA_EXTRA = 200.0;

	double valorParticipacoes;

	public Arquiteto(int quantidadeHorasExtras, int participacoes) {
		super("Arquiteto", VALOR_SALARIO, quantidadeHorasExtras);
		this.valorParticipacoes = (this.salario * 0.02) * participacoes;
	}

	@Override
	public double getHorasExtras() {
		return this.quantidadeHoraExtra * VALOR_HORA_EXTRA;
	}

	@Override
	public double getSalario() {
		double salarioTotal = this.salario + this.getHorasExtras() + this.valorParticipacoes;
		return salarioTotal;
	}

}
