package var3.task3_1;

public class Engineer extends Employee {	// инженер, наследник сотрудника

	public Engineer(double salary) {
		this.salary = salary;
	}	// сохраняет зп

	@Override
	double payroll(double bonus) { // переопределение метода дря расчета зп
		return salary + bonus;	// зп = зп + премия
	}
}
