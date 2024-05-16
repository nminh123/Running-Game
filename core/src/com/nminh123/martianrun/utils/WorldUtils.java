package com.nminh123.martianrun.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class WorldUtils
{
    public static World createWorld()
    {
        return new World(Constants.WORLD_GRAVITY,true);
    }

    public static Body createGround(World world)
    {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(Constants.WORLD_GRAVITY.x, Constants.WORLD_GRAVITY.y ));
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox((float)Constants.APP_WIDTH/2,(float)Constants.APP_HEIGHT/2);

        body.createFixture(shape, Constants.GROUND_DENSITY);
        shape.dispose();
        return body;
    }
}
