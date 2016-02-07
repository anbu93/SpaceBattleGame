package com.vova_cons.Engine.Scene;

import com.vova_cons.Controller.Controller;
import com.vova_cons.Engine.GameIF;
import com.vova_cons.Engine.GameImpl;
import com.vova_cons.Engine.Scene.Game.GameScene;
import com.vova_cons.Engine.Scene.Menu.MenuScene;
import com.vova_cons.UserInterface.Screen;

public abstract class AbstractScene implements Scene {
    public static final int NULL_SCENE = 0;
    public static final int MENU_SCENE = 1;
    public static final int GAME_SCENE = 2;
    private Screen screen;
    protected GameImpl game;

    public static Scene[] create(Screen screen, GameImpl game){
        AbstractScene[] scenes = new AbstractScene[3];
        scenes[NULL_SCENE] = new NullScene(game);
        scenes[MENU_SCENE] = new MenuScene(game); // new MenuScene();
        scenes[GAME_SCENE] = new GameScene(game); // new GameScene();
        for(AbstractScene scene : scenes)
            scene.screen = screen;
        return scenes;
    }

    protected AbstractScene(GameImpl game){
        this.game = game;
    }

    public static boolean isCorrectSceneID(int sceneID) {
        return sceneID > 0 && sceneID < 3;
    }

    @Override
    public void update(){}

    @Override
    public void render() {
        screen.clear();
        render(screen);
        screen.flush();
    }

    protected abstract void render(Screen screen);

    protected void changeController(Controller controller){
        screen.changeController(controller);
    }
    protected void changeScene(int sceneID){
        game.changeScene(sceneID);
    }
}
