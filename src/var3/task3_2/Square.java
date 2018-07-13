package var3.task3_2;

import javafx.geometry.Point2D;

public class Square extends Quadrangle {

	public Square(Point2D leftTop, Point2D leftBottom, Point2D rightTop, Point2D rightBottom) {
		super(leftTop, leftBottom, rightTop, rightBottom);
	}

	public boolean isSquare() {
		return getWidth() == getHeight() && getFirstDiagonal() == getSecondDiagonal();
	}
}
