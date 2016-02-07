package com.vova_cons.Physics;

public interface Point extends Cloneable {
    static Point create(double x, double y){
        return new PointImpl(x, y);
    }
    static Point create(String str){
        String[] values = str.split(" ");
        double x = Double.parseDouble(values[0]);
        double y = Double.parseDouble(values[1]);
        return create(x, y);
    }

    static Point getInvertYPoint(Point point, double height){
        return new InvertY(point, height);
    }

    double getX();
    double getY();
    Point offset(Point point);
    Point clone();
    boolean equals(Point point);
}
