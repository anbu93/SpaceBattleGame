package com.vova_cons.Engine.Scene.Game.Ship;

import com.vova_cons.Engine.Scene.Sprite;
import com.vova_cons.Physics.Point;
import com.vova_cons.Physics.Rectangle.Rectangle;

public class ShipFabrick {
    public static final String TIE_FIGHTER = "TIE-fighter";
    public static final String TIE_BOMBER = "TIE-bomber";
    public static final String X_WING = "X-wing";
    public static final String Y_WING = "Y-wing";
    public static final String A_WING = "A-wing";
    public static final String SOKOL = "Sokol";


    public static Ship create(String type, Point position){
        Ship ship;
        ShipSettings shipSettings = new ShipSettings(type);
        Sprite shipSprite = new Sprite(shipSettings.getImage());
        Sprite crashSprites = new Sprite(shipSettings.getCrashImages());
        Sprite shotSprite = new Sprite(shipSettings.getShotSettings().getImage());
        Rectangle rectangle = Rectangle.create(position, shipSettings.getWidth(), shipSettings.getHeight());
        switch (type){
            case TIE_FIGHTER:
                ship = null;
            case TIE_BOMBER:
                ship = null;
            case X_WING:
                ship = null;
            case Y_WING:
                ship = null;
            case A_WING:
                ship = null;
            case SOKOL:
                ship = null;
            default:
                ship = null;
        }
        return ship;
    }
}
