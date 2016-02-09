package com.vova_cons.Engine.Scene.Game.Shot;

import com.vova_cons.Common.DocumentParser.Element;

public class ShotSettings {
    private String image;
    private double width;
    private double height;
    private double speed;


    public ShotSettings(Element shotSettingFile) {
        this.image = shotSettingFile.sub("image").getValue();
        parseSize(shotSettingFile.sub("size").getValue());
        this.speed = Double.parseDouble(shotSettingFile.sub("speed").getValue());
    }

    private void parseSize(String sizeString) {
        String[] values = sizeString.split(" ");
        this.width = Double.parseDouble(values[0]);
        this.height = Double.parseDouble(values[1]);
    }

    public String getImage(){
        return image;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public double getSpeed(){
        return speed;
    }
}
