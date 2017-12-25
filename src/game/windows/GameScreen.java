package game.windows;

import java.util.HashMap;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public abstract class GameScreen extends StackPane {

	protected HashMap<String, Layer> layers;
	private GameScreen parent;

	public GameScreen() {
		this(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
	}

	public GameScreen(double width, double height) {
		layers = new HashMap<>();
		resize(width, height);
		parent = this;
	}
	
	protected void setBackground(String filename) {
			addLayer("background");
			Image background = new Image(ClassLoader.getSystemResource(filename).toString());
	//		drawLayer("background", gc -> {
	//			gc.drawImage(background, 0, 0, getWidth(), getHeight());
	//		});
		}

	protected void addLayer(String layerName) {
		layers.put(layerName, new Layer());
		getChildren().add(layers.get(layerName));
	}
	
	protected void removeLayer(String layerName) {
		getChildren().remove(layers.get(layerName));
		layers.remove(layerName);
	}

	protected void showLayer(String layerName) {
		layers.get(layerName).setVisible(true);
	}
	
	protected void hideLayer(String layerName) {
		layers.get(layerName).setVisible(false);
	}
	
	protected void sendLayerToFront(String layerName) {
		layers.get(layerName).toFront();
	}
	
	protected void sendLayerToBack(String layerName) {
		layers.get(layerName).toBack();
	}
	
	protected void addChild(String layerName, Node child) {
		layers.get(layerName).add(child);
	}
	
	protected void removeChild(String layerName, Node child) {
		layers.get(layerName).remove(child);
	}

//	protected void drawLayer(String layerName, Drawer drawer) {
//		layers.get(layerName).draw(drawer);
//	}
	
	protected double getCenterX() {
		return (Settings.SCENE_WIDTH - getWidth()) / 2;
	}
	
	protected double getCenterY() {
		return (Settings.SCENE_HEIGHT - getHeight()) / 2;
	}
	
	protected void centerOnScreen() {
		relocate(getCenterX(), getCenterY());
	}

	private class Layer extends StackPane {

		private Canvas canvas;
		private Pane overlay;
		private GraphicsContext gc;

		public Layer() {
			resize(parent.getWidth(), parent.getHeight());
			overlay = new Pane();
			canvas = new Canvas(getWidth(), getHeight());
			gc = canvas.getGraphicsContext2D();
			getChildren().addAll(canvas, overlay);
		}

		public void add(Node child) {
			overlay.getChildren().add(child);
		}

		public void remove(Node child) {
			overlay.getChildren().remove(child);
		}

//		public void draw(Drawer drawer) {
//			drawer.draw(gc);
//		}
	}
}
