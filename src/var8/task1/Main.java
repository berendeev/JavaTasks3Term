package var8.task1;

/*
	8. В тексте найти все пары слов, из которых одно является обращением другого.
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("input string: ");		// вывод сооющения в консоль
		Scanner scanner = new Scanner(System.in);	// сканнер необходим чтобы считывать с консоли

		Str str = new Str(scanner.nextLine());		// создаем обьект класса Str в ноструктор[Str(scanner.nextLine())] передаем строку, которую считали с консоли[scanner.nextLine()]

		str.findAndPrint();							// вызываем метод у обьекта
	}
}
