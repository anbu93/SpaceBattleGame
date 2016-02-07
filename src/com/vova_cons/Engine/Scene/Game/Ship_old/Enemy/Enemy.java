package com.vova_cons.Engine.Scene.Game.Ship_old.Enemy;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.WindowSize;
import com.vova_cons.Engine.Scene.Game.Ship_old.Ship;
import com.vova_cons.Physics.Point;

public class Enemy extends Ship {
    long lastShotTime;
    long lastMoveTime;
    long nextShotTime;

    long SHOT_TIME_DELTA_MIN;
    long SHOT_TIME_DELTA_RANDOM;
    long MOVE_TIME_DELTA;
    long SHOT_ANGLE;

    private boolean isFire = false;

    public Enemy(Element settings, Point position) {
        super(settings, position);
        lastShotTime = getTime();
        lastMoveTime = getTime();
        super.goTo(getRandomPoint());
    }

    @Override
    protected void update() {
        if (getTime() - lastShotTime > nextShotTime) {
            isFire = true;
            lastShotTime = getTime();
            generateNextShotTime();
        }
        if (getTime() - lastMoveTime > MOVE_TIME_DELTA) {
            move();
            lastMoveTime = getTime();
        }
        if(isFire) fire();
    }

    protected void generateNextShotTime(){
        nextShotTime = SHOT_TIME_DELTA_MIN + (long)(Math.random()*SHOT_TIME_DELTA_RANDOM);
    }

    protected void move(){
        super.goTo(getRandomPoint());
    }

    private Point getRandomPoint(){
        double x = WindowSize.WIDTH * Math.random();
        double y = WindowSize.HEIGHT * Math.random();
        return Point.create(x, y);
    }

    private long getTime(){
        return System.currentTimeMillis();
    }

    protected void fire(){
        Point to = super.getCenter().offset(Point.create(Math.random()*SHOT_ANGLE - SHOT_ANGLE/2, -WindowSize.HEIGHT*2));
        super.fire(to);
        stopFire();
    }

    protected long parse(String str){
        return Long.parseLong(str);
    }

    protected void stopFire() {
        isFire = false;
    }
}
