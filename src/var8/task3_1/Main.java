package var8.task3_1;

/*
Вариант №8
Прикладная область «Автостоянка».
Есть несколько категорий транспортных средств, программ должна рассчитывать арендную плату на автостоянке в зависимости
от типа транспортного средства. Типы транспортных средств: обычный автомобиль расчёт аренды ведётся в зависимости от
часов, сколько автомобиль стоит на стоянке; грузовой автомобиль, расчёт ведётся и с учётом часов и с учётом габаритов
грузовика; муниципальный транспорт, расчёт ведётся в зависимости от часов аренды с понижающим коэффициентом.
*/

public class Main {
	//Искуственно созданный кусок для демонстрации работы программы
	public static void main(String[] args) {
		Car car = new Car("Audi 8V"); //создание машин
		Autotruck autotruck = new Autotruck("KAMAZ 53504", 25, 40);
		MunicipalTransport municipalTransport = new MunicipalTransport("Ikarus-260");

		Parking parking = new Parking();//создание парковки

		double price;
		price = parking.calculateRent(car,33);					// вычисление платы для легковой машины
		System.out.println("For car " + car.getModel() + " rent is " + price);

		price = parking.calculateRent(autotruck,33);			// вычисление платы для грузовой машины
		System.out.println("For car " + autotruck.getModel() + " rent is " + price);

		price = parking.calculateRent(municipalTransport,33);	// вычисление платы для муниципального транспорта
		System.out.println("For car " + municipalTransport.getModel() + " rent is " + price);
	}
}
