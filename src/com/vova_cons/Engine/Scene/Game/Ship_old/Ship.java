package com.vova_cons.Engine.Scene.Game.Ship_old;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Engine.Object;
import com.vova_cons.Engine.Scene.Game.Ship_old.Enemy.AWing;
import com.vova_cons.Engine.Scene.Game.Ship_old.Enemy.Sokol;
import com.vova_cons.Engine.Scene.Game.Ship_old.Enemy.XWing;
import com.vova_cons.Engine.Scene.Game.Ship_old.Player.Player1Ship;
import com.vova_cons.Engine.Scene.Game.Ship_old.Player.Player2Ship;
import com.vova_cons.Physics.Point;
import com.vova_cons.Physics.Rectangle;

public abstract class Ship extends Object {
    public static final String PLAYER = "player";
    public static final String PLAYER2 = "player2";
    public static final String X_WING = "Xwing";
    public static final String Y_WING = "Ywing";
    public static final String A_WING = "Awing";
    public static final String SOKOL = "Sokol";

    private static final int SHIP_SIZE = 32;
    private int layer;
    private double shipSpeed;
    private String shotImage;
    private double shotSpeed;
    private Crash crash;

    public static Ship create(Element gameSettings, Element scenarioShip){
        Point point = Point.create(scenarioShip.sub("position").getValue());
        switch(scenarioShip.sub("type").getValue()){
            case PLAYER:
                return new Player1Ship(gameSettings.sub(PLAYER), point);
            case PLAYER2:
                return new Player2Ship(gameSettings.sub(PLAYER2), point);
            case X_WING:
                return new XWing(gameSettings.sub("enemy").sub(X_WING), point);
            case Y_WING:
                return new XWing(gameSettings.sub("enemy").sub(Y_WING), point);
            case A_WING:
                return new AWing(gameSettings.sub("enemy").sub(A_WING), point);
            case SOKOL:
                return new Sokol(gameSettings.sub("enemy").sub(SOKOL), point);
            default:
                return new XWing(gameSettings.sub("enemy").sub(X_WING), point);
        }
    }

    protected Ship(Element settings, Point position) {
        super(settings.sub("path").getValue()+settings.sub("ship").getValue(),
                Rectangle.create(position, SHIP_SIZE, SHIP_SIZE));
        this.layer = Integer.parseInt(settings.sub("layer").getValue());
        this.shipSpeed = Double.parseDouble(settings.sub("speed").getValue());
        this.shotImage = settings.sub("path").getValue()+settings.sub("shot").getValue();
        this.shotSpeed = Double.parseDouble(settings.sub("shot_speed").getValue());
        this.crash = new Crash(settings.sub("crash"), settings.sub("path").getValue());
    }

    protected void fire(Point to){
        new Fire(shotImage, getCenter(), to, shotSpeed, layer);
    }

    public void goTo(Point point) {
        super.goTo(point, shipSpeed);
    }

    @Override
    public int getLayer() {
        return layer;
    }

    public Crash getCrash(){
        return crash.clone(super.getCenter());
    }
}
