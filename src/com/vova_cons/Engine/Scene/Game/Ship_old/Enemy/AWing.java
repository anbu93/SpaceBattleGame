package com.vova_cons.Engine.Scene.Game.Ship_old.Enemy;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.WindowSize;
import com.vova_cons.Engine.Scene.Game.GameScene;
import com.vova_cons.Physics.Point;
import com.vova_cons.Physics.Vector;

public class AWing extends Enemy {
    private int shotCounter = 0;
    private static final int MAX_SHOTS = 3;

    public AWing(Element enemySettings, Point position) {
        super(enemySettings, position);
        SHOT_TIME_DELTA_MIN = parse(enemySettings.sub("shot_delta_min").getValue());
        SHOT_TIME_DELTA_RANDOM = parse(enemySettings.sub("shot_delta_random").getValue());
        MOVE_TIME_DELTA = parse(enemySettings.sub("move_delta").getValue());
        SHOT_ANGLE = parse(enemySettings.sub("shot_angle").getValue());
        generateNextShotTime();
    }

    @Override
    protected void fire() {
        if (shotCounter < MAX_SHOTS)
            oneFire();
        else {
            shotCounter = 0;
            super.stopFire();
        }
    }

    private void oneFire(){
        Point to = GameScene.getPlayer().getCenter().offset(Point.create(Math.random()*SHOT_ANGLE - SHOT_ANGLE/2, 0));
        to = Vector.create(getCenter(), to).unlimitedSubvetor(WindowSize.HEIGHT*2).apply(to);
        super.fire(to);
        shotCounter++;
    }
}
