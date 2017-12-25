package game.windows;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SceneManager {

	private static Stage primaryStage;

	public static void initialize(Stage stage) {
		primaryStage = stage;
	}

	public static void gotoScene(Parent root) {
		primaryStage.setScene(new Scene(root, Setting.SCENE_WIDTH, Setting.SCENE_HEIGHT, Color.BLACK));
	}
}
