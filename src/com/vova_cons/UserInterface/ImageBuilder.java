package com.vova_cons.UserInterface;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.Image;

class ImageBuilder {
    private Map<String, Image> imageMap = new HashMap<>();

    public Image getImage(String imageName){
        if (imageMap.containsKey(imageName))
            return imageMap.get(imageName);
        Image image = this.create(imageName);
        imageMap.put(imageName, image);
        return image;
    }

    private Image create(String imageName){
        BufferedImage sourceImage = null;
        try {
            sourceImage = ImageIO.read(new File("sprites/"+imageName));
        } catch (IOException errorMessage) {
            errorMessage.printStackTrace();
            System.out.println("ERROR on open image " + imageName + "\nerror: " + errorMessage.getMessage());
            System.exit(1);
        } catch (IllegalArgumentException openError){
            openError.printStackTrace();
            System.out.println("Not find image: " + imageName + "\nerror: " + openError.getMessage());
            System.exit(1);
        }
        return Toolkit.getDefaultToolkit().createImage(sourceImage.getSource());
    }
}
