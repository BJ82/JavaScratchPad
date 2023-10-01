package org.DesignPattern;

public class Singleton {
    private static final Singleton singlObj = new Singleton();
    private static int objCountr;
    private Singleton() {
        objCountr++;
    }
    public static Singleton getObject(){
        return singlObj;
    }

    public static int getCountOfObjects(){
        return objCountr;
    }
}
