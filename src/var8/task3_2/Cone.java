package var8.task3_2;

public class Cone extends Circle { // конус, наследник окружности

	private double h;	//высота

	public Cone(double radius, double h) { //конструктор с 2мя параметрами, радиус и высота
		super(radius);	// вызывается родительский конструктор с радиусом[ у Circle]
		this.h = h;	// сохраняем значения высоты[ключевое слово this необходимо для различия переменных, т.к. они имеют одинаковые названия.]
	}

	public double getVolume() {	// обьем
		return (getArea() * h) / 3;
	}

	@Override
	public double getArea() {	// переопределения функции подсчета площади
		double l = Math.sqrt(h * h + getR() * getR());
		return Math.PI * getR() * l;
	}

	@Override
	public void printInfo() { // переопределение функции вывода информации
		System.out.println("Radius is " + getR());
		System.out.println("Height is " + h);
		System.out.println("Area is " + getArea());
		System.out.println("Volume is " + getVolume());
	}
}
