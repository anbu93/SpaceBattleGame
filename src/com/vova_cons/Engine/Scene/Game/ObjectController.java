package com.vova_cons.Engine.Scene.Game;

import com.vova_cons.Engine.Scene.Game.Ship.Ship;
import com.vova_cons.Engine.Scene.Game.Shot.Shot;

public interface ObjectController {
    void addShip(Ship ship);
    void removeSHip(Ship ship);
    void addShot(Shot shot);
    void removeShot(Shot shot);
}
