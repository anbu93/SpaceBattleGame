package com.vova_cons.Engine.Scene.Background;

import com.vova_cons.Common.WindowSize;
import com.vova_cons.UserInterface.Drawable;
import com.vova_cons.UserInterface.Screen;

public class Background {
    public static final int SPEED = 5;
    private Sprite sprite1;
    private Sprite sprite2;

    public Background(String backgroundSprite){
        sprite1 = new Sprite(backgroundSprite, WindowSize.HEIGHT*2);
        sprite2 = new Sprite(backgroundSprite, WindowSize.HEIGHT);
    }

    public void update(){
        sprite1.update(0);
        sprite2.update(0);
    }

    public void render(Screen screen){
        screen.draw(sprite1);
        screen.draw(sprite2);
    }

    public Drawable getDrawable1(){
        return sprite1;
    }
    public Drawable getDrawable2(){
        return sprite2;
    }
}