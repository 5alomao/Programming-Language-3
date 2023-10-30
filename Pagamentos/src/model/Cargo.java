package model;

public abstract class Cargo {

	protected String nomeCargo;
	protected double salario;
	protected int quantidadeHoraExtra;

	public Cargo(String nomeCargo, double salario, int quantidadeHoraExtra) {
		this.nomeCargo = nomeCargo;
		this.salario = salario;
		this.quantidadeHoraExtra = quantidadeHoraExtra;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	protected abstract double getSalario();

	protected abstract double getHorasExtras();

}
