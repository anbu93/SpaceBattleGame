package com.vova_cons.Engine.Scene.Menu;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.Logger;
import com.vova_cons.Common.WindowSize;
import com.vova_cons.Controller.Controller;
import com.vova_cons.Engine.Scene.Background.Background;
import com.vova_cons.Engine.GameImpl;
import com.vova_cons.Engine.Scene.AbstractScene;
import com.vova_cons.Engine.Sprite;
import com.vova_cons.Physics.Point;
import com.vova_cons.UserInterface.Screen;

public class MenuScene extends AbstractScene {
    private Controller controller = new MenuController(this);
    private Background background;
    private Sprite title;
    private Sprite newGameButton;
    private Sprite exitButton;

    public MenuScene(GameImpl game) {
        super(game);
        Element sprites = game.getSettings("sprite").sub("menu");
        Point point = Point.create(0, WindowSize.HEIGHT);
        background = new Background(sprites.sub("background").getValue());
        title = new Sprite(sprites.sub("title").getValue(), point);
        newGameButton = new Sprite(sprites.sub("new_game").getValue(), point);
        exitButton = new Sprite(sprites.sub("exit").getValue(), point);
    }


    @Override
    public void start() {
        super.changeController(controller);
    }

    @Override
    public void update() {
        background.update();
    }

    @Override
    protected void render(Screen screen) {
        background.render(screen);
        screen.draw(title);
        screen.draw(newGameButton);
        screen.draw(exitButton);
    }

    public void clickOn(Point point) {
        if(isNewGame(point))
            super.changeScene(AbstractScene.GAME_SCENE);
        else if(isExit(point)) {
            Logger.get().save();
            System.exit(0);
        }
    }

    private boolean isNewGame(Point point){
        return point.getX() > 160 && point.getX() < 615 &&
                point.getY() > 310 && point.getY() < 410;
    }
    private boolean isExit(Point point){
        return point.getX() > 160 && point.getX() < 615 &&
                point.getY() > 200 && point.getY() < 310;
    }
}
