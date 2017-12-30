package application;

import game.scene.MainMenu;
import game.ui.Alert;
import game.ui.Alert.AlertType;
import game.ui.Dialog;
import game.ui.Dialog.DialogType;
import game.windows.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		SceneManager.initialize(primaryStage);
		//SceneManager.gotoScene(new Alert(AlertType.YES_NO, "test"));
		SceneManager.gotoScene(new Dialog(DialogType.FIND, "Enter IP"));
		//SceneManager.gotoScene(new MainMenu());
		primaryStage.setTitle("Werewolf");
		primaryStage.centerOnScreen();
		primaryStage.setResizable(false);
		primaryStage.sizeToScene();
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
