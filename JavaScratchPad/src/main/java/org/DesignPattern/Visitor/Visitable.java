package org.DesignPattern.Visitor;

public interface Visitable {
    public Object accept(Visitor v);
}
