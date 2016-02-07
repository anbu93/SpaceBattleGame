package com.vova_cons.Physics;

class VectorImpl implements Vector {
    private Point vector;

    public VectorImpl(Point from, Point to){
        double x = to.getX() - from.getX();
        double y = to.getY() - from.getY();
        vector = Point.create(x, y);
    }
    public VectorImpl(double x, double y) {
        vector = Point.create(x, y);
    }

    @Override
    public Point apply(Point point) {
        return vector.offset(point);
    }

    @Override
    public Vector subvector(double length) {
        if (length > this.length())
            return this;
        return unlimitedSubvetor(length);
    }

    @Override
    public Vector unlimitedSubvetor(double length) {
        double koefficient = length / this.length();
        double x = koefficient * vector.getX();
        double y = koefficient * vector.getY();
        return new VectorImpl(x, y);
    }

    @Override
    public Vector offset(double x, double y) {
        return new VectorImpl(vector.getX() + x, vector.getY()+y);
    }

    private double length(){
        return Math.sqrt(vector.getX()*vector.getX() + vector.getY()*vector.getY());
    }
}