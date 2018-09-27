package var3.task1;

import java.util.Scanner;

/*
	Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше средней, также их длины.
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("input amount of string");	// Приглашение на ввод
		Scanner scanner = new Scanner(System.in);	// для считывания с консоли
		int count = scanner.nextInt();	// читаем кол-во строк

		Str str = new Str();	// создаем класс

		for (int i = 0; i < count; i++) {	// для всех строк введенных с клавиатуры
			System.out.println("input " + (i + 1) + " string");	// вывод номер строки
			str.add(scanner.next());	// добавляем строку в обьект класса
		}

		str.print();	// вызывает метод принт
	}
}
