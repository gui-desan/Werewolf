package game.ui;

import game.windows.Settings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public final class Alert extends Modal {

	private AlertType alertType;

	public Alert(AlertType alertType, String text) {
		this.alertType = alertType;
		this.text = text;
	}

	@Override
	public void init() {
		super.init();

		BorderPane root = new BorderPane();
		root.setPrefSize(getWidth(), getHeight());

		HBox center = new HBox();
		center.setAlignment(Pos.CENTER);
		center.setPadding(new Insets(10));

		Text text = new Text(this.text);
		text.setFont(Settings.MODAL_TEXT_FONT);
		text.setFill(Color.WHITE);

		center.getChildren().add(text);

		root.setCenter(center);

		HBox bottom = new HBox();
		bottom.setAlignment(Pos.CENTER);
		bottom.setPadding(new Insets(0, 10, 20, 10));

		switch (alertType) {
		case OK:
			TextButton OKBtn = new TextButton("OK");
			bottom.getChildren().add(OKBtn);
			break;

		case YES_NO:
			bottom.setSpacing(50);
			TextButton YesBtn = new TextButton("Yes");
			TextButton NoBtn = new TextButton("No");
			bottom.getChildren().addAll(YesBtn, NoBtn);
			break;

		default:
			break;
		}

		root.setBottom(bottom);

		addLayer("control");
		addChild("control", root);
	}

	public enum AlertType {
		OK, YES_NO
	}
}
