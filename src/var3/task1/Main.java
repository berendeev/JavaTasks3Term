package var3.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
	Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше средней, также их длины.
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("input amount of string");    // Приглашение на ввод
		Scanner scanner = new Scanner(System.in);    // для считывания с консоли
		int count;
		try {		// в блоке try помещается код, который может выкинуть exception. Тут это если передать вместо числа строку(ее нельзя записать в int)
			count = scanner.nextInt();    // читаем кол-во строк
			scanner.nextLine(); // nextInt не пихает в поток символ конца строки, поэтому nextLine не ждет ввода. Это строка - фикс. https://stackoverflow.com/questions/23450524/java-scanner-doesnt-wait-for-user-input
		} catch (InputMismatchException e){	// если ошибка произошла, будет выполнен код в catch
			System.out.println("Not a number.");	// вывод сообщения об ошибке
			return;		// завершение работы программы
		}

		Str str = new Str();    // создаем класс

		for (int i = 0; i < count; i++) {    // для всех строк введенных с клавиатуры
			System.out.println("input " + (i + 1) + " string");    // вывод номер строки
			str.add(scanner.nextLine());    // добавляем строку в обьект класса
		}

		str.print();    // вызывает метод принт
	}
}
