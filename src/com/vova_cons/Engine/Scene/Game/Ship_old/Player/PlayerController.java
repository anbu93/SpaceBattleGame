package com.vova_cons.Engine.Scene.Game.Ship_old.Player;

import com.vova_cons.Controller.NullController;
import com.vova_cons.Engine.Scene.Game.GameScene;
import com.vova_cons.Physics.Point;

public class PlayerController extends NullController {
    private PlayerShip playerShip;

    public PlayerController(PlayerShip playerShip){
        this.playerShip = playerShip;
    }

    private void fireOn(){
        playerShip.startFire();
    }
    private void fireOff(){
        playerShip.stopFire();
    }
    private void goTo(Point position){
        playerShip.goTo(position.offset(Point.create(-16,16)));
    }

    @Override
    public void mousePosition(Point position) {
        goTo(position);
    }

    @Override
    public void leftButtonPressed() {
        fireOn();
    }

    @Override
    public void leftButtonReleased() {
        fireOff();
    }

    @Override
    public void pushESC() {
        GameScene.pushESC();
    }

    @Override
    public void pushSpace() {
        GameScene.pushSPACE();
    }
}
