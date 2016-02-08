package com.vova_cons.UserInterface.Image;

class AwtImage implements Image {
    private static ImageBuilder imageBuilder = new ImageBuilder();

    private java.awt.Image image;

    AwtImage(String imageName){
        image = imageBuilder.getImage(imageName);
    }

    public java.awt.Image getImage() {
        return image;
    }
}
