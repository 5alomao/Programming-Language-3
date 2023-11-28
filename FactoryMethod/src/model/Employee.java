package model;

public abstract class Employee {

	private String position;

	public Employee(String position) {
		this.position = position;
	}

	public String getPositon() {
		return this.position;
	}

	public abstract double calculateSalary();

}
