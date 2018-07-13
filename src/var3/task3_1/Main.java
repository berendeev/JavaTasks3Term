package var3.task3_1;

public class Main {
	public static void main(String[] args) {
		Engineer engineer = new Engineer(40000);
		Worker worker = new Worker(210, 48);
		Manager manager = new Manager(15000, 300);

		double engineerSalary = engineer.payroll(2500);
		double workerSalary = worker.payroll(51);
		double managerSalary = manager.payroll(4);

		System.out.println("Salary for engineer with bonus 2500 is " + engineerSalary);
		System.out.println("Salary for worker with 3 extra hours is " + workerSalary);
		System.out.println("Salary for manager with 4 sales is " + managerSalary);
	}
}
