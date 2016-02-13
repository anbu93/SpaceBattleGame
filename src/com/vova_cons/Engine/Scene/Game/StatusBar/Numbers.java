package com.vova_cons.Engine.Scene.Game.StatusBar;

import com.vova_cons.Common.DocumentParser.Element;
import com.vova_cons.Engine.Scene.Sprite;

import java.util.LinkedList;
import java.util.List;

public class Numbers {
    private List<Sprite> numbers = new LinkedList<>();

    public Numbers(Element numbersSetting){
        String path = numbersSetting.sub("path").getValue();
        for(int i = 0; i < 10; i ++)
            numbers.add(new Sprite(path + numbersSetting.sub(Integer.toString(i)).getValue()));
    }

    public Sprite get(int number){
        return numbers.get(number);
    }
}
