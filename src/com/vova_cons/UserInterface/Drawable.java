package com.vova_cons.UserInterface;

import com.vova_cons.Physics.Point;

import java.awt.Image;

public abstract class Drawable {
    private Image sprite;
    private static ImageBuilder imageBuilder = new ImageBuilder();

    protected Drawable(String imageName){
        sprite = imageBuilder.getImage(imageName);
    }

    public Image getImage(){
        return sprite;
    }

    public abstract Point getPosition();
}
