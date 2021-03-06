package var8.task2;


import javafx.geometry.Point3D;

import java.util.Random;
import java.util.Scanner;

/*
	http://mathprofi.ru/vektory_dlya_chainikov.html
	http://ru.onlinemschool.com/math/library/vector/cos/
	https://en.wikipedia.org/wiki/Vector_space
 */
public class Main {
	public static void main(String[] args) {    // искуственно созданный кусок кода для примера
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		while (true) {
			Vector a = new Vector(new Point3D(random.nextInt(100), random.nextInt(100), random.nextInt(100)));
			Vector b = new Vector(new Point3D(random.nextInt(100), random.nextInt(100), random.nextInt(100)));

			Vector c = (a.addition(b)).vectorMultiplication(b);    // с = (a + b)* b
			c.info();    // для просмотра результата выполнения строки выше

			double f = a.scalarMultiplication(c);    // f = ac
			System.out.printf("f = %.2f\n" , f);        // вывод результата[%.2f подставит вместо этого f, .2 - 2 знака после запятой f - float]

			System.out.println("repeat?yes/no");
			while (true) {
				String intention = scanner.nextLine();
				if (intention.equals("no")) {
					return;
				}
				if (intention.equals("yes")) {
					break;
				}
				System.out.println("Wrong format...");
			}
		}

	}
}
