package org.designpattern.visitor;

public interface Visitable {
    public Object accept(Visitor v);
}
