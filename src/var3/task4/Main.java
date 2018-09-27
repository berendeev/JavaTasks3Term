package var3.task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame(); // создание окна
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // завершение при закритии

		JPanel panel = new JPanel();	// контейнер
		panel.setLayout(new GridLayout(4, 0, 0, 0));	// разметка

		TextField inputOne = new TextField("ab^3+a^3+2a^2-3");	// 1 текстовое коле
		TextField inputTwo = new TextField("2ab^2+3a^3+1");		// 2 текстовое поле
		JLabel output = new JLabel("");		// для вывода результата
		JButton button = new JButton("button");

		button.addActionListener(new ActionListener() { // сработает при нажатии на кнопку
			@Override
			public void actionPerformed(ActionEvent e) {
				String firstPolynomial = inputOne.getText();	// 1 выражение
				String secondPolynomial = inputTwo.getText();	// 2 выражение

				Map<String, Integer> firstParts = parse(firstPolynomial); // разделяет строку на выражения и коэффициенты перед ним
				Map<String, Integer> secondParts = parse(secondPolynomial);

				String result = "";

				for (String key : secondParts.keySet()) {	// для всех ключей(выражение) в secondParts
					if (firstParts.containsKey(key)) { // если такой ключь(выражение) есть в  firstParts
						firstParts.put(key, firstParts.get(key) + secondParts.get(key)); // складываем коэф. (подобные)
					} else { // если нет
						firstParts.put(key, secondParts.get(key)); // кладем выражение и коэф.
					}
				}

				for (String key : firstParts.keySet()) {	// для всех ключей в firstParts
					if (firstParts.get(key) > 0) {	// если коэф. для этого ключа положытельный
						result += "+";	// добавляем + в строку результата (т.к. > 0 то + не пишится, а он нужен)
					}
					result += firstParts.get(key) + key; // приклеиваем коэф. и выражение к строке
				}

				output.setText(result);	//вывод результата
			}
		});

		panel.add(inputOne);	// добавление на окно
		panel.add(inputTwo);
		panel.add(output);
		panel.add(button);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

	}

	public static Map<String, Integer> parse(String string) {
		string = string.replaceAll("-", "+-");		// заменяет все - на +- для обработки
		String[] members = string.split("\\+");	// делит строку на подстроки по +

		Map<String, Integer> membersParts = new HashMap<>(); // массив ключ - значение

		Pattern pattern = Pattern.compile("^[-]?[0-9]+");	// регулярное выражение, шаблон лучше погугли
		for (int i = 0; i < members.length; i++) {	// для каждого выражения
			int coefficient;
			Matcher matcher = pattern.matcher(members[i]);		// использет шаблон для iго выражения

			if (matcher.find()) {	// если есть коэффициент перед выражением
				String temp = matcher.group(); // получает коэффициент
				members[i] = members[i].replaceFirst(temp, "");	// удаляет коэф. из выражения
				coefficient = Integer.parseInt(temp);	// приводит коэф. к числу

			} else if (members[i].charAt(0) == '-') {	// если коэф. пепед выражением нет и оно начинается с -
				coefficient = -1;	// то коэф. будет -1
			} else {
				coefficient = 1; // если его просто нет то коэф. будет 1
			}

			membersParts.put(members[i], coefficient); // добавляем выражения и коэф. в мэп
		}
		return membersParts;
	}
}

