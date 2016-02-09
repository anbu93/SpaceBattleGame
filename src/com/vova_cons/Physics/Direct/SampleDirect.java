package com.vova_cons.Physics.Direct;

import com.vova_cons.Physics.Point;
import com.vova_cons.Physics.Vector;

class SampleDirect implements Direct {
    private Point current;
    private Point finish;
    private Vector vector;
    private double speed;
    private boolean isFinished = false;


    public SampleDirect(Point from, Point to, double speed){
        this.speed = speed;
        this.current = from;
        this.finish = to;
        this.vector = Vector.create(from, to); //regex101.com
    }

    @Override
    public Point next() {
        update();
        return current;
    }

    private void update(){
        if (!isFinished()) {
            vector = vector.subvector(speed);
            current = vector.apply(current);
            checkFinished();
        }
    }

    private void checkFinished(){
        if (current.equals(finish))
            isFinished = false;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
