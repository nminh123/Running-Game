package com.nminh123.martianrun.actors.Menu;

import com.badlogic.gdx.math.Rectangle;
import com.nminh123.martianrun.enums.GameState;
import com.nminh123.martianrun.utils.Constants;
import com.nminh123.martianrun.utils.GameManager;

public class LeaderboardButton extends GameButton {

    public interface LeaderboardButtonListener {
        public void onLeaderboard();
    }

    private LeaderboardButtonListener listener;

    public LeaderboardButton(Rectangle bounds, LeaderboardButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.LEADERBOARD_REGION_NAME;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (GameManager.getInstance().getGameState() != GameState.OVER) {
            remove();
        }
    }

    @Override
    public void touched() {
        listener.onLeaderboard();
    }

}
