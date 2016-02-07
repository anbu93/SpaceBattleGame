package com.vova_cons.Engine.Scene.Game.Ship_old.Player;

import com.vova_cons.Controller.Controller;
import com.vova_cons.Controller.NullController;
import com.vova_cons.Physics.Point;

public class Player2Controller extends NullController {
    private Player2Ship playerShip;
    private Controller player1Controller;

    public Player2Controller(Player2Ship playerShip, Controller player1Controller){
        this.playerShip = playerShip;
        this.player1Controller = player1Controller;
    }

    private void fireOn(){
        playerShip.startFire();
    }
    private void fireOff(){
        playerShip.stopFire();
    }

    @Override
    public void pushCtrl() {
        fireOn();
    }
    @Override
    public void releaseCtrl() {
        fireOff();
    }

    @Override
    public void pushDown() {
        playerShip.goDown();
    }
    @Override
    public void releaseDown() {
        playerShip.stopDown();
    }

    @Override
    public void pushUp() {
        playerShip.goUp();
    }
    @Override
    public void releaseUp() {
        playerShip.stopUp();
    }

    @Override
    public void pushLeft() {
        playerShip.goLeft();
    }
    @Override
    public void releaseLeft() {
        playerShip.stopLeft();
    }

    @Override
    public void pushRight() {
        playerShip.goRight();
    }
    @Override
    public void releaseRight() {
        playerShip.stopRight();
    }

    ////////////////////////
    // Proxy Methods ///////
    ////////////////////////

    @Override
    public void mousePosition(Point position) {
        player1Controller.mousePosition(position);
    }

    @Override
    public void leftButtonPressed() {
        player1Controller.leftButtonPressed();
    }

    @Override
    public void leftButtonReleased() {
        player1Controller.leftButtonReleased();
    }

    @Override
    public void pushESC() {
        player1Controller.pushESC();
    }

    @Override
    public void pushSpace() {
        player1Controller.pushSpace();
    }
}

