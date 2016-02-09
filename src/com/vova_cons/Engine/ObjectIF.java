package com.vova_cons.Engine;

import com.vova_cons.GlobalInterfaces.Updateable;
import com.vova_cons.Physics.Point;
import com.vova_cons.UserInterface.Screen;

public interface ObjectIF extends Updateable {
    public static final int PLAYER_LAYER = 1;
    public static final int ENEMY_LAYER = 2;
    public static final int SYSTEM_LAYER = 3;

    Point getTopLeft();
    Point getCenter();
    void render(Screen screen);
    int getLayer();
    double getWidth();
    double getHeight();
}
