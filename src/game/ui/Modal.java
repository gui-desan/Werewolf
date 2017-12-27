package game.ui;

import game.ui.Alert.ButtonType;
import game.windows.GameScreen;
import game.windows.Settings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

abstract class Modal extends GameScreen {
	
	protected String text;
	protected ButtonType btnType;
	protected BorderPane root;

	public Modal() {
		super(Settings.MODAL_WIDTH, Settings.MODAL_HEIGHT);
	}
	
	@Override
	public void init() {
		root = new BorderPane();
		root.setPrefSize(getWidth(), getHeight());
		
		HBox center = new HBox();
		center.setAlignment(Pos.CENTER);
		center.setPadding(new Insets(10));
		
		Text text = new Text(this.text);
		text.setFont(Settings.MODAL_TEXT_FONT);
		text.setFill(Color.WHITE);
		
		center.getChildren().add(text);
		
		root.setCenter(center);
		
		addLayer("control");
		addChild("control", root);
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
