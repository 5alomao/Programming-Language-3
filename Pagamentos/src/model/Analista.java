package model;

public class Analista extends Cargo {

	public static double VALOR_SALARIO = 1000.0;
	public static double VALOR_HORA_EXTRA = 100.0;

	public Analista(int quantidadeHorasExtras) {
		super("Analista", VALOR_SALARIO, quantidadeHorasExtras);
	}

	@Override
	public double getHorasExtras() {
		return this.quantidadeHoraExtra * VALOR_HORA_EXTRA;
	}

	@Override
	public double getSalario() {
		double salarioTotal = this.salario + this.getHorasExtras();
		return salarioTotal;
	}

}
