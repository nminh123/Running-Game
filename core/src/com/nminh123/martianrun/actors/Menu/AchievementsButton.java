package com.nminh123.martianrun.actors.Menu;

import com.badlogic.gdx.math.Rectangle;
import com.nminh123.martianrun.utils.Constants;

public class AchievementsButton extends GameButton {

    public interface AchievementsButtonListener {
        public void onAchievements();
    }

    private AchievementsButtonListener listener;

    public AchievementsButton(Rectangle bounds, AchievementsButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.ACHIEVEMENTS_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onAchievements();
    }

}
