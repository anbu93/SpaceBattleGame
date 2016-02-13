package com.vova_cons.Engine.Scene.Game.StatusBar;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.WindowSize;
import com.vova_cons.Engine.Scene.Game.Ship_old.Player.PlayerShip;
import com.vova_cons.Engine.Scene.Sprite;
import com.vova_cons.Physics.Point;
import com.vova_cons.UserInterface.Screen;

public class StatusBar {
    private Sprite background;
    private Sprite health;
    private Point backgoundTopLeft = Point.create(0, WindowSize.HEIGHT);
    private Point healthTopLeft = Point.create(100, WindowSize.HEIGHT-3);
    private Point scoreTopLeft = Point.create(WindowSize.WIDTH-100, WindowSize.HEIGHT-3);
    private final int delta = 25;
    private Numbers numbers;

    public StatusBar(Element statusBarSettings, Element numbersSetting){
        this.numbers = new Numbers(numbersSetting);
        background = new Sprite(statusBarSettings.sub("background").getValue());
        health = new Sprite(statusBarSettings.sub("health").getValue());
    }

    public void render(Screen screen, PlayerShip player){
        background.draw(screen, backgoundTopLeft);
        if (player == null)
            return;
        renderHealths(player.getHealths(), screen);
        renderScore(player.getScore(), screen);
    }

    private void renderHealths(int healts, Screen screen){
        for(int i = 0; i < healts; i++)
            health.draw(screen, healthTopLeft.offset(delta*i, 0));
    }

    private void renderScore(int score, Screen screen){
        int value;
        int counter = 0;
        int delta = 10;
        while(score > 0){
            value = score%10;
            score = score/10;
            Sprite sprite = numbers.get(value);
            sprite.draw(screen, scoreTopLeft.offset(-counter*delta, 0));
            counter++;
        }
    }
}
