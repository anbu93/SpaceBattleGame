package com.vova_cons.Engine.Scene;

import com.vova_cons.GlobalInterfaces.Drawable;
import com.vova_cons.GlobalInterfaces.Finishable;
import com.vova_cons.Physics.Point;
import com.vova_cons.UserInterface.Image.Image;
import com.vova_cons.UserInterface.Screen;

import java.util.LinkedList;
import java.util.List;

public class Sprite implements Drawable, Finishable {
    private List<Image> images = new LinkedList<>();
    private int iterator = 0;
    private boolean isFinished = false;

    public Sprite(String imageName){
        images.add(Image.create(imageName));
    }

    public Sprite(List<String> imageNameList){
        for(String imageName : imageNameList)
            images.add(Image.create(imageName));
    }
    private Sprite(Sprite sprite){
        this.images = sprite.images;
        this.iterator = 0;
        this.isFinished = false;
    }

    @Override
    public void draw(Screen screen, Point topLeft) {
        screen.draw(images.get(iterator), topLeft);
        updateIterator();
    }

    private void updateIterator(){
        iterator++;
        if (iterator == images.size()) {
            iterator = 0;
            isFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    public Sprite clone(){
        return new Sprite(this);
    }
}
