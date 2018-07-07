package var3.task2;

import javafx.geometry.Point3D;

public class Main {
	public static void main(String[] args) {
		Vector a = new Vector(new Point3D(1, 2, 3));
		Vector b = new Vector(new Point3D(2, 4, 16));
		Vector c = new Vector(new Point3D(33, 66, 22));

		System.out.println("norm for vector a is " + a.norm());
		System.out.println("norm for vector b is " + b.norm());
		System.out.println("norm for vector c is " + c.norm());

		Vector r = a.addition(b).vectorMultiplication(c);
		r.info();

		double t = a.addition(b).scalarMultiplication(c);
		System.out.println("(a+b)c = " + t);

	}
}
