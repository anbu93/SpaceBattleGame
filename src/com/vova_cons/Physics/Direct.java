package com.vova_cons.Physics;

public interface Direct {
    static Direct create(Point finish, double speed){
        return new DirectImpl(finish, speed);
    }
    Point next(Point current);
    void changeFinish(Point finish);
    void changeSpeed(double speed);
}
