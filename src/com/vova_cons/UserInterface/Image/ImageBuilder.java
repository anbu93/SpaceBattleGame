package com.vova_cons.UserInterface.Image;

import com.vova_cons.Common.Logger;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
            sourceImage = ImageIO.read(new File(imageName));
        } catch (Exception errorMessage) {
            Logger.get().append("ImageBuilder: ")
                    .append("error on open image: " + imageName)
                    .append(" (" + errorMessage.getMessage() + ")")
                    .endl();
        }
        return Toolkit.getDefaultToolkit().createImage(sourceImage.getSource());
    }
}
