import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
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
		primaryStage.setTitle("DICTIONARY");
		TextField word_input = new TextField();
		word_input.setLayoutX(20);
		word_input.setLayoutY(20);
		Text word_output = new Text();
		word_output.setLayoutX(500);
		word_output.setLayoutY(35);
		ListView<String> word_list = new ListView<>();
		word_list.setLayoutX(20);
		word_list.setLayoutY(100);
		Timer timer = new Timer();
		String str = word_input.getText();
		word_output.setText(dictionaryManagement.dictionaryLookup(str));
		List<String> lstr = new ArrayList<>();
		lstr.clear();
		lstr = dictionaryManagement.listOfSearching(str);
		word_list.getItems().clear();
		for(int i = 0 ; i < lstr.size() ; i++)
			word_list.getItems().add(lstr.get(i));
		//word_list.getItems().addAll(lstr);
		word_input.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				String str = word_input.getText();
				word_output.setText(dictionaryManagement.dictionaryLookup(str));
				List<String> lstr = new ArrayList<>();
				lstr.clear();
				lstr = dictionaryManagement.listOfSearching(str);
				word_list.getItems().clear();
				for(int i = 0 ; i < lstr.size() ; i++)
					word_list.getItems().add(lstr.get(i));
				//word_list.getItems().addAll(lstr);
			}
		});
		Pane root = new Pane();
		root.getChildren().add(word_input);
		root.getChildren().add(word_output);
		root.getChildren().add(word_list);
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
	}


}

