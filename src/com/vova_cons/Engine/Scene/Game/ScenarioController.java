package com.vova_cons.Engine.Scene.Game;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.Logger;
import com.vova_cons.Common.WindowSize;
import com.vova_cons.Engine.Object;
import com.vova_cons.Engine.Scene.Game.Ship_old.Enemy.Enemy;
import com.vova_cons.Engine.Scene.Game.Ship_old.Ship;
import com.vova_cons.Physics.Rectangle;

class ScenarioController {
    private Element scenario;
    private Element gameSettings;
    private String levelID = "initial";
    private int enemyCounter = 0;
    private GameScene gameScene;

    ScenarioController(Element settingsDocument, GameScene gameScene){
        scenario = settingsDocument.sub("scenario");
        gameSettings = settingsDocument.sub("sprite").sub("game");
        this.gameScene = gameScene;
        showMessage(scenario.sub(levelID));
    }

    public void enemyDown(){
        enemyCounter--;
        if (enemyCounter <= 0)
            nextLevel();
    }

    private void nextLevel(){
        levelID = scenario.sub(levelID).sub("next").getValue();
        if(levelID.equals("none")) return;
        showMessage(scenario.sub(levelID));
    }

    private void showMessage(Element levelSettings) {
        new Object(levelSettings.sub("message").getValue(), Rectangle.create(WindowSize.topLeft, 0, 0)) {
            int time = 40;
            @Override
            protected void update() {
                time--;
                if (time < 0) {
                    GameScene.remove(this);
                    buildLevel(scenario.sub(levelID));
                }
            }
            @Override
            public int getLayer() {
                return Object.SYSTEM_LAYER;
            }
        };
    }

    private void buildLevel(Element levelSettings){
        Logger.get().append("Level: ").append(levelID).endl();
        int size = Integer.parseInt(levelSettings.sub("size").getValue());
        String name = levelSettings.sub("name").getValue();
        for(int i = 1; i <= size; i++)
            create(levelSettings.sub(name+i));
        if (enemyCounter == 0) {
            enemyCounter = 1;
            enemyDown();
        }
    }

    private void create(Element shipSettings){
        if (Ship.create(gameSettings, shipSettings) instanceof Enemy)
            enemyCounter++;
    }

}
