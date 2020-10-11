import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.TimerTask;
import java.util.Timer;

public class DictionaryApplication extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		DictionaryManagement dictionaryManagement = new DictionaryManagement();
		dictionaryManagement.insertFromFile();
		primaryStage.setTitle("Hello World!");
		TextField word_input = new TextField();
		word_input.setLayoutX(20);
		word_input.setLayoutY(20);

		Timer timer = new Timer();
		TimerTask task = new TimerTask()
		{
			public void run()
			{
				String str = word_input.getText();
				System.out.println(dictionaryManagement.dictionaryLookup(str));
			}
		};
		timer.scheduleAtFixedRate(task , 0,  1000);
		//timer.schedule(task , 3000);
		Pane root = new Pane();
		root.getChildren().add(word_input);
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
	}
}
