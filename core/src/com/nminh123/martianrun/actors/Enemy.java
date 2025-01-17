package com.nminh123.martianrun.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.physics.box2d.Body;
import com.nminh123.martianrun.box2d.EnemyUserData;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nminh123.martianrun.utils.Constants;
import com.badlogic.gdx.Gdx;
import com.nminh123.martianrun.utils.GameManager;
import com.nminh123.martianrun.utils.AssetsManager;
import com.nminh123.martianrun.enums.GameState;

public class Enemy extends GameActor
{
    private Animation animation;
    private float stateTime;

    public Enemy(Body body) {
        super(body);
        animation = AssetsManager.getAnimation(getUserData().getAnimationAssetId());
        stateTime = 0f;
    }

    @Override
    public EnemyUserData getUserData() {
        return (EnemyUserData) userData;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (GameManager.getInstance().getGameState() != GameState.PAUSED) {
            stateTime += Gdx.graphics.getDeltaTime();
        }

        batch.draw((TextureRegion)animation.getKeyFrame(stateTime, true), (screenRectangle.x - (screenRectangle.width * 0.1f)),
                screenRectangle.y, screenRectangle.width * 1.2f, screenRectangle.height * 1.1f);
    }
}
