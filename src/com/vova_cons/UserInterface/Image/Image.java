package com.vova_cons.UserInterface.Image;


public interface Image {
    static Image create(String imageName){
        return new AwtImage(imageName);
    }
}
