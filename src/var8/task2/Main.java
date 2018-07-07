package var8.task2;


import javafx.geometry.Point3D;

/*
	http://mathprofi.ru/vektory_dlya_chainikov.html
	http://ru.onlinemschool.com/math/library/vector/cos/
	https://en.wikipedia.org/wiki/Vector_space
 */
public class Main {
	public static void main(String[] args) {    // искуственно созданный кусок кода для примера
		Vector a = new Vector(new Point3D(2, 4, 6));    // создаем вектор а с координатами 2,4,6;
		Vector b = new Vector(new Point3D(3, 9, 81));    // создаем вектор b с координатами 3,9,81;

		Vector c = (a.addition(b)).vectorMultiplication(b);    // с = (a + b)* b
		c.info();	// для просмотра результата выполнения строки выше

		double f = a.scalarMultiplication(c);	// f = ac если я правильно понял, то это скалярное умножение
		System.out.println("f = " + f);		// вывод результата

	}
}
