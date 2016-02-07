package com.vova_cons.Engine.Scene;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.WindowSize;
import com.vova_cons.Controller.Controller;
import com.vova_cons.Controller.NullController;
import com.vova_cons.Engine.GameImpl;
import com.vova_cons.Engine.Sprite;
import com.vova_cons.Physics.Point;
import com.vova_cons.UserInterface.Screen;

public class NullScene extends AbstractScene {
    Sprite sprite;
    Controller controller = new NullController();

    public NullScene(GameImpl game){
        super(game);
        Element sprites = game.getSettings("sprite");
        sprite = new Sprite(sprites.sub("error").getValue(), Point.create(0, WindowSize.HEIGHT));
    }

    @Override
    public void start() {
        super.changeController(controller);
    }

    @Override
    protected void render(Screen screen) {
        screen.draw(sprite);
    }
}
