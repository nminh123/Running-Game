package com.nminh123.martianrun.GameWorld;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.nminh123.martianrun.stages.GameStage;
import com.badlogic.gdx.Gdx;
public class GameScreen implements Screen{
    private GameStage stage;

    public GameScreen() {
        stage = new GameStage();
    }

    @Override
    public void render(float delta) {
        //Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update the stage
        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
