package var3.task2;

import javafx.geometry.Point3D;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("============= ======== ===============");
			Random rnd = new Random();
			Vector a = new Vector(new Point3D(rnd.nextInt(10), rnd.nextInt(10), rnd.nextInt(10)));    // создание векторов для примера
			Vector b = new Vector(new Point3D(rnd.nextInt(10), rnd.nextInt(10), rnd.nextInt(10)));
			Vector c = new Vector(new Point3D(rnd.nextInt(10), rnd.nextInt(10), rnd.nextInt(10)));

			System.out.printf("norm for vector a is %.2f\n", a.norm());    // вывод длины вектора
			System.out.printf("norm for vector b is %.2f\n", b.norm());
			System.out.printf("norm for vector c is %.2f\n", c.norm());

			Vector r = a.addition(b).vectorMultiplication(c); // (a+b) и векторное умножение на c
			r.info();    // вывод информации о векторе r

			double t = a.addition(b).scalarMultiplication(c); // (a+b)c
			System.out.printf("(a+b)c = %.2f\n", t);

			System.out.println("repeat?yes/no");
			if (scanner.nextLine().equals("no")) {
				return;
			}
		}
	}
}
