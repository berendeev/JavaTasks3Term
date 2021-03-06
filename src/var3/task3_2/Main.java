package var3.task3_2;

import javafx.geometry.Point2D;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) { // Проверь сам, для меня слишком вводить 4 координаты каждый раз. Найдешь ошибку напищи мне. Походу преподу тоже лень тестить это
		DecimalFormat f = new DecimalFormat("0.00");

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("input count of quadrangles");
			int N = scanner.nextInt();

			List<Quadrangle> quadrangles = new ArrayList<>();
			for (int i = 0; i < N; i++) {    //ввод 4угольнтков
				System.out.println((i + 1) + " quadrangle");

				System.out.println("Left top point");
				Point2D leftTop = getPoint();

				System.out.println("Left bottom point");
				Point2D leftBottom = getPoint();

				System.out.println("Right top point");
				Point2D rightTop = getPoint();

				System.out.println("right bottom point");
				Point2D rightBottom = getPoint();

				Quadrangle quadrangle = new Quadrangle(leftTop, leftBottom, rightTop, rightBottom);
				quadrangles.add(quadrangle);
			}

			System.out.println("input count of squares");
			int M = scanner.nextInt();
			scanner.nextLine();

			List<Square> squares = new ArrayList<>();
			for (int i = 0; i < M; i++) {    //ввод квадратов
				System.out.println((i + 1) + " square");

				System.out.println("Left top point");
				Point2D leftTop = getPoint();

				System.out.println("Left bottom point");
				Point2D leftBottom = getPoint();

				System.out.println("Right top point");
				Point2D rightTop = getPoint();

				System.out.println("right bottom point");
				Point2D rightBottom = getPoint();

				Square square = new Square(leftTop, leftBottom, rightTop, rightBottom);
				squares.add(square);
			}

			if (!quadrangles.isEmpty()) {

				double perimeters = 0;
				double areas = 0;
				for (Quadrangle quadrangle : quadrangles) {    // общие периметр и площадь
					perimeters += quadrangle.getPerimeter();
					areas += quadrangle.getArea();
				}
				double averagePerimeter = perimeters / quadrangles.size();    // средний перимтр
				double averageArea = areas / quadrangles.size();    // средняя площадь

				System.out.println("Average perimeter is " + f.format(averagePerimeter));
				System.out.println("Average area is " + f.format(averageArea));
			} else {
				System.out.println("List of quadrangles is empty");
			}

			if (!squares.isEmpty()) {
				// поиск наименьшего квадрата[по площади]
				Square minSquare = squares.get(0);// первый элемент в списке
				for (Square square : squares) {
					if (minSquare.getArea() > square.getArea()) {
						minSquare = square;
					}
				}

				System.out.println("Min square");
				minSquare.info();
			} else {
				System.out.println("List of square is empty");
			}

			System.out.println("Repeat?yes/no");
			if (scanner.nextLine().equals("no")) {
				return;
			}
		}
	}

	public static Point2D getPoint() {        // вынес в функцию получения координат с консоли, т.к. дуюлировать код для каждой точки перебор
		Scanner scanner = new Scanner(System.in);    // создает сканер
		System.out.println("x = ");
		double x = scanner.nextDouble(); // ввод координаты x
		System.out.println("y = ");
		double y = scanner.nextDouble(); // ввод координаты y
		return new Point2D(x, y); // создает точку по полученным координатам и возвращает ее.
	}
}
