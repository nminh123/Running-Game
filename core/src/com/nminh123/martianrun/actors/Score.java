package com.nminh123.martianrun.actors;

import com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Align;
import com.nminh123.martianrun.utils.AssetsManager;
import com.nminh123.martianrun.utils.GameManager;
import com.nminh123.martianrun.enums.GameState;

public class Score extends Actor {

    private float score;
    private int multiplier;
    private Rectangle bounds;
    private BitmapFont font;

    public Score(Rectangle bounds) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        score = 0;
        multiplier = 5;
        font = AssetsManager.getSmallFont();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (GameManager.getInstance().getGameState() != GameState.RUNNING) {
            return;
        }
        score += multiplier * delta;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (getScore() == 0) {
            return;
        }
        String scoreText = String.format("%d", score);
        // Create a GlyphLayout
        GlyphLayout layout = new GlyphLayout();

        // Set the text with right alignment
        layout.setText(font,
                scoreText,
                Color.WHITE,
                bounds.width,
                Align.right,
                true);
        /*font.draw(batch,
                String.format("%d", getScore()),
                bounds.x,
                bounds.y,
                bounds.width,
                Glyph.RIGHT);*/
        font.draw(batch, layout, bounds.x, bounds.y + layout.height);
    }

    public int getScore() {
        return (int) Math.floor(score);
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

}
