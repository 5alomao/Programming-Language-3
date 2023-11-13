package model;

public class TecLeader extends Employee {

	private int subordinates;
	private double percentagePerSubordinate;

	public TecLeader(String name, double salary, int subs, double percentage) {
		// TODO Auto-generated constructor stub
		super(name, "Líder Técnico", salary);
		this.subordinates = subs;
		this.percentagePerSubordinate = percentage;
	}

	@Override
	public double salary() {
		double valuePerSub = getSalary() * percentagePerSubordinate;
		double extraBonus = valuePerSub * subordinates;
		
		return baseSalary() + extraBonus;
	}
}
