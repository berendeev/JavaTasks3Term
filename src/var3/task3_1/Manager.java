package var3.task3_1;

public class Manager extends Employee {

	double bonusPerSale;

	public Manager(double salary, double bonusPerSale) {
		this.salary = salary;
		this.bonusPerSale = bonusPerSale;
	}

	@Override
	double payroll(double saleCount) {
		return salary + saleCount * bonusPerSale;
	}
}
