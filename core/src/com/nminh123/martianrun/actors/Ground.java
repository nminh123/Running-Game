package com.nminh123.martianrun.actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.nminh123.martianrun.box2d.GroundUserData;

public class Ground extends GameActor
{
    GameActor gameActor;
    public Ground(Body body)
    {
        super(body);
    }

    @Override
    public GroundUserData getUserData()
    {
        return (GroundUserData) userData;
    }
}
