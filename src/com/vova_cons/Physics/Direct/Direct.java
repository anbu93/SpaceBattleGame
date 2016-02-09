package com.vova_cons.Physics.Direct;

import com.vova_cons.GlobalInterfaces.Finishable;
import com.vova_cons.Physics.Point;

public interface Direct extends Finishable {
    static Direct createOldDirect(Point finish, double speed){
        return new DirectImpl(finish, speed);
    }
    static Direct create(Point from, Point to, double speed){
        return new SampleDirect(from, to, speed);
    }

    //v1u4f1
    Point next();

    @Deprecated
    default //v1u4f1
    Point next(Point current) {
        return null;
    }

    @Deprecated //v1u4f1
    default void changeFinish(Point finish) {}

    @Deprecated
    default //v1u4f1
    void changeSpeed(double speed) {}
}
