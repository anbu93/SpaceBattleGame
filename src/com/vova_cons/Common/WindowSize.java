package com.vova_cons.Common;

import com.vova_cons.Physics.Point;

public class WindowSize {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static Point topLeft = Point.create(0, HEIGHT);
    public static Point bottomLeft = Point.create(0, 0);
    public static Point topRight = Point.create(WIDTH, HEIGHT);
    public static Point bottomRight = Point.create(WIDTH, 0);
}
