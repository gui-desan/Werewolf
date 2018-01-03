package game.ui;

import game.windows.GameScreen;
import game.windows.Settings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Dialog extends Modal {

	protected DialogType dialogType;

	public Dialog(DialogType dialogType, String text) {
		this.dialogType = dialogType;
		this.text = text;
	}

	@Override
	public void init() {
		super.init();

		BorderPane root = new BorderPane();
		root.setPrefSize(getWidth(), getHeight());

		VBox center = new VBox(30);
		center.setAlignment(Pos.CENTER);
		center.setPadding(new Insets(0));

		Text text = new Text(this.text);
		text.setFont(Settings.MODAL_TEXT_FONT);
		text.setFill(Color.WHITE);

		InputField input = new InputField();

		center.getChildren().addAll(text, input);

		root.setCenter(center);

		HBox bottom = new HBox();
		bottom.setSpacing(50);
		bottom.setAlignment(Pos.CENTER);
		bottom.setPadding(new Insets(0, 10, 20, 10));

		switch (dialogType) {
		case FIND:
			TextButton FindBtn = new TextButton("Find");
			bottom.getChildren().add(FindBtn);
			break;

		case RENAME:
			bottom.setSpacing(50);
			TextButton YesBtn = new TextButton("Yes");
			TextButton NoBtn = new TextButton("No");
			bottom.getChildren().addAll(YesBtn, NoBtn);
			break;

		default:
			break;
		}

		TextButton CancelBtn = new TextButton("Cancel");

		bottom.getChildren().add(CancelBtn);

		root.setBottom(bottom);

		addLayer("control");
		addChild("control", root);
	}

	public enum DialogType {
		FIND, RENAME
	}

	private class InputField extends GameScreen {

		private TextField input;

		public InputField() {
			super(400, 40);
			init();
		}

		@Override
		public void init() {
			addLayer("back");

			HBox root;

			root = new HBox();
			root.setPadding(new Insets(10));
			root.setPrefSize(getWidth(), getHeight());
			root.setAlignment(Pos.CENTER);

			input = new TextField();
			input.setFocusTraversable(true);
			input.requestFocus();
			input.setOpacity(0);
			input.textProperty().addListener((obj, oldVal, newVal) -> {
				draw("front", gc -> {
					gc.clearRect(0, 0, getWidth(), getHeight());
					gc.setFill(Color.WHITE);
					gc.fillRoundRect(50, 0, gc.getCanvas().getWidth() - 100, gc.getCanvas().getHeight(), 20, 20);
					gc.setFill(Color.BLACK);
					gc.setFont(Settings.MODAL_TEXT_FONT);
					gc.setTextAlign(TextAlignment.CENTER);
					gc.setTextBaseline(VPos.CENTER);
					gc.fillText(input.getText(), gc.getCanvas().getWidth() / 2, gc.getCanvas().getHeight() / 2);
				});
			});

			root.getChildren().add(input);

			addChild("back", root);

			addLayer("front");

			draw("front", gc -> {
				gc.setFill(Color.WHITE);
				gc.fillRoundRect(50, 0, gc.getCanvas().getWidth() - 100, gc.getCanvas().getHeight(), 20, 20);
			});
		}

	}
}
