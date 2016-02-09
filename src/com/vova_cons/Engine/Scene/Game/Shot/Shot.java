package com.vova_cons.Engine.Scene.Game.Shot;

import com.vova_cons.Engine.Scene.Game.MoveableCollisedObject;
import com.vova_cons.Engine.Scene.Sprite;
import com.vova_cons.Physics.Point;
import com.vova_cons.Physics.Rectangle.Rectangle;

public class Shot extends MoveableCollisedObject {

    public Shot(ShotSettings settings){
        super.sprite = new Sprite(settings.getImage());
        super.speed = settings.getSpeed();
        super.rectangle = Rectangle.create(Point.create(-100,-100), settings.getWidth(), settings.getHeight());
    }
    private Shot(Shot shot){
        super.sprite = sprite.clone();
        super.speed = shot.speed;
        super.rectangle = Rectangle.create(shot.getCenter(), shot.getWidth(), shot.getHeight());
    }

    public Shot clone(){
        return new Shot(this);
    }
}
