package com.vova_cons.Physics.Rectangle;

import com.vova_cons.Physics.Point;

class SampleRectangle implements Rectangle{
    private Point center;
    private Point size;


    public SampleRectangle(Point center, double width, double height){
        this.center = center;
        this.size = Point.create(width/2, height/2);
    }

    @Override
    public Point getTopLeft() {
        return center.offset(-size.getX(), size.getY());
    }

    @Override
    public double getHeight() {
        return size.getY()*2;
    }

    @Override
    public double getWidth() {
        return size.getX()*2;
    }

    @Override
    public Point getCenter() {
        return center;
    }

    @Override
    public void setCenter(Point center) {
        this.center = center;
    }
}
