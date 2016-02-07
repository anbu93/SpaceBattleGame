package com.vova_cons.Common;

public class DeltaTimer {
    private long oldTime;

    public DeltaTimer(){
        oldTime = System.currentTimeMillis();
    }

    public long getDelta(){
        long actualTime = System.currentTimeMillis();
        long delta = actualTime - oldTime;
        oldTime = actualTime;
        return delta;
    }
}
