package com.vova_cons.GlobalInterfaces;

import com.vova_cons.Physics.Point;

public interface Collisionable {
    int NOT_COLLISED = 0;
    int PLAYER_LAYER = 1;
    int ENEMY_LAYER = 2;
    int NEUTRAL_LAYER = 3;

    Point getCenter();
    double getWidth();
    double getHeight();
    int getLayer();

    static boolean isCollisedLayers(Collisionable obj1, Collisionable obj2){
        if (obj1.getLayer() == NOT_COLLISED) return false;
        if (obj2.getLayer() == NOT_COLLISED) return false;
        if (obj1.getLayer() == obj2.getLayer()) return false;
        return true;
    }
}
