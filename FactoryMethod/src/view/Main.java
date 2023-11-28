package view;

import model.Employee;
import model.EmployeeFactory;
import model.EmployeeType;
import model.br.EmployeeFactoryBR;

public class Main {

	public static void main(String[] args) {
		EmployeeFactory factory = new EmployeeFactoryBR();

		Employee employee = factory.createEmployee(EmployeeType.PROGRAMMER);

		System.out.println(employee.getPositon() + " " + employee.calculateSalary());
	}

}
