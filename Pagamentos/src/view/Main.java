package view;

import model.GerenciadorEmpresa;

public class Main {

	public static void main(String[] args) {

		GerenciadorEmpresa ifsuldeminas = new GerenciadorEmpresa();

		ifsuldeminas.abrirEmpresa();
		ifsuldeminas.addFuncionario("Emerson de Assis Carvalho", "gerente");
		ifsuldeminas.addFuncionario("Matheus Eloy Franco", "lidertec");
		ifsuldeminas.addFuncionario("Salomão Ferreira Junior", "analista");
		ifsuldeminas.addFuncionario("Leonardo Paiva Pinto", "arquiteto");
		ifsuldeminas.printFuncionarios();
		ifsuldeminas.fecharEmpresa();

	}

}
