package com.vova_cons.Physics;

class RectangleImpl implements Rectangle{
    private Point bottomLeft;
    private Point size;
    private Direct direct;

    public RectangleImpl(Point bottomLeft, double width, double height){
        this.bottomLeft = bottomLeft;
        this.size = Point.create(width, height);
        direct = Direct.create(bottomLeft, 0.01);
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
    public void update() {
        bottomLeft = direct.next(bottomLeft);
    }

    @Override
    public void goTo(Point point, double speed) {
        direct.changeFinish(point);
        direct.changeSpeed(speed);
    }
}
