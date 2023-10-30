package model;

public class LiderTecnico extends Cargo {

	public static double VALOR_SALARIO = 1000.0;
	public static double VALOR_HORA_EXTRA = 150.0;

	private double valorMembrosEquipe;

	public LiderTecnico(int quantidadeHorasExtras, int membrosEquipe) {
		super("Lider Técnico", VALOR_SALARIO, quantidadeHorasExtras);
		this.valorMembrosEquipe = (this.salario * 0.05) * membrosEquipe;
	}

	@Override
	public double getHorasExtras() {
		return this.quantidadeHoraExtra * VALOR_HORA_EXTRA;
	}

	@Override
	public double getSalario() {
		double salarioTotal = this.salario + this.getHorasExtras() + this.valorMembrosEquipe;
		return salarioTotal;
	}

}
