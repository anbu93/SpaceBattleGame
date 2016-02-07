package com.vova_cons.Engine.Scene.Game.Ship_old;

import com.vova_cons.Engine.Object;
import com.vova_cons.Engine.Scene.Game.GameScene;
import com.vova_cons.Physics.Point;
import com.vova_cons.Physics.Rectangle;

public class Fire extends Object {
    int layer;
    Point to;

    public Fire(String imageName, Point from, Point to, double speed, int layer){
        super(imageName, Rectangle.create(from, 5, 5));
        this.to = to;
        super.goTo(to, speed);
        this.layer = layer;
    }

    @Override
    protected void update() {
        if (to.equals(super.getCenter()))
            GameScene.remove(this);
    }

    @Override
    public int getLayer() {
        return layer;
    }
}
