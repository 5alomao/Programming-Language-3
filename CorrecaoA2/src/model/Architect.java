package model;

public class Architect extends Employee {

	private int projects;
	private double percentagePerProject;

	public Architect(String name, double salary, int projects, double percentagePerProject) {
		super(name, "Arquiteto", salary);
		this.projects = projects;
		this.percentagePerProject = percentagePerProject / 100;
	}

	@Override
	public double salary() {
		double bonusPerProject = getSalary() * percentagePerProject;
		double extraBonus = bonusPerProject * this.projects;

		return baseSalary() + extraBonus;
	}
}
