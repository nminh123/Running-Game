package com.nminh123.martianrun.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.nminh123.martianrun.box2d.GroundUserData;
import com.nminh123.martianrun.utils.AssetsManager;
import com.nminh123.martianrun.utils.Constants;
import com.nminh123.martianrun.utils.GameManager;
import com.nminh123.martianrun.enums.GameState;

public class Ground extends GameActor
{
    private final TextureRegion textureRegion;
    private Rectangle textureRegionBounds1;
    private Rectangle textureRegionBounds2;
    private int speed = 10;

    public Ground(Body body) {
        super(body);
        textureRegion = AssetsManager.getTextureRegion(Constants.GROUND_ASSETS_ID);
        textureRegionBounds1 = new Rectangle(0 - getUserData().getWidth() / 2,
                                             0,
                                                getUserData().getWidth(),
                                                getUserData().getHeight());
        textureRegionBounds2 = new Rectangle(getUserData().getWidth() / 2, 0, getUserData().getWidth(),
                getUserData().getHeight());
    }

    @Override
    public GroundUserData getUserData() {
        return (GroundUserData) userData;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (GameManager.getInstance().getGameState() != GameState.RUNNING) {
            return;
        }

        if (leftBoundsReached(delta)) {
            resetBounds();
        } else {
            updateXBounds(-delta);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion,
                textureRegionBounds1.x,
                (float) screenRectangle.y,
                (float)screenRectangle.getWidth(),
                (float)screenRectangle.getHeight());
        batch.draw(textureRegion,
                textureRegionBounds2.x,
                (float)screenRectangle.y,
                (float)screenRectangle.getWidth(),
                (float)screenRectangle.getHeight());
    }

    private boolean leftBoundsReached(float delta) {
        return (textureRegionBounds2.x - transformToScreen(delta * speed)) <= 0;
    }

    private void updateXBounds(float delta) {
        textureRegionBounds1.x += transformToScreen(delta * speed);
        textureRegionBounds2.x += transformToScreen(delta * speed);
    }

    private void resetBounds() {
        textureRegionBounds1 = textureRegionBounds2;
        textureRegionBounds2 = new Rectangle(textureRegionBounds1.x + screenRectangle.width, 0, screenRectangle.width,
                screenRectangle.height);
    }
}
