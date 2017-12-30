package game.windows;

import javafx.scene.Scene;
import javafx.stage.Stage;

public final class SceneManager {

	private static Stage primaryStage;

	public static void initialize(Stage stage) {
		primaryStage = stage;
	}

	public static void gotoScene(GameScreen root) {
		primaryStage.setScene(new Scene(root, root.getWidth(), root.getHeight()));
		root.init();
	}
}
