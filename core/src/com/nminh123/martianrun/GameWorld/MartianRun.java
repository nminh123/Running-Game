package com.nminh123.martianrun.GameWorld;

import com.badlogic.gdx.Game;

public class MartianRun extends Game {
	@Override
	public void create() {
		setScreen(new GameScreen());
	}
}
