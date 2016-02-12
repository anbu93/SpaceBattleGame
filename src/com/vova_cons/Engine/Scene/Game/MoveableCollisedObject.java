package com.vova_cons.Engine.Scene.Game;

import com.vova_cons.Engine.ObjectIF;
import com.vova_cons.Engine.Scene.Sprite;
import com.vova_cons.GlobalInterfaces.Collisionable;
import com.vova_cons.GlobalInterfaces.Finishable;
import com.vova_cons.GlobalInterfaces.Updateable;
import com.vova_cons.Physics.Direct.Direct;
import com.vova_cons.Physics.Point;
import com.vova_cons.Physics.Rectangle.Rectangle;
import com.vova_cons.UserInterface.Screen;

public class MoveableCollisedObject implements Updateable, ObjectIF, Finishable {
    protected Rectangle rectangle = null;
    protected Sprite sprite = null;
    protected Direct direct = null;
    protected double speed = 0;

    @Override
    public Point getCenter() {
        return rectangle.getTopLeft().offset(getWidth()/2, -getHeight()/2);
    }

    @Override
    public void render(Screen screen) {
        sprite.draw(screen, getTopLeft());
    }

    @Override
    public double getWidth() {
        return rectangle.getWidth();
    }

    @Override
    public double getHeight() {
        return rectangle.getHeight();
    }

    @Override
    public int getLayer() {
        return Collisionable.NOT_COLLISED;
    }

    @Override
    public void update(long deltaTime) {
        Point newCenter = direct.next();
        rectangle.setCenter(newCenter);
    }

    public void redirect(Point to){
        this.direct = Direct.create(rectangle.getCenter(), to, speed);
    }

    public Point getTopLeft() {
        return rectangle.getTopLeft();
    }

    @Override
    public boolean isFinished() {
        return sprite.isFinished() && direct.isFinished();
    }
}
