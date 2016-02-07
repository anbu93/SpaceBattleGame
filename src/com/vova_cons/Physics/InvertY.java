package com.vova_cons.Physics;

class InvertY extends PointAdapter {
    private double height;

    public InvertY(Point point, double height) {
        super(point);
        this.height = height;
    }

    @Override
    public double getY() {
        return height - super.getY();
    }
}
