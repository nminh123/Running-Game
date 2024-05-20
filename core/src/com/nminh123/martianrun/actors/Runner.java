package com.nminh123.martianrun.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.nminh123.martianrun.box2d.RunnerUserData;
import com.nminh123.martianrun.utils.Constants;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.Gdx;

public class Runner extends GameActor{
    private boolean jumping;
    private boolean dodging;
    private boolean hit;
    private final Animation runningAnimation;
    private final TextureRegion jumpingTexture;
    private final TextureRegion dodgingTexture;
    private final TextureRegion hitTexture;
    private float stateTime;

    public Runner(Body body) {
        super(body);
        TextureAtlas textureAtlas = new TextureAtlas(Constants.CHARACTERS_ATLAS_PATH);
        TextureRegion[] runningFrames = new TextureRegion[Constants.RUNNER_RUNNING_REGION_NAMES.length];
        for (int i = 0; i < Constants.RUNNER_RUNNING_REGION_NAMES.length; i++) {
            String path = Constants.RUNNER_RUNNING_REGION_NAMES[i];
            runningFrames[i] = textureAtlas.findRegion(path);
        }
        runningAnimation = new Animation(0.1f, runningFrames);
        stateTime = 0f;
        jumpingTexture = textureAtlas.findRegion(Constants.RUNNER_JUMPING_REGION_NAME);
        dodgingTexture = textureAtlas.findRegion(Constants.RUNNER_DODGING_REGION_NAME);
        hitTexture = textureAtlas.findRegion(Constants.RUNNER_HIT_REGION_NAME);
    }

    public RunnerUserData getUserData()
    {
        return (RunnerUserData) userData;
    }

    public void jump()
    {
        if (!(jumping || dodging || hit))
        {
            body.applyLinearImpulse(getUserData().getJumpingLinearImpulse(),
                    body.getWorldCenter(), true);
            jumping = true;
        }
    }

    public void landed()
    {
        jumping = false;
    }

    public void dodge() {
        if (!(jumping || hit))
        {
            body.setTransform(getUserData().getDodgePosition(),
                    getUserData().getDodgeAngle());
            dodging = true;
        }
    }

    public void stopDodge()
    {
        dodging = false;
        if (!hit) {
            body.setTransform(getUserData().getRunningPosition(), 0f);
        }
    }

    public boolean isDodging() {
        return dodging;
    }

    public void hit()
    {
        body.applyAngularImpulse(getUserData().getHitAngularImpulse(),true);
        hit = true;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        float x = screenRectangle.x - (screenRectangle.width * 0.1f);
        float y = screenRectangle.y;
        float width = screenRectangle.width * 1.2f;
        if (dodging)
        {
            batch.draw(dodgingTexture,x, y + (float)screenRectangle.height / 4, width,
                    (float)screenRectangle.height * 3 / 4);
        }
        else if (hit)
        {
            batch.draw(hitTexture, x, y,width * 0.5f,
                    screenRectangle.height * 0.5f,
                    width, screenRectangle.height, 1f, 1f,
                    (float) Math.toDegrees(body.getAngle()));
        }
        else if (jumping)
        {
            batch.draw(jumpingTexture,
                    x, y, width, screenRectangle.height);
        }
        else
        {
            // Running
            stateTime += Gdx.graphics.getDeltaTime();
            batch.draw((Texture) runningAnimation.getKeyFrame(stateTime, true),
                    (float)x,
                    (float)y,
                    (float)getWidth(),
                    (float)screenRectangle.getHeight());
        }
    }

    public boolean isHit()
    {
        return hit;
    }
}
