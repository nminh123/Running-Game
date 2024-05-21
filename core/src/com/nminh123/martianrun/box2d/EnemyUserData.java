package com.nminh123.martianrun.box2d;

import com.nminh123.martianrun.enums.UserDataType;
import com.nminh123.martianrun.utils.Constants;
import com.badlogic.gdx.math.Vector2;
public class EnemyUserData extends UserData {

    private Vector2 linearVelocity;
    private String animationAssetId;

    public EnemyUserData(float width, float height, String animationAssetId) {
        super(width, height);
        userDataType = UserDataType.ENEMY;
        linearVelocity = Constants.ENEMY_LINEAR_VELOCITY;
        this.animationAssetId = animationAssetId;
    }

    public void setLinearVelocity(Vector2 linearVelocity) {
        this.linearVelocity = linearVelocity;
    }

    public Vector2 getLinearVelocity() {
        return linearVelocity;
    }

    public String getAnimationAssetId() {
        return animationAssetId;
    }

}
