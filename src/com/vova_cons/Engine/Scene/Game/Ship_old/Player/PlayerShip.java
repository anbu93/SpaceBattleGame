package com.vova_cons.Engine.Scene.Game.Ship_old.Player;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.WindowSize;
import com.vova_cons.Controller.Controller;
import com.vova_cons.Engine.Scene.Game.Ship_old.Enemy.*;
import com.vova_cons.Engine.Scene.Game.Ship_old.Ship;
import com.vova_cons.Physics.Point;

public class PlayerShip  extends Ship {
    protected Controller controller;
    boolean isFire = false;
    long prevShotTime;
    private static final long SHOT_DELTA = 500;
    private int hp = 3;
    private int score = 0;
    private int healtIncrementer = 0;

    public PlayerShip(Element settings, Point position, int number){
        super(settings, position);
        prevShotTime = getTime();
    }

    public Controller getController(){
        return controller;
    }


    public void fire(){
        if (getTime() - prevShotTime > SHOT_DELTA) {
            Point to = super.getCenter().offset(Point.create(0, WindowSize.HEIGHT * 2));
            super.fire(to);
            prevShotTime = getTime();
        }
    }

    public void startFire(){
        isFire = true;
    }

    public void stopFire(){
        isFire = false;
    }

    @Override
    protected void update() {
        if(isFire) fire();
    }

    private long getTime(){
        return System.currentTimeMillis();
    }

    public void playerDown() {
        hp--;
    }

    public boolean isGameOver() {
        return hp == 0;
    }

    public int getHealths() {
        return this.hp;
    }

    public void killEnemy(Enemy enemy) {
        if (enemy instanceof XWing) {
            score++;
            healtIncrementer++;
        }
        if (enemy instanceof YWing) {
            score += 2;
            healtIncrementer += 2;
        }
        if (enemy instanceof AWing) {
            score += 3;
            healtIncrementer+= 3;
        }
        if (enemy instanceof Sokol) {
            score += 5;
            healtIncrementer += 5;
        }
        if (healtIncrementer > 50){
            hp++;
            healtIncrementer = healtIncrementer % 50;
        }
    }

    public int getScore(){
        return score;
    }
}
