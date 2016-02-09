package com.vova_cons.Physics.Rectangle;

import com.vova_cons.Physics.Point;

public interface Rectangle {
    static Rectangle createMoveable(Point bottomLeft, double width, double height){
        return new MoveableRectangle(bottomLeft, width, height);
    }
    static Rectangle create(Point center, double width, double height){
        return new SampleRectangle(center, width, height);
    }

    Point getTopLeft();
    double getHeight();
    double getWidth();
    Point getCenter();
    void setCenter(Point center);

    @Deprecated
    default //v1u4f1
    void update() {}

    @Deprecated
    default //v1u4f1
    void goTo(Point point, double speed) {}
}
