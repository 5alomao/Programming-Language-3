package view;

import model.Country;
import model.CountryEmployeeFactory;
import model.Employee;
import model.EmployeeFactory;
import model.EmployeeType;

public class Main {

	public static void main(String[] args) {
		EmployeeFactory factory = CountryEmployeeFactory.createEmployeeFactory(Country.BR);

		Employee employee = factory.createEmployee(EmployeeType.PROGRAMMER);

		System.out.println(employee.getPositon() + " " + employee.calculateSalary());
	}

}
