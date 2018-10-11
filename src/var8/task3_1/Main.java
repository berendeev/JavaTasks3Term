package var8.task3_1;

/*
Вариант №8
Прикладная область «Автостоянка».
Есть несколько категорий транспортных средств, программ должна рассчитывать арендную плату на автостоянке в зависимости
от типа транспортного средства. Типы транспортных средств: обычный автомобиль расчёт аренды ведётся в зависимости от
часов, сколько автомобиль стоит на стоянке; грузовой автомобиль, расчёт ведётся и с учётом часов и с учётом габаритов
грузовика; муниципальный транспорт, расчёт ведётся в зависимости от часов аренды с понижающим коэффициентом.
*/

import java.util.Random;
import java.util.Scanner;

public class Main {
	//Искуственно созданный кусок для демонстрации работы программы
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random r = new Random();
		while (true) {

			Car car = new Car("Audi 8V"); //создание машин
			Autotruck autotruck = new Autotruck("KAMAZ 53504", r.nextInt(40), r.nextInt(80));
			MunicipalTransport municipalTransport = new MunicipalTransport("Ikarus-260");

			Parking parking = new Parking();//создание парковки

			double price;
			int time = r.nextInt(1000);
			price = parking.calculateRent(car, time);                    // вычисление платы для легковой машины
			System.out.printf("For car %s rent is %.2fp ; Time : %d\n", car.getModel(), price, time); //s-string f-float d-int

			time = r.nextInt(1000);
			price = parking.calculateRent(autotruck, time);            // вычисление платы для грузовой машины
			System.out.printf("For car %s rent is %.2fp ; Time : %d\n", autotruck.getModel(), price, time);

			time = r.nextInt(1000);
			price = parking.calculateRent(municipalTransport, time);    // вычисление платы для муниципального транспорта
			System.out.printf("For car %s rent is %.2fp ; Time : %d\n", municipalTransport.getModel(), price, time);

			System.out.println("repeat?yes/no");
			if (scanner.nextLine().equals("no")) {
				return;
			}
		}
	}
}
