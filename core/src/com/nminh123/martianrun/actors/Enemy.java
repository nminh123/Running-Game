package com.nminh123.martianrun.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.nminh123.martianrun.box2d.EnemyUserData;

public class Enemy extends GameActor
{
    public Enemy(Body body)
    {
        super(body);
    }
    @Override
    public EnemyUserData getUserData()
    {
        return (EnemyUserData) userData;
    }
    @Override
    public void act(float delta)
    {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }
}
