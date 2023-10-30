package model;

public class GerenciadorEmpresa {

	private Empresa objEmpresa;

	public GerenciadorEmpresa() {
		objEmpresa = null;
	}

	public void abrirEmpresa() {
		this.objEmpresa = new Empresa();
	}

	public void fecharEmpresa() {
		this.objEmpresa = null;
	}

	public boolean situacaoEmpresa() {
		return objEmpresa != null;
	}

	public void addFuncionario(String nome, String idCargo) {
		if (situacaoEmpresa()) {
			objEmpresa.addFuncionario(nome, idCargo);
		}
	}

	public void printFuncionarios() {

		if (situacaoEmpresa()) {
			objEmpresa.printFuncionarios();
			System.out.println("---------------------------");
			System.out.println("Total De Despesas com Salários:" + objEmpresa.getDespesaTotalSalarios());
		}
	}
}
