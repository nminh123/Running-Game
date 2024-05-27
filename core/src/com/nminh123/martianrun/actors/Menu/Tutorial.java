package com.nminh123.martianrun.actors.Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.nminh123.martianrun.enums.GameState;
import com.nminh123.martianrun.utils.AssetsManager;
import com.nminh123.martianrun.utils.GameManager;

public class Tutorial extends Actor {

    private TextureRegion textureRegion;
    private Rectangle bounds;
    private BitmapFont font;
    private String text;

    public Tutorial(Rectangle bounds, String assetsId, String text) {
        this.bounds = bounds;
        this.text = text;
        textureRegion = AssetsManager.getTextureRegion(assetsId);
        SequenceAction sequenceAction = new SequenceAction();
        sequenceAction.addAction(Actions.delay(4f));
        sequenceAction.addAction(Actions.removeActor());
        addAction(sequenceAction);
        font = AssetsManager.getSmallestFont();
        setWidth(bounds.width);
        setHeight(bounds.height);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (GameManager.getInstance().getGameState() == GameState.OVER) {
            remove();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        // Draw the texture region
        batch.draw(textureRegion,
                bounds.x,
                bounds.y,
                bounds.width,
                bounds.height);

        GlyphLayout layout = new GlyphLayout();
        layout.setText(font,
                text,
                Color.WHITE,
                bounds.width,
                Align.right,
                true);

        font.draw(batch,
                layout,
                bounds.x,
                bounds.y + bounds.height);
    }
}
