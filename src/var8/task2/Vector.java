package var8.task2;

import javafx.geometry.Point3D;

public class Vector {		// класс вектор
	private Point3D basis;	// ортогональные координаты вектора. 3 точки

	public Vector(Point3D basis) {	// конструктор, который принимает обьект класса Point3D, который хранит в себе 3 точки
		this.basis = basis;	// сохраняем то что было в аргументе, в переменую, котороя находится в этом классе
	}

	public double cosAlpha() {		// направляющие косинусы вектора
		return basis.getX() / norm();
	}

	public double cosBeta() {
		return basis.getY() / norm();
	}

	public double cosGamma() {
		return basis.getZ() / norm();
	}

	public double norm() {	//норма, модуль или длинна вектора
		return Math.sqrt(basis.getX() * basis.getX() + basis.getY() * basis.getY() + basis.getZ() * basis.getZ());
	}

	public Vector addition(Vector other) {	// сложение векторов, в качестве аргумента - другой обьект класса
		double i = basis.getX() + other.basis.getX(); // получаем новые координаты
		double j = basis.getY() + other.basis.getY();
		double k = basis.getZ() + other.basis.getZ();

		Point3D newBasis = new Point3D(i, j, k);	// сохдаем новый экхемпляр класса Point3D, для того чтобы передать его в качестве аргумента при создании нового вектора[см строку ниже]
		return new Vector(newBasis);	// вызываем конструктор класса Vector[это создает обьект, т.е. новый вектор с координатами, которые передавались в качестве аргумента] и возвращаем этот обьект[ссылку на него, еслу так понятней]
	}

	public double scalarMultiplication(Vector other) {	// скалярное произведение векторов
		return basis.getX() * other.basis.getX() + basis.getY() * other.basis.getY() + basis.getZ() * other.basis.getZ(); // результатом является число
	}

	public Vector vectorMultiplication(Vector other) {	// векторное произведение
		double i = basis.getY() * other.basis.getZ() - basis.getZ() * other.basis.getY();	//получаем координаты нового вектора
		double j = basis.getZ() * other.basis.getX() - basis.getX() * other.basis.getZ();
		double k = basis.getX() * other.basis.getY() - basis.getY() * other.basis.getX();

		Point3D newBasis = new Point3D(i, j, k);	// создаем экземпляр[обьект] класса Point3D
		return new Vector(newBasis);	// вызываем конструктор[создаем] обьект[экземпляр] класса Vector и возвращаем его
	}


	public void info() {	// выводит информацию о данном векторе
		System.out.println("###");
		System.out.println("Characteristic of vector");

		System.out.println("Basis of vector: (" + basis.getX() + ", " + basis.getY() + ", " + basis.getZ() + ")");

		System.out.println("Direction cosines of vector:");
		System.out.println("Alpha is " + cosAlpha());
		System.out.println("Beta is " + cosBeta());
		System.out.println("Gamma is " + cosGamma());
		System.out.println("###");
	}
}

