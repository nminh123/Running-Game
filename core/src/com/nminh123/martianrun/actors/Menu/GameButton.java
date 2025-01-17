package com.nminh123.martianrun.actors.Menu;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nminh123.martianrun.utils.AssetsManager;

public abstract class GameButton extends Button {

    protected Rectangle bounds;
    private final Skin skin;


    public GameButton(Rectangle bounds) {
        this.bounds = bounds;
        setWidth(bounds.width);
        setHeight(bounds.height);
        setBounds(bounds.x,
                  bounds.y,
                  bounds.width,
                  bounds.height);
        skin = new Skin();
        skin.addRegions(AssetsManager.getTextureAtlas());
        loadTextureRegion();
        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event,
                                     float x,
                                     float y,
                                     int pointer,
                                     int button) {
                touched();
                loadTextureRegion();
                return true;
            }
        });
    }

    protected void loadTextureRegion() {
        ButtonStyle style = new ButtonStyle();
        style.up = skin.getDrawable(getRegionName());
        setStyle(style);
    }

    protected abstract String getRegionName();

    public abstract void touched();

    public Rectangle getBounds() {
        return bounds;
    }

}