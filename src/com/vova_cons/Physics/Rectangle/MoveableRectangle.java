package com.vova_cons.Physics.Rectangle;

import com.vova_cons.Physics.Direct.Direct;
import com.vova_cons.Physics.Point;

class MoveableRectangle implements Rectangle{
    private Point bottomLeft;
    private Point size;
    private Direct direct;

    public MoveableRectangle(Point bottomLeft, double width, double height){
        this.bottomLeft = bottomLeft;
        this.size = Point.create(width, height);
        direct = Direct.createOldDirect(bottomLeft, 0.01);
    }

    @Override
    public Point getTopLeft() {
        return bottomLeft;
    }

    @Override
    public double getHeight() {
        return size.getY();
    }

    @Override
    public double getWidth() {
        return size.getX();
    }

    @Override
    public Point getCenter() {
        return null;
    }

    @Override //do not suppoted this method
    public void setCenter(Point center) {}

    @Override
    public void update() {
        bottomLeft = direct.next(bottomLeft);
    }

    @Override
    public void goTo(Point point, double speed) {
        direct.changeFinish(point);
        direct.changeSpeed(speed);
    }
}
