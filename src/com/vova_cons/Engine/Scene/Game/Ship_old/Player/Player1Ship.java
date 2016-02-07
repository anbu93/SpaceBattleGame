package com.vova_cons.Engine.Scene.Game.Ship_old.Player;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Engine.Scene.Game.GameScene;
import com.vova_cons.Physics.Point;

public class Player1Ship extends PlayerShip {
    public Player1Ship(Element settings, Point position) {
        super(settings, position, 1);
        super.controller = new PlayerController(this);
        System.out.println("created player 1");
        GameScene.addPlayerShip(this);
    }
}
