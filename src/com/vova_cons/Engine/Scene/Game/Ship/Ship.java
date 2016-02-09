package com.vova_cons.Engine.Scene.Game.Ship;

import com.vova_cons.Engine.Scene.Game.MoveableCollisedObject;
import com.vova_cons.Engine.Scene.Game.Shot.Shot;
import com.vova_cons.Engine.Scene.Sprite;
import com.vova_cons.Physics.Point;
import com.vova_cons.Physics.Rectangle.Rectangle;

public abstract class Ship extends MoveableCollisedObject {
    private Sprite shipSprite;
    private Sprite crashSprite;
    private ShotPool shotPool;

    protected Ship(String type, Point position){
        ShipSettings settings = new ShipSettings(type);
        shipSprite = new Sprite(settings.getImage());
        crashSprite = new Sprite(settings.getCrashImages());
        rectangle = Rectangle.create(position, settings.getWidth(), settings.getHeight());
        this.speed = settings.getSpeed();
        redirect(rectangle.getCenter());
        this.shotPool = new ShotPool(settings.getShotSettings(), settings.getShotCount());
        this.sprite = shipSprite;
    }

    public void fire(Point to){
        Shot shot = shotPool.get();
        if (shot == null) return;
        shot.redirect(to);
    }
}
