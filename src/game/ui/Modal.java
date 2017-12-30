package game.ui;

import game.windows.GameScreen;
import game.windows.Settings;
import javafx.scene.paint.Color;

abstract class Modal extends GameScreen {
	
	protected String text;

	public Modal() {
		super(Settings.MODAL_WIDTH, Settings.MODAL_HEIGHT);
	}
	
	@Override
	public void init() {
		addLayer("background");
		draw("background", gc -> {
			gc.setFill(Color.rgb(0, 0, 0, 0.75));
			gc.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
		});
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
