package com.vova_cons.UserInterface.InputListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.vova_cons.Common.WindowSize;
import com.vova_cons.Controller.Controller;
import com.vova_cons.Physics.Point;
import javafx.scene.input.MouseDragEvent;

import javax.swing.event.MouseInputListener;

class MouseListenerAdapter implements MouseListener, MouseMotionListener {
    private Controller controller;

    public MouseListenerAdapter(Controller controller){
        this.controller = controller;
    }

    public void changleController(Controller controller){
        this.controller = controller;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()){
            case MouseEvent.BUTTON1:
                controller.leftButtonPressed();
                break;
            case MouseEvent.BUTTON2:
                controller.rightButtonPressed();
                break;
            default: // not use
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (e.getButton()){
            case MouseEvent.BUTTON1:
                controller.leftButtonReleased();
                break;
            case MouseEvent.BUTTON2:
                controller.rightButtonReleased();
                break;
            default: // not use
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point position = Point.create(e.getX(), WindowSize.HEIGHT-e.getY());
        controller.mousePosition(position);
    }

    // Unused methods.
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {
        Point position = Point.create(e.getX(), WindowSize.HEIGHT-e.getY());
        controller.mousePosition(position);
        switch(e.getID()){
            case MouseEvent.MOUSE_PRESSED:
                controller.rightButtonPressed();
                break;
            case MouseEvent.MOUSE_RELEASED:
                controller.rightButtonReleased();
                break;
        }
    }
}
