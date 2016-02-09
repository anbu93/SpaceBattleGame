package com.vova_cons.Engine.Scene.Game.Ship;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Common.DocumentParser.Parser;
import com.vova_cons.Engine.Scene.Game.Shot.ShotSettings;

import java.util.LinkedList;
import java.util.List;

class ShipSettings {
    private static Element shipsSettingsFile;
    private static final String defaultShipsSettingsFileName = "settings/ships.settings";

    private String path;
    private String image;
    private double width;
    private double height;
    private double speed;
    private List<String> crashImages;
    private ShotSettings shotSettings;
    private int shotCount;

    public static void setInitialShipsSettingsFile(String fileName){
        shipsSettingsFile = Parser.parse(fileName);
    }

    ShipSettings(String shipType){
        if (shipsSettingsFile == null)
            ShipSettings.setInitialShipsSettingsFile(ShipSettings.defaultShipsSettingsFileName);
        Element shipSettingFile = shipsSettingsFile.sub(shipType);
        path = shipSettingFile.sub("path").getValue();
        parseShipSettings(shipSettingFile.sub("ship"));
        this.shotSettings = new ShotSettings(shipSettingFile.sub("shot"));
        this.shotCount = Integer.parseInt(shipSettingFile.sub("shot_count").getValue());
    }

    private void parseShipSettings(Element shipSettingsFile) {
        image = shipSettingsFile.sub("image").getValue();
        parseSize(shipSettingsFile.sub("size").getValue());
        this.speed = parse(shipSettingsFile.sub("speed").getValue());
        parseCrashImages(shipSettingsFile.sub("crash"));
    }

    private void parseSize(String sizeString) {
        String[] values = sizeString.split(" ");
        width = parse(values[0]);
        height = parse(values[1]);
    }

    private void parseCrashImages(Element crashSettingFile) {
        int size = Integer.parseInt(crashSettingFile.sub("size").getValue());
        String nameLast = ".png";
        String name = crashSettingFile.sub("name").getValue();
        crashImages = new LinkedList<>();
        for(int i = 1; i <= size; i ++)
            crashImages.add(name + i + nameLast);
    }

    private double parse(String includeDoubleValueString){
        return Double.parseDouble(includeDoubleValueString);
    }

    String getImage(){
        return path+image;
    }
    double getWidth(){
        return width;
    }
    double getHeight(){
        return height;
    }
    double getSpeed(){
        return speed;
    }
    List<String> getCrashImages(){
        return crashImages;
    }
    ShotSettings getShotSettings(){
        return shotSettings;
    }
    int getShotCount(){
        return shotCount;
    }
}
