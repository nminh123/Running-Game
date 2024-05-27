package com.nminh123.martianrun.actors.Menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.nminh123.martianrun.utils.AssetsManager;
import com.nminh123.martianrun.utils.Constants;

public class GameLabel extends Actor {

    private Rectangle bounds;
    private BitmapFont font;

    public GameLabel(Rectangle bounds)
    {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        font = AssetsManager.getLargeFont();
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        super.draw(batch, parentAlpha);
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font,
                Constants.GAME_NAME,
                Color.WHITE,
                bounds.width,
                Align.center,
                true);

        float textY = bounds.y + bounds.height / 2 + layout.height / 2;
        font.draw(batch, layout, bounds.x, textY);
    }

}
