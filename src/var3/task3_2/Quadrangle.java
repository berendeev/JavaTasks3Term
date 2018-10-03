package var3.task3_2;

import javafx.geometry.Point2D;

import java.text.DecimalFormat;

public class Quadrangle {    // четырех угольник
	private Point2D leftTop;    //левая верхняя точка
	private Point2D leftBottom;    // правая нижняя
	private Point2D rightTop;
	private Point2D rightBottom;

	public Quadrangle(Point2D leftTop, Point2D leftBottom, Point2D rightTop, Point2D rightBottom) {    // получает координаты
		this.leftTop = leftTop;
		this.leftBottom = leftBottom;
		this.rightTop = rightTop;
		this.rightBottom = rightBottom;
	}

	public double getWidth() {
		return Math.abs(leftTop.getX() - rightTop.getX());
	}    // ширина

	public double getHeight() {
		return Math.abs(leftTop.getY() - leftBottom.getY());
	}    // высота

	public double getPerimeter() {
		return 2 * getWidth() + 2 * getHeight();
	}    // периметр

	public double getArea() {
		return getHeight() * getWidth();
	} // площадь

	public double getFirstDiagonal() {    // длина 1 диагонали
		double x = rightBottom.getX() - leftTop.getX();
		double y = rightBottom.getY() - leftTop.getY();
		return Math.sqrt(x * x + y * y);
	}

	public double getSecondDiagonal() {    // длина 2 диагонали
		double x = leftBottom.getX() - rightTop.getX();
		double y = leftBottom.getY() - rightTop.getY();
		return Math.sqrt(x * x + y * y);
	}

	public void info() {
		DecimalFormat f = new DecimalFormat("0.00");
		System.out.println("Width is " + f.format(getWidth()));
		System.out.println("Height is " + f.format(getHeight()));
		System.out.println("Perimeter is " + f.format(getPerimeter()));
		System.out.println("Area is " + f.format(getArea()));
	}

}
