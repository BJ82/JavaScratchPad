package org.DesignPattern.Visitor;

import org.DesignPattern.Composite.Building;
import org.DesignPattern.Composite.Residence;
import org.DesignPattern.Composite.Society;

public interface Visitor {
    public Object visit(Society s);
    public Object visit(Building b);
}
