package var2.task1;

import java.util.Scanner;

/*
	Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше средней, также их длины.
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("input amount of string");
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();

		Str str = new Str();

		for (int i = 0; i < count; i++) {
			System.out.println("input " + (i + 1) + " string");
			str.add(scanner.next());
		}

		str.print();
	}
}
