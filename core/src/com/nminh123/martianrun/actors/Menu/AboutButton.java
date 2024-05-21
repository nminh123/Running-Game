package com.nminh123.martianrun.actors.Menu;

import com.badlogic.gdx.math.Rectangle;
import com.nminh123.martianrun.enums.GameState;
import com.nminh123.martianrun.utils.Constants;
import com.nminh123.martianrun.utils.GameManager;

public class AboutButton extends GameButton {

    public interface AboutButtonListener {
        public void onAbout();
    }

    private AboutButtonListener listener;

    public AboutButton(Rectangle bounds, AboutButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return GameManager.getInstance().getGameState() == GameState.ABOUT ? Constants.CLOSE_REGION_NAME :
                Constants.ABOUT_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onAbout();
    }

}