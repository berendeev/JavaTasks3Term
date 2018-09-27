package var3.task3_2;

import javafx.geometry.Point2D;

public class Square extends Quadrangle {	// квадрат

	public Square(Point2D leftTop, Point2D leftBottom, Point2D rightTop, Point2D rightBottom) {
		super(leftTop, leftBottom, rightTop, rightBottom);
	}

	public boolean isSquare() {	// проверка на квадрат
		return getWidth() == getHeight() && getFirstDiagonal() == getSecondDiagonal();
	}
}
