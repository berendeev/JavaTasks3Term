package var3.task2;

import javafx.geometry.Point3D;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println("============= " + (i + 1) + " ===============");
			Random rnd = new Random();
			Vector a = new Vector(new Point3D(rnd.nextInt(), rnd.nextInt(), rnd.nextInt()));    // создание векторов для примера
			Vector b = new Vector(new Point3D(rnd.nextInt(), rnd.nextInt(), rnd.nextInt()));
			Vector c = new Vector(new Point3D(rnd.nextInt(), rnd.nextInt(), rnd.nextInt()));

			System.out.println("norm for vector a is " + a.norm());    // вывод длины вектора
			System.out.println("norm for vector b is " + b.norm());
			System.out.println("norm for vector c is " + c.norm());

			Vector r = a.addition(b).vectorMultiplication(c); // (a+b) и векторное умножение на c
			r.info();    // вывод информации о векторе r

			double t = a.addition(b).scalarMultiplication(c); // (a+b)c
			System.out.println("(a+b)c = " + t);
		}
	}
}
