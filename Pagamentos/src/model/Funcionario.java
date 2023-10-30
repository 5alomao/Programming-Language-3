package model;

public class Funcionario {

	private String nome;
	Cargo objCargo;

	public Funcionario(String nome, String idCargo) {
		this.nome = nome;
		this.objCargo = Dados.getCargo(idCargo);
	}

	public String getNome() {
		return nome;
	}

	public Cargo getObjCargo() {
		return objCargo;
	}

}
