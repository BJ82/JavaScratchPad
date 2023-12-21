package org.DesignPattern.Composite;

public class Flat implements Residence{

    private String flatName;

    private int flatNo;

    public Flat(String flatName, int flatNo) {
        this.flatName = flatName;
        this.flatNo = flatNo;
    }

    @Override
    public String getName() {
        return this.flatName + "-->" + this.flatNo;
    }
}
