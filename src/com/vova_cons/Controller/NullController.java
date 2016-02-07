package com.vova_cons.Controller;

import com.vova_cons.Physics.Point;

public class NullController implements Controller {
    @Override
    public void pushUp() {}
    @Override
    public void releaseUp() {}
    @Override
    public void pushDown() {}
    @Override
    public void releaseDown() {}
    @Override
    public void pushLeft() {}
    @Override
    public void releaseLeft() {}
    @Override
    public void pushRight() {}
    @Override
    public void releaseRight() {}
    @Override
    public void pushSpace() {}
    @Override
    public void releaseSpace() {}
    @Override
    public void pushESC() {}
    @Override
    public void leftButtonPressed() {}
    @Override
    public void leftButtonReleased() {}
    @Override
    public void rightButtonPressed() {}
    @Override
    public void rightButtonReleased() {}
    @Override
    public void mousePosition(Point position) { }
    @Override
    public void pushCtrl() { }
    @Override
    public void releaseCtrl() {}

    @Override
    public void typedUp() {

    }

    @Override
    public void typedDown() {

    }

    @Override
    public void typedLeft() {

    }

    @Override
    public void typedRight() {

    }
}
