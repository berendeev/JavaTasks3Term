package var8.task3_1;

public class Autotruck extends Car {	//грузовой автомобиль, наследуется от Car

	private int width;		//помимо модели есть габариты, длинна высота
	private int height;

	public Autotruck(String model, int width, int height) {	// конструктор
		super(model);	// вызывается конструтор предка, т.е. вызывается котсруктор Car
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
