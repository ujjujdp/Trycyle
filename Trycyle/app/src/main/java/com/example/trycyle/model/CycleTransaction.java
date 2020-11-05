package com.example.trycyle.model;

public class CycleTransaction {

    
    Cycle c;
    String Uid;
    int rate;


    long time;


    public CycleTransaction(Cycle c, String uid, int rate,long time) {
        this.c = c;
        Uid = uid;
        this.rate = rate;
        this.time=time;

    }

    public Cycle getC() {
        return c;
    }

    public long getTime() {
        return time;
    }


    public String getUid() {
        return Uid;
    }


    public int getRate() {
        return rate;
    }

    public int get_fair(int rate,long time){return (int) (rate*time);}
}
