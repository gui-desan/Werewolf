package game.scene;

import game.ui.TextButton;
import game.windows.GameScreen;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public final class MainMenu extends GameScreen {

	@Override
	public void init() {
		setBackground("images/Werewolf_Background.jpg");
		addLayer("menu");
		VBox box = new VBox(20);
		box.setPadding(new Insets(40));
		box.setAlignment(Pos.BOTTOM_LEFT);
		box.setPrefHeight(getHeight());
		addChild("menu", box);
		TextButton newVillageBtn = new TextButton("New Village");
		newVillageBtn.setOnMouseReleased(e -> {
			if (newVillageBtn.isHover())
				setBackground("images/Village_Day.jpg");
		});
		TextButton findVillageBtn = new TextButton("Find Village");
		findVillageBtn.setOnMouseReleased(e -> {
			if (findVillageBtn.isHover())
				setBackground("images/Village_Night.jpg");
		});
		TextButton quitBtn = new TextButton("Quit");
		quitBtn.setFillColor(Color.RED, Color.WHITE);
		quitBtn.setOnMouseReleased(e -> {
			if (quitBtn.isHover())
				Platform.exit();
		});
		box.getChildren().addAll(newVillageBtn, findVillageBtn, quitBtn);
	}
}
