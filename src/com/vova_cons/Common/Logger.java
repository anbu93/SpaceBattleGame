package com.vova_cons.Common;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance = new Logger();
    private StringBuilder log = new StringBuilder();
    private boolean isNewLine = true;
    private long startTime = System.currentTimeMillis();

    public static Logger get(){
        return instance;
    }
    public Logger append(String msg){
        if (isNewLine) addTime();
        log.append(msg);
        return this;
    }
    public Logger endl(){
        isNewLine = true;
        log.append(" \n");
        return this;
    }
    public String getLog(){
        return log.toString();
    }

    private void addTime(){
        log.append(getTime());
        isNewLine = false;
    }

    private String getTime(){
        long time = System.currentTimeMillis() - startTime;
        return time/1000 + "." + time%1000 + "> ";
    }

    public void save(){
        try {
            FileWriter writer = new FileWriter("log.txt");
            writer.write(getLog());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("can't save log file on log.txt!");
        }

    }
}
