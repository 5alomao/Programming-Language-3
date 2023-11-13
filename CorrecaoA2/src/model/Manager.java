package model;

public class Manager extends Employee {

	private int subordinates;
	private double percentagePerSubordinate;
	private int doneProjects;
	private double bonusPerProject;

	public Manager(String name, double salary, int subs, double percentage, int doneProjects, double bonusPerProject) {
		// TODO Auto-generated constructor stub
		super(name, "Gerente", salary);
		this.subordinates = subs;
		this.percentagePerSubordinate = percentage;
		this.doneProjects = doneProjects;
		this.bonusPerProject = bonusPerProject;
	}

	@Override
	public double salary() {
		double valuePerSub = getSalary() * percentagePerSubordinate;
		double extraBonus = valuePerSub * subordinates;
		double projectBonus = doneProjects * bonusPerProject;

		return baseSalary() + extraBonus + projectBonus;
	}

}
