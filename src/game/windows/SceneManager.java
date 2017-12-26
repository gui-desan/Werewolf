package game.windows;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class SceneManager {

	private static Stage primaryStage;

	public static void initialize(Stage stage) {
		primaryStage = stage;
	}

	public static void gotoScene(GameScreen root) {
		primaryStage.setScene(new Scene(root, root.getWidth(), root.getHeight(), Color.BLACK));
		root.init();
	}
	
	public static double getX() {
		return primaryStage.getX();
	}
	
	public static double getY() {
		return primaryStage.getY();
	}
	
	public static double getWidth() {
		return primaryStage.getWidth();
	}
	
	public static double getHeight() {
		return primaryStage.getHeight();
	}
}
