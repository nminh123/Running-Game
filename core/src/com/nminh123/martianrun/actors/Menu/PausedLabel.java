package com.nminh123.martianrun.actors.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.nminh123.martianrun.enums.GameState;
import com.nminh123.martianrun.utils.AssetsManager;
import com.nminh123.martianrun.utils.Constants;
import com.nminh123.martianrun.utils.GameManager;

public class PausedLabel extends Actor {

    private Rectangle bounds;
    private BitmapFont font;

    public PausedLabel(Rectangle bounds) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        font = AssetsManager.getSmallFont();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (GameManager.getInstance().getGameState() == GameState.PAUSED) {
            font.draw(batch, Constants.PAUSED_LABEL, bounds.x, bounds.y, bounds.width,
                    BitmapFont.HAlignment.CENTER);
        }
    }

}
