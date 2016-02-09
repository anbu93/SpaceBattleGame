package com.vova_cons.UserInterface;

import com.vova_cons.Common.WindowSize;
import com.vova_cons.Controller.Controller;
import com.vova_cons.Controller.NullController;
import com.vova_cons.Physics.Point;
import com.vova_cons.UserInterface.Image.AwtImage;
import com.vova_cons.UserInterface.InputListeners.InputListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

class AwtScreen extends Canvas implements Screen {
    public static final long serialVersionUID = 1L;
    private Graphics window;
    private InputListeners inputListeners = new InputListeners(new NullController());

    public AwtScreen(String windowName, int width, int height){
        initializeAWT(windowName, width, height);
        addMouseListener(inputListeners.getMouseListener());
        addMouseMotionListener(inputListeners.getMouseMotionListener());
        addKeyListener(inputListeners.getKeyListener());
    }
    private void initializeAWT(String windowName, int width, int height){
        setPreferredSize(new Dimension(width, height));
        JFrame frame = new JFrame(windowName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void clear() {
        window = getWindow();
        window.setColor(Color.BLACK);
        window.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void draw(Drawable drawable) {
        if (window == null) clear();
        Point point = Point.getInvertYPoint(drawable.getPosition(), WindowSize.HEIGHT);
        int x = (int) point.getX();
        int y = (int) point.getY();
        window.drawImage(drawable.getImage(), x, y, null);
    }

    @Override
    public void draw(com.vova_cons.UserInterface.Image.Image image, Point topLeft) {
        if (window == null) clear();
        Point point = Point.getInvertYPoint(topLeft, WindowSize.HEIGHT);
        int x = (int) point.getX();
        int y = (int) point.getY();
        window.drawImage(((AwtImage)image).getImage(), x, y, null);
    }

    @Override
    public void flush() {
        window.dispose();
        getBufferStrategy().show();
        window = null;
    }

    @Override
    public void changeController(Controller controller) {
        inputListeners.changeController(controller);
    }

    private Graphics getWindow(){
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(2);
            requestFocus();
            return getWindow();
        }
        return bufferStrategy.getDrawGraphics();
    }
}
