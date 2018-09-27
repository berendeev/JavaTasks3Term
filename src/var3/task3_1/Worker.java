package var3.task3_1;

public class Worker extends Employee {
	private double generalHours;	// основные часы работы

	public Worker(double salaryPerHour, double generalHours) {	// за в час и план кол-во часов
		salary = salaryPerHour;
		this.generalHours = generalHours;
	}

	@Override
	double payroll(double hours) {	// hours часы которые отработал
		if (hours > generalHours) {	// если отработал больше чем нужно
			return (hours - generalHours) * salary * 2 + generalHours * salary;	// зп = переработанные часы * двойной тариф + общее кол-во часов * зп в час
		} else {
			return hours * salary; // инача зп = отработанные часы * зп в час
		}
	}
}
