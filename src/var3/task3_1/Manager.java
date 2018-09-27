package var3.task3_1;

public class Manager extends Employee {

	double bonusPerSale;	// премия за продажу

	public Manager(double salary, double bonusPerSale) {	// зп и премия за продажу
		this.salary = salary;
		this.bonusPerSale = bonusPerSale;
	}

	@Override
	double payroll(double saleCount) {
		return salary + saleCount * bonusPerSale;	// зп = зп + премия за продажу * кол-во продаж
	}
}
