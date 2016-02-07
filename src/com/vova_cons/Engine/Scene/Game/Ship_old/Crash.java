package com.vova_cons.Engine.Scene.Game.Ship_old;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.WindowSize;
import com.vova_cons.Engine.Object;
import com.vova_cons.Physics.Point;
import com.vova_cons.Physics.Rectangle;

public class Crash extends Object {
    private String[] sprites;

    public Crash(Element settings, String path){
        super(null, Rectangle.create(WindowSize.topLeft, 0, 0));
        String settingName = settings.sub("name").getValue();
        int size = Integer.parseInt(settings.sub("size").getValue());
        sprites = new String[size];
        for(int i = 1; i <= size; i++)
            sprites[i-1] = path + settings.sub(settingName+i).getValue();
    }

    private Crash(String[] sprites, Point point){
        super(sprites, Rectangle.create(point, 0, 0), false);
    }

    @Override
    protected void update() {
    }

    @Override
    public int getLayer() {
        return Object.SYSTEM_LAYER;
    }

    public Crash clone(Point point){
        return new Crash(sprites, point);
    }
}
