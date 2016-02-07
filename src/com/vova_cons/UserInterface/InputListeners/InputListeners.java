package com.vova_cons.UserInterface.InputListeners;

import com.vova_cons.Controller.Controller;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputListeners {
    private MouseListenerAdapter mouseListenerAdapter;
    private KeyListenerAdapter keyListenerAdapter;

    public InputListeners(Controller controller){
        this.mouseListenerAdapter = new MouseListenerAdapter(controller);
        this.keyListenerAdapter = new KeyListenerAdapter(controller);
    }

    public void changeController(Controller controller){
        mouseListenerAdapter.changleController(controller);
        keyListenerAdapter.changeController(controller);
    }

    public MouseListener getMouseListener(){
        return mouseListenerAdapter;
    }
    public MouseMotionListener getMouseMotionListener(){
        return mouseListenerAdapter;
    }
    public KeyListener getKeyListener(){
        return keyListenerAdapter;
    }
}
