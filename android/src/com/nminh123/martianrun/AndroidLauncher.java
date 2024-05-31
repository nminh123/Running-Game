package com.nminh123.martianrun;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.Gdx;
import com.nminh123.martianrun.GameWorld.MartianRun;
import com.nminh123.martianrun.utils.GameEventListener;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MartianRun(new GameEventListener() {
			@Override
			public void displayAd() {
				Gdx.app.log(GameEventListener.class.getSimpleName(), "displayAd");
			}

			@Override
			public void hideAd() {
				Gdx.app.log(GameEventListener.class.getSimpleName(), "hideAd");
			}

			@Override
			public void submitScore(int score) {
				Gdx.app.log(GameEventListener.class.getSimpleName(), "submitScore");
			}

			@Override
			public void displayLeaderboard() {
				Gdx.app.log(GameEventListener.class.getSimpleName(), "displayLeaderboard");
			}

			@Override
			public void displayAchievements() {
				Gdx.app.log(GameEventListener.class.getSimpleName(), "displayAchievements");
			}

			@Override
			public void share() {
				Gdx.app.log(GameEventListener.class.getSimpleName(), "share");
			}

			@Override
			public void unlockAchievement(String id) {
				Gdx.app.log(GameEventListener.class.getSimpleName(), "unlockAchievement: " + id);
			}

			@Override
			public void incrementAchievement(String id, int steps) {
				Gdx.app.log(GameEventListener.class.getSimpleName(), "incrementAchievement: " + id + ", steps: " + steps);
			}

			@Override
			public String getGettingStartedAchievementId() {
				return "achievement_getting_started";
			}

			@Override
			public String getLikeARoverAchievementId() {
				return "achievement_like_a_rover";
			}

			@Override
			public String getSpiritAchievementId() {
				return "achievement_spirit";
			}

			@Override
			public String getCuriosityAchievementId() {
				return "achievement_curiosity";
			}

			@Override
			public String get5kClubAchievementId() {
				return "achievement_5k_club";
			}

			@Override
			public String get10kClubAchievementId() {
				return "achievement_10k_club";
			}

			@Override
			public String get25kClubAchievementId() {
				return "achievement_25k_club";
			}

			@Override
			public String get50kClubAchievementId() {
				return "achievement_50k_club";
			}

			@Override
			public String get10JumpStreetAchievementId() {
				return "achievement_10_jump_street";
			}

			@Override
			public String get100JumpStreetAchievementId() {
				return "achievement_100_jump_street";
			}

			@Override
			public String get500JumpStreetAchievementId() {
				return "achievement_500_jump_street";
			}
		}), config);
	}
}
