package com.vova_cons.Physics;

class PointAdapter implements Point {
    protected Point point;

    protected PointAdapter(Point point){
        this.point = point;
    }

    @Override
    public double getX() {
        return point.getX();
    }

    @Override
    public double getY() {
        return point.getY();
    }

    @Override
    public Point offset(Point point) {
        return this.point.offset(point);
    }

    @Override
    public Point clone() {
        return point.clone();
    }

    @Override
    public boolean equals(Point point) {
        return this.point.equals(point);
    }
}
