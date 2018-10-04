package var3.task3_1;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DecimalFormat f = new DecimalFormat("0.00");
		Random r = new Random();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("==================");

			int startEngineerSalary = r.nextInt(100000);
			Engineer engineer = new Engineer(startEngineerSalary);

			int startWorkerSalaryPerHour = r.nextInt(1000);
			int startWorkerGeneralHour = r.nextInt(100);
			Worker worker = new Worker(startWorkerSalaryPerHour, startWorkerGeneralHour);

			int startManagerSalary = r.nextInt(50000);
			int startManagerBonusPerSale = r.nextInt(1000);
			Manager manager = new Manager(startManagerSalary, startManagerBonusPerSale);

			int inputEngineerBonus = r.nextInt(10000);
			double engineerSalary = engineer.payroll(inputEngineerBonus);

			int inputWorkerHour = r.nextInt(100);
			double workerSalary = worker.payroll(51);

			int inputManagerSales = r.nextInt(20);
			double managerSalary = manager.payroll(4);

			System.out.println("Salary for engineer with bonus " + f.format(inputEngineerBonus) + " is " + f.format(engineerSalary) + " р.");
			System.out.println("Salary for worker is " + f.format(workerSalary) + " р.");
			System.out.println("Salary for manager with " + inputManagerSales + " sales is " + f.format(managerSalary) + " р.");

			System.out.println("repeat?yes/no");
			if (scanner.nextLine().equals("no")) {
				return;
			}
		}
	}
}
