package com.nminh123.martianrun;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.nminh123.martianrun.MartianRun;
import com.nminh123.martianrun.utils.Constants;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(Constants.APP_WIDTH,Constants.APP_HEIGHT);
		config.setForegroundFPS(60);
		config.setTitle("Martian Run");
		new Lwjgl3Application(new MartianRun(), config);
	}
}
