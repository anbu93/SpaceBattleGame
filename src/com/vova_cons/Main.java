package com.vova_cons;

import com.vova_cons.Common.Logger;
import com.vova_cons.Engine.GameIF;
import com.vova_cons.Engine.GameImpl;
import com.vova_cons.Engine.Scene.AbstractScene;
import com.vova_cons.UserInterface.Screen;

public class Main {

    public static void main(String[] args) {
        Logger.get().append("Application started.").endl();
        GameIF game = new GameImpl(Screen.createAwtScreen());
        game.changeScene(AbstractScene.MENU_SCENE);
        game.loop();
    }
}
