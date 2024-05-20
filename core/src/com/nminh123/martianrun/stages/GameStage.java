package com.nminh123.martianrun.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;
import com.nminh123.martianrun.utils.BodyUtils;
import com.nminh123.martianrun.utils.WorldUtils;
import com.nminh123.martianrun.actors.Ground;
import com.nminh123.martianrun.actors.Runner;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.nminh123.martianrun.actors.Enemy;

public class GameStage extends Stage implements ContactListener {
    private static final int VIEWPORT_WIDTH = 20;
    private static final int VIEWPORT_HEIGHT = 13;


    private World world;
    private Ground ground;
    private Runner runner;


    private final float TIME_STEP = 1 / 300F;
    private float accumulator = 0f;


    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;
    private Vector3 touchPoint;


    private Rectangle screenLeftSide;
    private Rectangle screenRightSide;

    public GameStage()
    {
        renderer = new Box2DDebugRenderer();
        setUpWorld();
        setupCamera();
        setupTouchControlAreas();
    }

    private void setupTouchControlAreas() {
        touchPoint = new Vector3();
        screenLeftSide = new Rectangle(0, 0, getCamera().viewportWidth / 2, getCamera().viewportHeight);
        screenRightSide = new Rectangle(getCamera().viewportWidth / 2, 0, getCamera().viewportWidth / 2,
                getCamera().viewportHeight);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button)
    {
        translateScreenToWorldCoordinates(x, y);

        if (rightSideTouched(touchPoint.x, touchPoint.y)) {
            runner.jump();
        } else if (leftSideTouched(touchPoint.x, touchPoint.y)) {
            runner.dodge();
        }

        return super.touchDown(x, y, pointer, button);
    }

    public void translateScreenToWorldCoordinates(int x, int y)
    {
        getCamera().unproject(touchPoint.set(x, y, 0));
    }

    void setupCamera()
    {
        camera = new OrthographicCamera(VIEWPORT_WIDTH,VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2,0f);
        camera.update();
    }

    void setUpWorld()
    {
        world = WorldUtils.createWorld();
        world.setContactListener(this);
        setUpGround();
        setUpRunner();
        createEnemy();
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        if (runner.isDodging()) {
            runner.stopDodge();
        }

        return super.touchUp(screenX, screenY, pointer, button);
    }

    private boolean rightSideTouched(float x, float y)
    {
        return screenRightSide.contains(x, y);
    }

    private boolean leftSideTouched(float x, float y) {
        return screenLeftSide.contains(x, y);
    }

    public void beginContact(Contact contact)
    {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if ((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsGround(b)) ||
                (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsRunner(b)))
        {
            runner.landed();
        }
    }

    public void endContact(Contact contact)
    {
    }

    public void preSolve(Contact contact, Manifold oldManifold)
    {
    }

    public void postSolve(Contact contact, ContactImpulse impulse)
    {
    }

    void setUpGround()
    {
        ground = new Ground(WorldUtils.createGround(world));
        addActor(ground);
    }

    void setUpRunner()
    {
        runner = new Runner(WorldUtils.createRunner(world));
        addActor(runner);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);
        for(Body body : bodies)
        {
            update(body);
        }
        //Fixed timestep
        accumulator += delta;

        while(accumulator >= delta)
        {
            world.step(TIME_STEP ,6,2);
            accumulator -= TIME_STEP;
        }

        //TODO: Implement interpolation
    }

    private void update(Body body) {
        if (!BodyUtils.bodyInBounds(body)) {
            if (BodyUtils.bodyIsEnemy(body) && !runner.isHit()) {
                createEnemy();
            }
            world.destroyBody(body);
        }
    }

    private void createEnemy() {
        Enemy enemy = new Enemy(WorldUtils.createEnemy(world));
        addActor(enemy);
    }

    @Override
    public void draw() {
        super.draw();
        renderer.render(world,camera.combined);
    }
}
