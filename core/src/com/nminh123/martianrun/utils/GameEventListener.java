package com.nminh123.martianrun.utils;

public interface GameEventListener {

    public void displayAd();
    public void hideAd();
    public void submitScore(int score);
    public void displayLeaderboard();
    public void displayAchievements();
    public void share();
    public void unlockAchievement(String id);
    public void incrementAchievement(String id, int steps);
    public String getGettingStartedAchievementId();
    public String getLikeARoverAchievementId();
    public String getSpiritAchievementId();
    public String getCuriosityAchievementId();
    public String get5kClubAchievementId();
    public String get10kClubAchievementId();
    public String get25kClubAchievementId();
    public String get50kClubAchievementId();
    public String get10JumpStreetAchievementId();
    public String get100JumpStreetAchievementId();
    public String get500JumpStreetAchievementId();
}