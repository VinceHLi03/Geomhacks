package com.company;

public class Event {
    int priority;
    int length;
    int fStrt;
    int fEnd;

    String name;
    public Event(int prio,int l, String nm, int s, int f){
        priority = prio;
        length = l;
        name = nm;
        fStrt = s;
        fEnd = f;
    }

    public int getPrio(){
        return priority;
    }
    public int getLength(){
        return length;
    }
    public String getName(){
        return name;
    }
    public int getStart(){return fStrt;
    }
    public int getEnd(){ return fEnd;}
}
