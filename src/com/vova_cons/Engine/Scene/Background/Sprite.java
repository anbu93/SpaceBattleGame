package com.vova_cons.Engine.Scene.Background;

import com.vova_cons.Common.WindowSize;
import com.vova_cons.GlobalInterfaces.Updateable;
import com.vova_cons.Physics.Direct.Direct;
import com.vova_cons.Physics.Point;
import com.vova_cons.UserInterface.Drawable;

class Sprite extends Drawable implements Updateable {
    private Point start = Point.create(0, WindowSize.HEIGHT*2);
    private Direct direct = Direct.createOldDirect(Point.create(0, 0), Background.SPEED);
    private Point point;

    public Sprite(String backgroundSprite, double y){
        super(backgroundSprite);
        point = Point.create(0, y);
    }

    @Override
    public Point getPosition() {
        return point;
    }

    @Override
    public void update(long deltaTime) {
        Point newPoint = direct.next(point);
        if (newPoint.equals(point))
            point = start;
        else
            point = newPoint;
    }
}