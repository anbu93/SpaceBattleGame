package com.vova_cons.Controller;

import com.vova_cons.Physics.Point;

public interface Controller {
    void pushUp();
    void releaseUp();
    void pushDown();
    void releaseDown();
    void pushLeft();
    void releaseLeft();
    void pushRight();
    void releaseRight();
    void pushSpace();
    void releaseSpace();
    void pushESC();
    void leftButtonPressed();
    void leftButtonReleased();
    void rightButtonPressed();
    void rightButtonReleased();
    void mousePosition(Point position);
    void pushCtrl();
    void releaseCtrl();


    void typedUp();
    void typedDown();
    void typedLeft();
    void typedRight();
}
