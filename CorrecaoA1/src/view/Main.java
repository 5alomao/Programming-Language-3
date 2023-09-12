package view;

import model.Circle;
import model.Square;
import model.Rectangle;
import model.Triangle;
import model.Shape;

public class Main {

	public static void main(String[] args) {

		Shape s1 = new Square(10);
		Shape r1 = new Rectangle(10, 5);
		Shape c1 = new Circle(3);
		Shape t1 = new Triangle(2, 5);

		Canvas c = new Canvas();

		c.addShape(s1);
		c.addShape(r1);
		c.addShape(c1);
		c.addShape(t1);

		c.printShapes();
	}

}
