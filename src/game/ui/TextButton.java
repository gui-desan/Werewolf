package game.ui;

import game.windows.Settings;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public final class TextButton extends Text {

	private Color enterFill, exitFill;
	
	public TextButton(String text) {
		super(text);
		setFont(Settings.TEXT_BUTTON_FONT);
		setFillColor(Color.WHITE);
		setFill(exitFill);
		setEvent();
	}
	
	public void setFillColor(Color fill) {
		enterFill = fill;
		exitFill = fill;
	}
	
	public void setFillColor(Color enterFill, Color exitFill) {
		this.enterFill = enterFill;
		this.exitFill = exitFill;
	}
	
	private void setEvent() {
		setOnMouseEntered(e -> {
			if (isPressed())
				setEffect(new Glow(0.5));
			else
				setEffect(new Glow(1));
			setFill(enterFill);
		});
		
		setOnMouseExited(e -> {
			setEffect(null);
			setFill(exitFill);
		});
		
		setOnMousePressed(e -> {
			setEffect(new Glow(0.5));
		});
		
		setOnMouseReleased(e -> {
			if (isHover())
				setEffect(new Glow(1));
		});
	}
}
