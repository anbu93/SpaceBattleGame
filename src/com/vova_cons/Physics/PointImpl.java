package com.vova_cons.Physics;

class PointImpl implements Point {
    private static final double EQUALS_EPS = 0.1;
    private double x;
    private double y;

    public PointImpl(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public Point offset(Point point) {
        return new PointImpl(x + point.getX(), y + point.getY());
    }

    @Override
    public Point clone() {
        return new PointImpl(x, y);
    }

    @Override
    public boolean equals(Point point) {
        return  equals(x, point.getX(), EQUALS_EPS) && equals(y, point.getY(), EQUALS_EPS);
    }

    @Override
    public Point offset(double x, double y) {
        return this.offset(new PointImpl(x, y));
    }

    private boolean equals(double a, double b, double eps){
        return Math.abs(a-b) <= eps;
    }
}
