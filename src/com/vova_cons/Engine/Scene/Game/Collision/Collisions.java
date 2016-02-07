package com.vova_cons.Engine.Scene.Game.Collision;

import com.vova_cons.Common.WindowSize;
import com.vova_cons.Engine.ObjectIF;
import com.vova_cons.Engine.Scene.Game.GameScene;
import com.vova_cons.Engine.Scene.Game.Ship_old.Crash;
import com.vova_cons.Engine.Scene.Game.Ship_old.Enemy.Enemy;
import com.vova_cons.Engine.Scene.Game.Ship_old.Player.PlayerShip;
import com.vova_cons.Engine.Scene.Game.Ship_old.Ship;
import com.vova_cons.Physics.Point;

import java.util.List;

public class Collisions {
    private GameScene game;

    public Collisions(GameScene game){
        this.game = game;
    }

    public void update(List<ObjectIF> objectList){
        for(int i = 0; i < objectList.size(); i++) {
            ObjectIF obj = objectList.get(i);
            for (int j = 0; j < objectList.size(); j++) {
                if (i == j) continue;
                operate(obj, objectList.get(j));
            }
            if (!isIncludeWindow(obj))
                deleteObject(obj);
        }
    }
    private void operate(ObjectIF first, ObjectIF second){
        if (isCollised(first, second)){
            Crash crash;
            if (first instanceof Ship)
                crash = ((Ship) first).getCrash();
            else
                crash = ((Ship)second).getCrash();
            deleteObject(first);
            deleteObject(second);
        }
    }

    private boolean isCollised(ObjectIF first, ObjectIF second){
        if (first.getLayer() == second.getLayer()
                || first.getLayer() == ObjectIF.SYSTEM_LAYER
                || second.getLayer() == ObjectIF.SYSTEM_LAYER)
            return false;
        double deltaCenterX = Math.abs(first.getCenter().getX() - second.getCenter().getX());
        double deltaCenterY = Math.abs(first.getCenter().getY() - second.getCenter().getY());
        double deltaX = Math.abs(first.getWidth() - second.getWidth());
        double deltaY = Math.abs(first.getHeight() - second.getHeight());
        return deltaCenterX < deltaX && deltaCenterY < deltaY;
    }
    private boolean isIncludeWindow(ObjectIF object){
        Point bottomLeft = object.getTopLeft();
        Point size = Point.create(object.getWidth(), -object.getHeight());
        Point topRight = object.getTopLeft().offset(size);
        return bottomLeft.getX() > -50 && bottomLeft.getY() > -50
                && topRight.getY() < WindowSize.HEIGHT + 50
                && topRight.getX() < WindowSize.WIDTH + 50;
    }

    private void deleteObject(ObjectIF object){
        game.deleteObject(object);
        if (object instanceof Enemy)
            game.enemyDown();
        if (object instanceof PlayerShip)
            game.gameOver();
    }
}
