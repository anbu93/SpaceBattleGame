package com.vova_cons.Engine;

import com.vova_cons.Physics.Point;
import com.vova_cons.UserInterface.Drawable;

public class Sprite extends Drawable {
    private Point point;

    public Sprite(String imageName, Point point) {
        super(imageName);
        this.point = point;
    }

    public void setPoint(Point point){
        this.point = point;
    }

    @Override
    public Point getPosition() {
        return point;
    }
}
