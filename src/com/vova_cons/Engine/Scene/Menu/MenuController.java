package com.vova_cons.Engine.Scene.Menu;

import com.vova_cons.Controller.NullController;
import com.vova_cons.Physics.Point;

public class MenuController extends NullController {
    MenuScene menu;
    Point point;

    public MenuController(MenuScene menuScene) {
        menu = menuScene;
    }

    @Override
    public void mousePosition(Point position) {
        point = position;
    }

    @Override
    public void leftButtonPressed() {
        menu.clickOn(point);
    }
}
