package var8.task3_1;

public class Parking {    // паркова

	private double pricePerTime;    // цена за 1 еденицу времени
	private double ratio;            // понижающий коэффициент для муниципального транспорта

	public Parking() {    // конструктор который инициализирует плату за ед. времени и понижающий коэф.
		pricePerTime = 10;
		ratio = 0.5;
	}

	public double calculateRent(Car car, double time) {    // расчет для обычной машины
		return time * pricePerTime;    //учитывет только время и цену
	}

	public double calculateRent(Autotruck autotruck, double time) {
		return time * pricePerTime + autotruck.getHeight() + autotruck.getWidth();    // учитывает время, цену и размер
	}

	public double calculateRent(MunicipalTransport municipalTransport, double time) {
		return time * pricePerTime * ratio; // учитывает время, цену и льготы
	}
}
