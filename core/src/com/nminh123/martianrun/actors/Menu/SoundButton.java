package com.nminh123.martianrun.actors.Menu;

import com.badlogic.gdx.math.Rectangle;
import com.nminh123.martianrun.utils.AudioUtils;

public class SoundButton extends GameButton {

    public SoundButton(Rectangle bounds) {
        super(bounds);
    }

    @Override
    protected String getRegionName() {
        return AudioUtils.getInstance().getSoundRegionName();
    }

    @Override
    public void touched() {
        AudioUtils.getInstance().toggleSound();
    }

}
