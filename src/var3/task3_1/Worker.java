package var3.task3_1;

public class Worker extends Employee {
	private double generalHours;

	public Worker(double salaryPerHour, double generalHours) {
		salary = salaryPerHour;
		this.generalHours = generalHours;
	}

	@Override
	double payroll(double hours) {
		if (hours > generalHours) {
			return (hours - generalHours) * salary * 2 + generalHours * salary;
		} else {
			return hours * salary;
		}
	}
}
