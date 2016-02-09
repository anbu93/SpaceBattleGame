package com.vova_cons.Engine.Scene.Game.Ship;

import com.vova_cons.Common.WindowSize;
import com.vova_cons.Controller.Controller;
import com.vova_cons.Controller.NullController;
import com.vova_cons.Physics.Point;

public class Player extends Ship {
    private Controller controller = new PlayerController();
    private boolean isFire = false;
    private Point mousePosition = getCenter();

    public Player(String type, Point position) {
        super(type, position);
    }

    public Controller getController(){
        return controller;
    }

    @Override
    public void update(long deltaTime) {
        super.update(deltaTime);
        super.redirect(mousePosition);
        if (isFire)
            super.fire(getCenter().offset(0, WindowSize.HEIGHT));
    }

    private class PlayerController extends NullController {
        @Override
        public void leftButtonPressed() {
            isFire = true;
        }

        @Override
        public void leftButtonReleased() {
            isFire = false;
        }

        @Override
        public void mousePosition(Point position) {
            mousePosition = position;
        }
    }
}
