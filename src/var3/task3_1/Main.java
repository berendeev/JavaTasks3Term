package var3.task3_1;

import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) {
		DecimalFormat f = new DecimalFormat("0.00");

		Engineer engineer = new Engineer(40000); // создание инженера с зарплатой 40000
		Worker worker = new Worker(210, 48); // рабочий с зп в час 210, 48 - базовые часы работы
		Manager manager = new Manager(15000, 300); // мэнэджер

		double engineerSalary = engineer.payroll(2500);    // расчет зп инженера с бонусом в 2500
		double workerSalary = worker.payroll(51);        // рабочий, который отработал 51 час
		double managerSalary = manager.payroll(4); // мэнэджер, который продал 4 товара

		System.out.println("Salary for engineer with bonus 2500 is " + f.format(engineerSalary) + " р.");
		System.out.println("Salary for worker with 3 extra hours is " + f.format(workerSalary) + " р.");
		System.out.println("Salary for manager with 4 sales is " + f.format(managerSalary) + " р.");
	}
}
