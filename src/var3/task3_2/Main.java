package var3.task3_2;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) { // не проверял вообще
		Scanner scanner = new Scanner(System.in);

		System.out.println("input count of quadrangles");
		int N = scanner.nextInt();

		List<Quadrangle> quadrangles = new ArrayList<>();
		for (int i = 0; i < N; i++) {    //ввод 4угольнтков
			System.out.println((N + 1) + "quadrangle");

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

		List<Square> squares = new ArrayList<>();
		for (int i = 0; i < M; i++) {    //ввод квадратов
			System.out.println((M + 1) + "square");

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

		double perimeters = 0;
		double areas = 0;
		for (Quadrangle quadrangle : quadrangles) {    // общие периметр и площадь
			perimeters += quadrangle.getPerimetr();
			areas += quadrangle.getArea();
		}
		double averagePerimeter = perimeters / quadrangles.size();    // средний перимтр
		double averageArea = areas / quadrangles.size();    // средняя площадь

		System.out.println("Average perimeter is " + averagePerimeter);
		System.out.println("Average area is " + averageArea);

		// поиск наименьшего квадрата[по площади]
		Square minSquare = squares.get(0);// первый элемент в списке
		for (Square square : squares) {
			if (minSquare.getArea() > square.getArea()) {
				minSquare = square;
			}
		}

		System.out.println("Min square");
		minSquare.info();

	}

	public static Point2D getPoint() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("x = ");
		double x = scanner.nextDouble();
		System.out.println("y = ");
		double y = scanner.nextDouble();
		return new Point2D(x, y);
	}
}
