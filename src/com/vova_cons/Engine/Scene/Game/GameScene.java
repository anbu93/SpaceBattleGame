package com.vova_cons.Engine.Scene.Game;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.Logger;
import com.vova_cons.Common.WindowSize;
import com.vova_cons.Engine.ObjectIF;
import com.vova_cons.Engine.Scene.Background.Background;
import com.vova_cons.Engine.Scene.Game.Collision.Collisions;
import com.vova_cons.Engine.GameImpl;
import com.vova_cons.Engine.Object;
import com.vova_cons.Engine.Scene.AbstractScene;
import com.vova_cons.Engine.Scene.Game.Ship_old.Player.Player1Ship;
import com.vova_cons.Engine.Scene.Game.Ship_old.Player.PlayerShip;
import com.vova_cons.Engine.Sprite;
import com.vova_cons.UserInterface.Screen;

public class GameScene extends AbstractScene {
    private static GameScene instance;
    private Background background = new Background("background.png");
    private ObjectList objectList = new ObjectList();
    private Collisions collisions = new Collisions(this);
    private Element settings;
    private PlayerShip player;
    private PlayerShip player2;


    private boolean isGameOver = false;
    private Sprite gameOverSprite;
    private boolean isPaused = false;
    private Sprite pauseSprite;
    private ScenarioController scenarioController;

    public GameScene(GameImpl game) {
        super(game);
        instance = this;
        settings = game.getSettings("sprite").sub("game");
        background = new Background(settings.sub("background").getValue());
        gameOverSprite = new Sprite(settings.sub("game_over").getValue(), WindowSize.topLeft);
        pauseSprite = new Sprite(settings.sub("pause").getValue(), WindowSize.topLeft);
    }

    public static void add(ObjectIF obj){
        instance.objectList.add(obj);
    }
    public static void remove(ObjectIF object) {
        instance.objectList.remove(object);
    }
    public static void addPlayerShip(PlayerShip player){
        if (player instanceof Player1Ship) {
            instance.player = player;
            instance.changeController(player.getController());
        } else {
            instance.player2 = player;
            instance.changeController(player.getController());
        }
    }


    public static PlayerShip getPlayer(){
        return instance.player;
    }

    @Override
    public void start() {
        objectList.clear();
        isGameOver = false;
        isPaused = false;
        scenarioController = new ScenarioController(game.getAllSettings(), this);
        Logger.get().append("Game started").endl();
    }

    @Override
    public void update(){
        background.update();
        if (isGameOver) return;
        if (isPaused) return;
        objectList.update();
        collisions.update(objectList.get());
    }

    @Override
    protected void render(Screen screen) {
        screen.draw(background.getDrawable1());
        screen.draw(background.getDrawable2());
        objectList.render(screen);
        if (isPaused)
            screen.draw(pauseSprite);
        if(isGameOver)
            screen.draw(gameOverSprite);
    }

    public void deleteObject(ObjectIF obj) {
        objectList.remove(obj);
    }

    public void gameOver() {
        isGameOver = true;
        Logger.get().append("Game over!");
    }

    public void pauseHandler(){
        isPaused = !isPaused;
    }

    public void leave() {
        super.changeScene(AbstractScene.MENU_SCENE);
    }

    public void enemyDown() {
        scenarioController.enemyDown();
    }

    public static void pushESC() {
        instance.changeScene(MENU_SCENE);
    }
    public static void pushSPACE(){
        instance.pauseHandler();
    }
}
