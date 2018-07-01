package var8.task3_1;

public class Car {				// обычная легковая машина
	private String model;		// добавил модель чтобы класс не был пустой)

	public Car(String model){	// Конструктор, который запоминает модель
		this.model = model;		// копирование значения модели из аргумента в переменную
	}

	public String getModel() {	// геттер для модели[просто для получения значения модели]
		return model;
	}
}
