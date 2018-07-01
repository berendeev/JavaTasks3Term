package var8.task3_2;

public class Circle { //окружность

	private double R;	//радиус

	public Circle(double radius) {	//конструктор с 1 аргумментом
		R = radius;	//сохранение значения радиуса
	}

	public double getArea() {	// вычисление площади
		return Math.PI * R * R;
	}

	public double getCircumference() {	// длнина окр
		return 2 * Math.PI * R;
	}

	public double getR() {	//геттер для радиуса
		return R;
	}

	public void printInfo() {	// вывод информации о окр
		System.out.println("Radius is " + R);
		System.out.println("Area is " + getArea());
		System.out.println("Circumference is " + getCircumference());
	}
}
