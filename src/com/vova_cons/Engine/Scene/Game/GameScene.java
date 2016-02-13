package com.vova_cons.Engine.Scene.Game;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.Logger;
import com.vova_cons.Common.WindowSize;
import com.vova_cons.Engine.GameImpl;
import com.vova_cons.Engine.ObjectIF;
import com.vova_cons.Engine.Scene.AbstractScene;
import com.vova_cons.Engine.Scene.Background.Background;
import com.vova_cons.Engine.Scene.Game.Collision.Collisions;
import com.vova_cons.Engine.Scene.Game.Ship_old.Enemy.Enemy;
import com.vova_cons.Engine.Scene.Game.Ship_old.Player.PlayerShip;
import com.vova_cons.Engine.Scene.Game.StatusBar.StatusBar;
import com.vova_cons.Engine.Sprite;
import com.vova_cons.UserInterface.Screen;

public class GameScene extends AbstractScene {
    /** settings fields */
    private static GameScene instance;
    private Element settings;
    /** objects fields */
    private Background background = new Background("background.png");
    private ObjectList objectList = new ObjectList();
    private ScenarioController scenarioController;
    private Collisions collisions = new Collisions(this);
    private PlayerShip player;
    /** game logic fields */
    private boolean isGameOver = false;
    private Sprite gameOverSprite;
    private boolean isPaused = false;
    private Sprite pauseSprite;
    private int isPlayerDown = -1;
    private StatusBar statusBar;


    /** Constructor */
    public GameScene(GameImpl game) {
        super(game);
        instance = this;
        settings = game.getSettings("sprite").sub("game");
        background = new Background(settings.sub("background").getValue());
        gameOverSprite = new Sprite(settings.sub("game_over").getValue(), WindowSize.topLeft);
        pauseSprite = new Sprite(settings.sub("pause").getValue(), WindowSize.topLeft);
        statusBar = new StatusBar(settings.sub("status_bar"), game.getSettings("numbers"));
    }

    /** Override standart methods */
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
        if (isPlayerDown > -1) isPlayerDown--;
        if (isPlayerDown == 0) regenerate();
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
        renderStatusBar(screen);
        if (isPaused)
            screen.draw(pauseSprite);
        if(isGameOver)
            screen.draw(gameOverSprite);
    }
    private void renderStatusBar(Screen screen){
        statusBar.render(screen, player);
    }

    /** ObjectCollections methods */
    public static void add(ObjectIF obj){
        instance.objectList.add(obj);
    }
    public static void remove(ObjectIF object) {
        instance.deleteObject(object);
    }
    public void deleteObject(ObjectIF obj) {
        objectList.remove(obj);
    }

    /** Player methods */
    public static void addPlayerShip(PlayerShip player){
        instance.player = player;
        instance.changeController(player.getController());
    }
    public static PlayerShip getPlayer(){
        return instance.player;
    }

    public static void pushESC() {
        instance.changeScene(MENU_SCENE);
    }
    public static void pushSPACE(){
        instance.isPaused = !instance.isPaused;
    }

    /** Ships destroy methods */
    public void enemyDown(Enemy object) {
        player.killEnemy(object);
        scenarioController.enemyDown();
    }
    public void playerDown() {
        Logger.get().append("player down.").endl();
        isPlayerDown = 5;
        player.playerDown();
    }
    private void regenerate(){
        if (player.isGameOver())
            gameOver();
        else {
            objectList.clear();
            objectList.add(player);
            scenarioController.rebuildLevel();
        }
    }
    private void gameOver() {
        isGameOver = true;
        Logger.get().append("Game over!");
    }
}
