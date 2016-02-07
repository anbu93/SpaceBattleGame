package com.vova_cons.Engine.Scene.Game.Ship_old.Player;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Engine.Scene.Game.GameScene;
import com.vova_cons.Physics.Point;
import com.vova_cons.Physics.Vector;

public class Player2Ship extends PlayerShip {
    private double speed;
    private Vector vector;
    private Point direct;

    public Player2Ship(Element settings, Point position) {
        super(settings, position, 2);
        controller = new Player2Controller(this, GameScene.getPlayer().getController());
        speed = Double.parseDouble(settings.sub("speed").getValue())+40;
        vector = Vector.create(0, 0);
        direct = Point.create(0, 0);
        GameScene.addPlayerShip(this);
    }


    @Override
    protected void update() {
        super.update();
        move();
    }

    private void move(){
        vector = vector.offset(direct.getX()*speed, direct.getY()*speed);
        goTo(vector.apply(getTopLeft()));
    }

    void goUp(){
        goTo(getTopLeft().offset(Point.create(0, speed)));
        vector.offset(0, 1);
    }
    void stopUp(){
        goTo(getTopLeft());
        direct.offset(Point.create(0, -1));
    }

    void goDown(){
        goTo(getTopLeft().offset(Point.create(0, -speed)));
        direct.offset(Point.create(0, -1));
    }
    void stopDown(){
        goTo(getTopLeft());
        direct.offset(Point.create(0, 1));
    }
    void goLeft(){
        goTo(getTopLeft().offset(Point.create(-speed, 0)));
        direct.offset(Point.create(-1, 0));
    }
    void stopLeft(){
        goTo(getTopLeft());
        direct.offset(Point.create(1, 0));
    }

    void goRight(){
        goTo(getTopLeft().offset(Point.create(speed, 0)));
        direct.offset(Point.create(1, 0));
    }
    void stopRight(){
        goTo(getTopLeft());
        direct.offset(Point.create(-1, 0));
    }
}
