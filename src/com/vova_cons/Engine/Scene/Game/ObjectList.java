package com.vova_cons.Engine.Scene.Game;

import com.vova_cons.Engine.Object;
import com.vova_cons.Engine.ObjectIF;
import com.vova_cons.UserInterface.Screen;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObjectList {
    private List<ObjectIF> objects = new CopyOnWriteArrayList<>();

    public void add(ObjectIF obj){
        synchronized (objects){
            objects.add(obj);
        }
    }
    public void remove(ObjectIF obj){
        synchronized (objects){
            objects.remove(obj);
        }
    }
    public List<ObjectIF> get(){
        return objects;
    }

    public void update(){
        synchronized (objects){
            for(ObjectIF obj : objects)
                obj.update(0);
        }
    }

    public void render(Screen screen){
        synchronized (objects){
            for(ObjectIF obj : objects) {
                obj.render(screen);
            }
        }
    }

    public void clear() {
        synchronized (objects){
            objects.clear();
        }
    }
}
