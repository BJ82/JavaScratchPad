package org.designpattern.visitor;

import org.designpattern.Composite.Building;
import org.designpattern.Composite.Society;

public interface Visitor {
    public Object visit(Society s);
    public Object visit(Building b);
}
