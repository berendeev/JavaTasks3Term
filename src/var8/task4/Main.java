package var8.task4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/*
	8
	Задать два стека, поменять информацию местами. Отображать процесс вычислений по нажатию кнопки с помощью элементов
	Vertical List View.
 */

// java fx
public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}	// запускает метод в классе Application. подробнее гуглите javafx

	@Override
	public void start(Stage primaryStage) throws Exception {	// основной метод
		Stack<String> first = new Stack<>();	// обьявление и инициализация первого стека
		first.addAll(Arrays.asList("a", "b", "c", "d"));	// добавление в стэк элементов

		Stack<String> second = new Stack<>();		// второй стэк
		second.addAll(Arrays.asList("e", "f", "g", "h"));

		HBox hBox = new HBox();		// HBox позволяет размещать элементы внутри себя горизонтально

		ListView<String> firstListView = new ListView<>();	// 1ый Vertical ListView
		firstListView.getItems().setAll(first);		// добовляем все элементы из первого стэка

		ListView<String> secondListView = new ListView<>();	// 2ой
		secondListView.getItems().setAll(second);

		hBox.getChildren().add(firstListView);	// добавляем листы внутрь HBox
		hBox.getChildren().add(secondListView);

		BorderPane borderPane = new BorderPane();	// Необходим для размещения, так же как и HBox, но отличается способом рахмещения
		borderPane.setCenter(hBox); // добавления HBox[и все что внутри него] в центр BorderPane

		Button button = new Button("click");	// создание кнопки
		button.setOnAction(new EventHandler<ActionEvent>() {	// вешаем слушателя на кнопку, метод handle будет срабатывать при нажатии на кнопку
			@Override
			public void handle(ActionEvent event) {
				List<String> temp = new ArrayList<>();	// создается новый лист для временного хранения данных
				temp.addAll(firstListView.getItems());	// копирует элементы из первого ListView
				firstListView.getItems().setAll(secondListView.getItems());	// изменение элементов первого ListView на элементы из второго

				secondListView.getItems().setAll(temp);	// во 2ой записываются элементы из temp[т.е. то, что было в первом ListView]
			}
		});

		borderPane.setBottom(button);	// добавляем кнопку вниз
		Label label = new Label("TEXT HERE!TEXT HERE!TEXT HERE!TEXT HERE!TEXT HERE!");
		borderPane.setTop(label);

		Scene scene = new Scene(borderPane, 200, 200);	// создание и инициализация сцены. Сцена это рабочая область окна

		primaryStage.setScene(scene);	// устанавливается рабочая область в окне
		primaryStage.show();	// показать окно
	}
}
