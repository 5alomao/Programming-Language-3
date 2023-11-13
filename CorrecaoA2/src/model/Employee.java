package model;

public abstract class Employee {

	private String name;
	private String role;
	private double salary;
	private double perExtraHourValue;
	private double extraHours;

	public Employee(String name, String hole, double salary) {
		this.name = name;
		this.role = role;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	protected double getSalary() {
		return salary;
	}

	public double getPerExtraHourValue() {
		return perExtraHourValue;
	}

	public double getExtraHours() {
		return extraHours;
	}

	public void setPerExtraHourValue(double perExtraHourValue) {
		this.perExtraHourValue = perExtraHourValue;
	}

	public void setExtraHours(double extraHours) {
		this.extraHours = extraHours;
	}

	protected double baseSalary() {
		double extraEarnings = getExtraHours() * getPerExtraHourValue();

		return this.salary + extraEarnings;
	}

	public abstract double salary();
}
