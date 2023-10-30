package model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private List<Funcionario> funcionarios;
	private double despesaTotalSalarios;

	public Empresa() {
		funcionarios = new ArrayList<>();
	}

	public void addFuncionario(String nome, String idCargo) {
		Funcionario objFuncionario = new Funcionario(nome, idCargo);
		funcionarios.add(objFuncionario);
	}

	public double getDespesaTotalSalarios() {
		for (Funcionario objFuncionario : funcionarios) {
			this.despesaTotalSalarios += objFuncionario.getObjCargo().getSalario();
		}
		return despesaTotalSalarios;
	}

	public void printFuncionarios() {
		int cont = 1;
		for (Funcionario objFuncionario : funcionarios) {
			System.out.println("Funcionário [" + cont + "]:");
			String descricao = String.format("Nome: %s | Cargo: %s | Salário: %.2f", objFuncionario.getNome(),
					objFuncionario.getObjCargo().getNomeCargo(), objFuncionario.getObjCargo().getSalario());
			System.out.println(descricao);
			cont++;
		}
	}
}
