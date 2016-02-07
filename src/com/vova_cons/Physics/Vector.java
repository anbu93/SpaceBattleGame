package com.vova_cons.Physics;

public interface Vector {
    static Vector create(Point from, Point to){
        return new VectorImpl(from, to);
    }
    static Vector create(double x, double y){
        return new VectorImpl(x, y);
    }
    Point apply(Point point);
    Vector subvector(double length);
    Vector unlimitedSubvetor(double lenght);

    Vector offset(double x, double y);
}
