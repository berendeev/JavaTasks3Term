package var8.task4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.Stack;


/*
	8
	Задать два стека, поменять информацию местами. Отображать процесс вычислений по нажатию кнопки с помощью элементов
	Vertical List View.
 */


public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stack<TextField> first = new Stack<>();    // 1 стэк
		Stack<TextField> tempStack = new Stack<>();    // временный(3ий)
		Stack<TextField> second = new Stack<>(); // 2ой
//		for (int i = 0; i < 12; i++) {    // начальные значения
//			first.push(new TextField("A value 1-" + i));
//			second.push(new TextField("B value 2-" + i));
//		}

		HBox hBox = new HBox();

		ListView<TextField> firstListView = new ListView<>();
		firstListView.getItems().setAll(first);

		ListView<TextField> secondListView = new ListView<>();
		secondListView.getItems().setAll(second);

		ListView<TextField> tempListView = new ListView<>();
		tempListView.getItems().setAll(tempStack);

		hBox.getChildren().add(firstListView);
		hBox.getChildren().add(tempListView);
		hBox.getChildren().add(secondListView);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(hBox);

		Button button = new Button("click");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (tempStack.empty()) {    // если временный стэк пуст ( 1 нажатие)
					while (!first.empty()) {    // пока первый стэк не станет пустым
						tempStack.push(first.pop());    // перекладывает из первого стэка во временный; pop - получить верхгий(1ый) элемент и удалить из стэка, push затолкнуть в стэк
					}
				} else {    // если во временном стэке чтото есть (2ое нажатие)
					while (!second.empty()) {    // перекладывает в первый элементы из 2го
						first.push(second.pop());
					}
					Collections.reverse(first);    // переворачивает элементы в 1ом стэке

					while (!tempStack.empty()) {    // перекладывает из временного во 2ой
						second.push(tempStack.pop());
					}

				}
				update(firstListView, secondListView, tempListView, first, second, tempStack);
			}
		});

		Button addRowFirst = new Button("Add row to first list");
		addRowFirst.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				first.push(new TextField());
				update(firstListView, secondListView, tempListView, first, second, tempStack);
			}
		});

		Button addRowSecond = new Button("Add row to second list");
		addRowSecond.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				second.push(new TextField());
				update(firstListView, secondListView, tempListView, first, second, tempStack);
			}
		});

		HBox buttonsLayout = new HBox();
		buttonsLayout.getChildren().add(button);
		buttonsLayout.getChildren().add(addRowFirst);
		buttonsLayout.getChildren().add(addRowSecond);

		borderPane.setBottom(buttonsLayout);

		Label label = new Label("Задание 5\n" +
				"Задать два стека, поменять информацию местами. Отображать процесс вычислений по нажатию кнопки с помощью элементов\n" +
				"Vertical List View.");
		borderPane.setTop(label);

		Scene scene = new Scene(borderPane);

		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	static void update(ListView<TextField> firstListView, ListView<TextField> secondListView, ListView<TextField> tempListView,
					   Stack<TextField> first, Stack<TextField> second, Stack<TextField> tempStack){
		firstListView.getItems().setAll(first);    // обновляет данные в ListView
		tempListView.getItems().setAll(tempStack);
		secondListView.getItems().setAll(second);
	}
}
