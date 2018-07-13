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
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 0, 0, 0));

		TextField inputOne = new TextField("ab^3+a^3+2a^2-3");
		TextField inputTwo = new TextField("2ab^2+3a^3+1");
		JLabel output = new JLabel("");
		JButton button = new JButton("button");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String firstPolynomial = inputOne.getText();
				String secondPolynomial = inputTwo.getText();

				Map<String, Integer> firstParts = parse(firstPolynomial);
				Map<String, Integer> secondParts = parse(secondPolynomial);

				String result = "";

				for (String key : secondParts.keySet()) {
					if (firstParts.containsKey(key)) {
						firstParts.put(key, firstParts.get(key) + secondParts.get(key));
					} else {
						firstParts.put(key, secondParts.get(key));
					}
				}

				for (String key : firstParts.keySet()) {
					if (firstParts.get(key) > 0) {
						result += "+";
					}
					result += firstParts.get(key) + key;
				}

				output.setText(result);
			}
		});

		panel.add(inputOne);
		panel.add(inputTwo);
		panel.add(output);
		panel.add(button);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

	}

	public static Map<String, Integer> parse(String string) {
		string = string.replaceAll("-", "+-");
		String[] members = string.split("\\+");

		Map<String, Integer> membersParts = new HashMap<>();

		Pattern pattern = Pattern.compile("^[-]?[0-9]+");
		for (int i = 0; i < members.length; i++) {
			int coefficient;
			Matcher matcher = pattern.matcher(members[i]);

			if (matcher.find()) {
				String temp = matcher.group();
				members[i] = members[i].replaceFirst(temp, "");
				coefficient = Integer.parseInt(temp);

			} else if (members[i].charAt(0) == '-') {
				coefficient = -1;
			} else {
				coefficient = 1;
			}

			membersParts.put(members[i], coefficient);
		}
		return membersParts;
	}
}

