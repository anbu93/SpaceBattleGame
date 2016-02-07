package com.vova_cons.Physics;

public interface Rectangle {
    static Rectangle create(Point bottomLeft, double width, double height){
        return new RectangleImpl(bottomLeft, width, height);
    }

    Point getTopLeft();
    double getHeight();
    double getWidth();
    void update();
    void goTo(Point point, double speed);
}
