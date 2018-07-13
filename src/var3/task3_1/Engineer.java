package var3.task3_1;

public class Engineer extends Employee {

	public Engineer(double salary) {
		this.salary = salary;
	}

	@Override
	double payroll(double bonus) {
		return salary + bonus;
	}
}
