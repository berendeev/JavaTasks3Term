package var8.task4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stack<String> first = new Stack<>();
		first.addAll(Arrays.asList("a", "b", "c", "d"));

		Stack<String> second = new Stack<>();
		second.addAll(Arrays.asList("e", "f", "g", "h"));

		HBox hBox = new HBox();

		ListView<String> firstListView = new ListView<>();
		firstListView.getItems().setAll(first);

		ListView<String> secondListView = new ListView<>();
		secondListView.getItems().setAll(second);

		hBox.getChildren().add(firstListView);
		hBox.getChildren().add(secondListView);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(hBox);

		Button button = new Button("click");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				List<String> temp = new ArrayList<>();
				temp.addAll(firstListView.getItems());
				firstListView.getItems().setAll(secondListView.getItems());

				secondListView.getItems().setAll(temp);
			}
		});

		borderPane.setBottom(button);

		Scene scene = new Scene(borderPane, 200, 200);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
