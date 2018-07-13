package var3.task3_2;

import javafx.geometry.Point2D;

public class Quadrangle {
	private Point2D leftTop;
	private Point2D leftBottom;
	private Point2D rightTop;
	private Point2D rightBottom;

	public Quadrangle(Point2D leftTop, Point2D leftBottom, Point2D rightTop, Point2D rightBottom) {
		this.leftTop = leftTop;
		this.leftBottom = leftBottom;
		this.rightTop = rightTop;
		this.rightBottom = rightBottom;
	}

	public double getWidth() {
		return Math.abs(leftTop.getX() - rightTop.getX());
	}

	public double getHeight() {
		return Math.abs(leftTop.getY() - leftBottom.getY());
	}

	public double getPerimetr() {
		return 2 * getWidth() + 2 * getHeight();
	}

	public double getArea() {
		return getHeight() * getWidth();
	}

	public double getFirstDiagonal() {
		double x = rightBottom.getX() - leftTop.getX();
		double y = rightBottom.getY() - leftTop.getY();
		return Math.sqrt(x * x + y * y);
	}

	public double getSecondDiagonal() {
		double x = leftBottom.getX() - rightTop.getX();
		double y = leftBottom.getY() - rightTop.getY();
		return Math.sqrt(x * x + y * y);
	}

	public void info() {
		System.out.println("Width is " + getWidth());
		System.out.println("Height is " + getHeight());
		System.out.println("Perimeter is " + getPerimetr());
		System.out.println("Area is " + getArea());
	}

}
