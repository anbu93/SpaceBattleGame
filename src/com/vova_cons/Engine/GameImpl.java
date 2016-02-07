package com.vova_cons.Engine;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.DocumentParser.Parser;
import com.vova_cons.Engine.Scene.AbstractScene;
import com.vova_cons.Engine.Scene.Scene;
import com.vova_cons.UserInterface.Screen;

public class GameImpl implements GameIF, Runnable {
    private Scene[] sceneCollection;
    private Scene scene;
    private boolean isRunning = true;
    private Element settings = Parser.parse("settings.txt");

    public Element getSettings(String moduleName){
        return settings.sub(moduleName);
    }
    public Element getAllSettings() {
        return settings;
    }


    public GameImpl(Screen screen){
        sceneCollection = AbstractScene.create(screen, this);
    }

    @Override
    public void changeScene(int sceneID) {
        if (AbstractScene.isCorrectSceneID(sceneID))
            scene = sceneCollection[sceneID];
        else
            scene = sceneCollection[0];
        scene.start();
    }

    @Override
    public void loop() {
        Thread gameThread;
        while(isRunning) {
            gameThread = new Thread(this);
            gameThread.start();
            sleep(50);
            join(gameThread);
        }
    }

    protected void sleep(long time){
        try { Thread.sleep(time); } catch (Exception ignoreErrors) {}
    }
    private void join(Thread thread){
        try { thread.join(); } catch (Exception ignoredError) {}
    }


    @Override
    public void run() {
        scene.update();
        scene.render();
    }
}
