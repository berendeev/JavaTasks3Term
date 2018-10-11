package var8.task3_2;
/*
  8)
  Создать класс окружность, член класса - R. Предусмотреть в классе методы вычисления и вывода сведений о
  фигуре – площади, длины окружности. Создать производный класс – конус с высотой h, добавить в класс метод
  определения объема фигуры, перегрузить методы расчета площади и вывода сведений о фигуре. Написать программу,
  демонстрирующую работу с классом: дано N окружностей и M конусов, найти количество окружностей, у которых
  площадь меньше средней площади всех окружностей, и наибольший по объему конус.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);    // сканнер для считывания с консоли
		while (true) {
			List<Circle> circles = new ArrayList<>(); //лист[или проще - список] для хранения окружностей
			List<Cone> cones = new ArrayList<>(); // лист для хранения конусов

			System.out.println("input count of circles");
			int N = scanner.nextInt();    //в N считывается из потока ввода кол-во окружностей

			for (int i = 0; i < N; i++) {    // цикл от 0 и до кол-во окрудностей
				System.out.println((i + 1) + " input radius");
				double radius = scanner.nextDouble();    // читаем радиус

				Circle circle = new Circle(radius);    // создаем новый обьект[новую окружность] с данным радиусом
				circles.add(circle); // кладем данный обьект[окружность] в список
			}

			System.out.println("input count of cones");    //тоже самое для конуса
			int M = scanner.nextInt();

			for (int i = 0; i < M; i++) {
				System.out.println((i + 1) + " input radius");
				double radius = scanner.nextDouble();

				System.out.println((i + 1) + " input h");
				double h = scanner.nextDouble();    //читаем высоту

				Cone cone = new Cone(radius, h);    // создаем обьект[конус] с радиусом и высотой
				cones.add(cone); // кладем в список
			}

			// для окружности
			double sumAreas = 0;    // тут будет сумма площядей всех окружностей[для нахождения средней]
			for (Circle circle : circles) {    // для каждой окружности в списке[берет одну окружность из списка, выполняет действия, потом берет следующую и так до конца]
				sumAreas += circle.getArea(); // суммируем площади
			}
			double averageArea = sumAreas / circles.size(); // считаем среднюю площадь

			int countLessAVG = 0;    // тут будет кол-во окр, у которых площадь < средней
			for (Circle circle : circles) {    // для каждой окр в списке
				if (circle.getArea() < averageArea) {    // если площадь < средней
					countLessAVG++;    // то увеличиваем кол-во на 1
				}
			}

			System.out.printf("Average area is %.2f\n", averageArea);    //вывод средней площади[\n-перенос строки]
			System.out.printf("count circles less average is %d\n", countLessAVG);    //вывод ко-ва < средней

			//для конуса
			// необходимо найти max по обьему, т.е. нужно сравнивать. Предпологаем что 1ый элемент в списке это конус с max обьемом
			Cone coneWithMaxVolume = cones.get(0); // достаем из списка 1ый элемент и записываем его в переменную coneWithMaxVolume
			for (Cone cone : cones) { //для каждого конуса в списке
				if (cone.getVolume() > coneWithMaxVolume.getVolume()) {    // если обьем текущего конуса > чем у того что находится в coneWithMaxVolume
					coneWithMaxVolume = cone;    // то значит это пока что наибольший по обьему конус и записываем его в coneWithMaxVolume
				}
			}

			System.out.println("Cone with max volume:");
			coneWithMaxVolume.printInfo();    //вывод информации о конусе с максимальным обьемом

			scanner.nextLine();
			System.out.println("repeat?yes/no");
			if (scanner.nextLine().equals("no")) {
				return;
			}
		}

	}

}