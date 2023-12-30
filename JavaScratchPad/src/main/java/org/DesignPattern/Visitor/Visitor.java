package org.DesignPattern.Visitor;

import org.DesignPattern.Composite.Building;
import org.DesignPattern.Composite.Residence;
import org.DesignPattern.Composite.Society;

public interface Visitor {
    public int visit(Society s);
    public int visit(Building b);
}
