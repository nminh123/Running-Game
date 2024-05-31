package com.nminh123.martianrun.GameWorld;

import com.badlogic.gdx.Game;
import com.nminh123.martianrun.utils.AssetsManager;
import com.nminh123.martianrun.utils.GameEventListener;
import com.nminh123.martianrun.utils.GameManager;

public class MartianRun extends Game {

	private final GameEventListener gameEventListener;

	public MartianRun(GameEventListener gameEventListener) {
		GameManager.getInstance().setGameEventListener(gameEventListener);
		this.gameEventListener = gameEventListener;
	}
	@Override
	public void create() {
		AssetsManager.loadAssets();
		setScreen(new GameScreen());
	}
}
