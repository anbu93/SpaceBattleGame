package com.vova_cons.UserInterface;

import com.vova_cons.Common.WindowSize;
import com.vova_cons.Controller.Controller;
import com.vova_cons.Physics.Point;
import com.vova_cons.UserInterface.Image.Image;

public interface Screen {
    static Screen createAwtScreen(){
        return new AwtScreen("Space Battle", WindowSize.WIDTH, WindowSize.HEIGHT);
    }
    void clear();
    void draw(Drawable sprite);
    void draw(Image image, Point topLeft);
    void flush();
    void changeController(Controller controller);
}
