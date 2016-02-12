package com.vova_cons.Engine.Scene.Game.Ship_old.Player;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.WindowSize;
import com.vova_cons.Controller.Controller;
import com.vova_cons.Engine.Scene.Game.Ship_old.Ship;
import com.vova_cons.Physics.Point;

public class PlayerShip  extends Ship {
    protected Controller controller;
    boolean isFire = false;
    long prevShotTime;
    private static final long SHOT_DELTA = 500;
    private int hp = 3;

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
}
