package model;

public class Rectangle implements Shape {

	private double base;
	private double height;

	public Rectangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public String name() {
		return "Retângulo";
	}

	@Override
	public double area() {
		return this.base * this.height;
	}

}
