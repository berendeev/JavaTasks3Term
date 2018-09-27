package var3.task1;

import java.util.ArrayList;
import java.util.List;

public class Str {
	private List<String> list;	// список строк
	private double average;		// средняя длинна

	public Str() {	// конструктор
		list = new ArrayList<>();	// создаем пустой лист
		average = 0;	// начальное значение средней длинны 0
	}

	public void add(String string) {	// метод для добавления новых строк
		list.add(string);	// добавляет в лист новую строку
		calculateAverage();	// т.к. добавилась новая строка вызывается метод для пересчета средней длинны
	}

	private void calculateAverage() {	// считает среднюю длину
		int commonLength = 0; // общая длинна всех строк
		for (String s : list) {	// для каждой строки в списке
			commonLength += s.length();	// сумма длинн строк
		}
		average = ((double) commonLength) / list.size();	// средняя длянна = общая длинна всех строк / на кол-во строк
	}

	public void print(){	// метод вывода информации
		System.out.println("Average: " + average);	// вывод средней длины
		for (String s : list) {		// для каждой строки
			if (s.length() < average){	// если длина строки меньше средней
				System.out.println(s + "\nLength: " + s.length());	// вывод строки и ее длины
			}
		}
	}
}
