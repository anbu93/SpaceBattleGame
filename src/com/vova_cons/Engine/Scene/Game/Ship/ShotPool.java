package com.vova_cons.Engine.Scene.Game.Ship;

import com.vova_cons.Engine.Scene.Game.Shot.Shot;
import com.vova_cons.Engine.Scene.Game.Shot.ShotSettings;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class ShotPool {
    private List<Shot> pool = new CopyOnWriteArrayList<>();

    ShotPool(ShotSettings settings, int shotCount){
        Shot shot = new Shot(settings);
        for(int i = 0; i < shotCount; i++)
            pool.add(shot.clone());
    }

    Shot get(){
        synchronized (pool){
            if (!pool.isEmpty()) {
                Shot result = pool.get(0);
                pool.remove(result);
                return result;
            }
        }
        return null;
    }

    void put(Shot shot){
        synchronized (pool){
            pool.add(shot);
        }
    }
}
