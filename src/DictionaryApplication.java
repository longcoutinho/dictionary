import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
		primaryStage.setTitle("TU DIEN ANH VIET");
		TextField word_input = new TextField();
		word_input.setLayoutX(250);
		word_input.setLayoutY(100);
		Text word_output = new Text();
		word_output.setLayoutX(250);
		word_output.setLayoutY(200);
		/*
		Rectangle content = new Rectangle();
		content.setLayoutX(250);
		content.setLayoutY(100);
		content.setWidth(500);
		content.setHeight(400);
		content.setFill(Color.WHITE);
		*/
		ListView<String> word_list = new ListView<>();
		word_list.setLayoutX(20);
		word_list.setLayoutY(100);
		word_list.setMaxWidth(180);
		String str = word_input.getText();
		word_output.setText(dictionaryManagement.dictionaryAdvancedLookup(str));
		int value_left = dictionaryManagement.listOfAdvancedSearching(str).getKey();
		int value_right = dictionaryManagement.listOfAdvancedSearching(str).getValue();
		word_list.getItems().clear();
		for(int i = value_left - 1 ; i < value_right ; i++)
			word_list.getItems().add(dictionaryManagement.listofWords.get(i).getWord_target());
		//word_list.getItems().addAll(lstr);
		word_input.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				String str = word_input.getText();
				word_output.setText(dictionaryManagement.dictionaryAdvancedLookup(str));
				int value_left = dictionaryManagement.listOfAdvancedSearching(str).getKey();
				int value_right = dictionaryManagement.listOfAdvancedSearching(str).getValue();
				word_list.getItems().clear();
				for(int i = value_left - 1 ; i < value_right ; i++)
					word_list.getItems().add(dictionaryManagement.listofWords.get(i).getWord_target());
				//word_list.getItems().addAll(lstr);
			}
		});
		word_list.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				String nameitem = word_list.getSelectionModel().getSelectedItems().get(0);
				if (nameitem != null) {
					word_input.setText(nameitem);
					nameitem = nameitem.replace("\n", "");
					word_output.setText(dictionaryManagement.dictionaryAdvancedLookup(nameitem));
					//System.out.println(dictionaryManagement.dictionaryLookup(abcd));
					List<String> lstr1 = new ArrayList<>();
					lstr1.clear();
					lstr1 = dictionaryManagement.listOfSearching(nameitem);
					word_list.getItems().clear();
					for (int i = 0; i < lstr1.size(); i++)
						word_list.getItems().add(lstr1.get(i));
				}
			}
		});
		Pane root = new Pane();
		root.getChildren().addAll(word_input, word_output, word_list);
		Scene newScene = new Scene(root , 800 , 600);
		primaryStage.setScene(newScene);
		primaryStage.show();
		dictionaryManagement.dictionaryExportToFile();
	}
}

