package com.nminh123.martianrun.actors.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Align;
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
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font,
                Constants.PAUSED_LABEL,
                Color.WHITE,
                bounds.width,
                Align.center,
                true);

        float textY = bounds.y + bounds.height / 2 + layout.height / 2;
        if (GameManager.getInstance().getGameState() == GameState.PAUSED) {
//            font.draw(batch,
//                    Constants.PAUSED_LABEL,
//                    bounds.x,
//                    bounds.y,
//                    bounds.width,
//                    BitmapFont.HAlignment.CENTER);
            font.draw(batch,
                    layout,
                    bounds.x,
                    textY);
        }
    }

}
