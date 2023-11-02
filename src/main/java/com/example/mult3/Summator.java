package com.example.mult3;

import javafx.beans.property.SimpleIntegerProperty;

public class Summator extends Thread{
    SimpleIntegerProperty val;
    int step;
    int interval;
    int kolvo;

    @Override
    public void run() {
        try {
            for (int i = 0; i < kolvo; i++) {
                sleep(interval);
                val.set(val.get() + step);
            }
        }catch (InterruptedException e){}
    }

    public Summator(SimpleIntegerProperty val, int step, int interval, int kolvo) {
        this.val = val;
        this.step = step;
        this.interval = interval;
        this.kolvo = kolvo;
    }
}
