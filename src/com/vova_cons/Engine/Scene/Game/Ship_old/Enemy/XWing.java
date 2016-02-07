package com.vova_cons.Engine.Scene.Game.Ship_old.Enemy;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Physics.Point;

public class XWing extends Enemy {

    public XWing(Element enemySettings, Point position) {
        super(enemySettings, position);
        SHOT_TIME_DELTA_MIN = parse(enemySettings.sub("shot_delta_min").getValue());
        SHOT_TIME_DELTA_RANDOM = parse(enemySettings.sub("shot_delta_random").getValue());
        MOVE_TIME_DELTA = parse(enemySettings.sub("move_delta").getValue());
        SHOT_ANGLE = parse(enemySettings.sub("shot_angle").getValue());
        generateNextShotTime();
    }
}
