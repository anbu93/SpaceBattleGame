package com.vova_cons.Physics;

class DirectImpl implements Direct{
    private Point finish;
    private double speed;

    public DirectImpl(Point finish, double speed){
        this.finish = finish;
        this.speed = speed;
    }

    @Override
    public Point next(Point current) {
        if (current.equals(finish))
            return finish;
        Vector vector = Vector.create(current, finish);
        vector = vector.subvector(speed);
        return vector.apply(current);
    }

    @Override
    public void changeFinish(Point finish) {
        this.finish = finish;
    }

    @Override
    public void changeSpeed(double speed) {
        this.speed = speed;
    }
}
