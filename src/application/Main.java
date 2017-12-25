package application;

import game.windows.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		SceneManager.initialize(primaryStage);
		//SceneManager.gotoScene(new MainMenu());
		primaryStage.show();
		primaryStage.setTitle("Werewolf");
		primaryStage.centerOnScreen();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
