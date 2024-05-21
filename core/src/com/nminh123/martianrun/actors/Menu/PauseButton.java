package com.nminh123.martianrun.actors.Menu;

import com.badlogic.gdx.math.Rectangle;
import com.nminh123.martianrun.enums.GameState;
import com.nminh123.martianrun.utils.Constants;
import com.nminh123.martianrun.utils.GameManager;

public class PauseButton extends GameButton {

    public interface PauseButtonListener {
        public void onPause();

        public void onResume();
    }

    private PauseButtonListener listener;

    public PauseButton(Rectangle bounds, PauseButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return GameManager.getInstance().getGameState() == GameState.PAUSED ? Constants.PLAY_REGION_NAME : Constants.PAUSE_REGION_NAME;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (GameManager.getInstance().getGameState() == GameState.OVER) {
            remove();
        }
    }

    @Override
    public void touched() {
        if (GameManager.getInstance().getGameState() == GameState.PAUSED) {
            listener.onResume();
        } else {
            listener.onPause();
        }
    }

}
