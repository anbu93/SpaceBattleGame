package com.vova_cons.Engine.Scene.Game;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.WindowSize;
import com.vova_cons.Engine.Scene.Sprite;
import com.vova_cons.Physics.Point;
import com.vova_cons.UserInterface.Screen;

public class StatusBar {
    private Sprite background;
    private Sprite health;
    private Point backgoundTopLeft = Point.create(0, WindowSize.HEIGHT);
    private Point healthTopLeft = Point.create(100, WindowSize.HEIGHT-3);
    private final int delta = 25;

    public StatusBar(Element statusBarSettings){
        background = new Sprite(statusBarSettings.sub("background").getValue());
        health = new Sprite(statusBarSettings.sub("health").getValue());
    }

    void render(Screen screen, int playerHelths){
        background.draw(screen, backgoundTopLeft);
        for(int i = 0; i < playerHelths; i++)
           health.draw(screen, healthTopLeft.offset(delta*i, 0));
    }
}
