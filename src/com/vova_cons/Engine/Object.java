package com.vova_cons.Engine;

import com.vova_cons.Engine.Scene.Game.GameScene;
import com.vova_cons.Physics.Point;
import com.vova_cons.Physics.Rectangle.Rectangle;
import com.vova_cons.UserInterface.Drawable;
import com.vova_cons.UserInterface.Screen;

public abstract class Object implements ObjectIF {
    private Rectangle rectangle;
    private Drawable[] drawable;
    private int drawableIterator;
    private boolean isLoop;
    private boolean isSystem;

    protected Object(String imageName, Rectangle rectange){
        this.rectangle = rectange;
        this.isSystem = (imageName == null);
        if(isSystem) return;
        drawable = new Drawable[1];
        this.drawableIterator = 0;
        this.isLoop = true;
        this.isSystem = false;
        drawable[0] = new Drawable(imageName) {
            @Override
            public Point getPosition() {
                return rectange.getTopLeft();
            }
        };
        GameScene.add(this);
    }
    protected Object(String[] sprites, Rectangle rectangle, boolean isLoop){
        this.rectangle = rectangle;
        drawableIterator = 0;
        drawable = new Drawable[sprites.length];
        this.isLoop = isLoop;
        for(int i = 0; i < sprites.length; i++)
            drawable[i] = new Drawable(sprites[i]) {
                @Override
                public Point getPosition() {
                    return rectangle.getTopLeft();
                }
            };
        GameScene.add(this);
    }

    public Point getTopLeft() {
        return rectangle.getTopLeft();
    }

    @Override
    public void update(long deltaTime) {
        if(isSystem) return;
        rectangle.update();
        drawableIterator++;
        if (drawableIterator >= drawable.length){
            if (isLoop)
                drawableIterator = 0;
            else
                GameScene.remove(this);
        }
        update();
    }

    protected void goTo(Point point, double speed){
        rectangle.goTo(point, speed);
    }

    public Point getCenter(){
        Point offsetPoint = Point.create(rectangle.getWidth()/2, -rectangle.getHeight()/2);
        return rectangle.getTopLeft().offset(offsetPoint);
    }

    public void render(Screen screen){
        if (!isSystem && drawableIterator < drawable.length)
            screen.draw(drawable[drawableIterator]);
    }

    protected abstract void update();
    public abstract int getLayer();

    public double getWidth(){
        return rectangle.getWidth();
    }
    public double getHeight(){
        return rectangle.getHeight();
    }
}
