package com.vova_cons.UserInterface.InputListeners;

import com.vova_cons.Controller.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class KeyListenerAdapter implements KeyListener {
    private Controller controller;

    public KeyListenerAdapter(Controller controller){
        this.controller = controller;
    }

    public void changeController(Controller controller){
        this.controller = controller;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                controller.pushUp();
                break;
            case KeyEvent.VK_DOWN:
                controller.pushDown();
                break;
            case KeyEvent.VK_LEFT:
                controller.pushLeft();
                break;
            case KeyEvent.VK_RIGHT:
                controller.pushRight();
                break;
            case KeyEvent.VK_SPACE:
                controller.pushSpace();
                break;
            case KeyEvent.VK_CONTROL:
                controller.pushCtrl();
                break;
            case KeyEvent.VK_ESCAPE:
                controller.pushESC();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                controller.releaseUp();
                break;
            case KeyEvent.VK_DOWN:
                controller.releaseDown();
                break;
            case KeyEvent.VK_LEFT:
                controller.releaseLeft();
                break;
            case KeyEvent.VK_RIGHT:
                controller.releaseRight();
                break;
            case KeyEvent.VK_CONTROL:
                controller.releaseCtrl();
                break;
            case KeyEvent.VK_SPACE:
                controller.releaseSpace();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                controller.typedUp();
                break;
            case KeyEvent.VK_DOWN:
                controller.typedDown();
                break;
            case KeyEvent.VK_LEFT:
                controller.typedLeft();
                break;
            case KeyEvent.VK_RIGHT:
                controller.typedRight();
                break;
        }
    }

}
