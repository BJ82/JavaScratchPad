package org.DesignPattern.Visitor;

import org.DesignPattern.Composite.Building;
import org.DesignPattern.Composite.Flat;
import org.DesignPattern.Composite.Society;

import java.util.HashMap;
import java.util.Map;

public class FlatOccupancyTracker implements Visitor{

    private Map<Society, Map<Building, Map<Flat, String>>> soctyToBldgnMap = new HashMap<>();
    public void track(Society s,Building b,Flat f,String status){

        if(soctyToBldgnMap.get(s) == null){
            Map<Flat,String> flatStatus = new HashMap<>();
            flatStatus.put(f,status);

            Map<Building,Map<Flat,String>> bldgnToFlatMap = new HashMap<>();
            bldgnToFlatMap.put(b,flatStatus);

            soctyToBldgnMap.put(s,bldgnToFlatMap);

        }
        else {
            Map<Building,Map<Flat,String>> bldgnToFlatMap = soctyToBldgnMap.get(s);;
            Map<Flat,String> flatStatus = bldgnToFlatMap.get(b);
            flatStatus.put(f,status);
        }
    }
    @Override
    public Object visit(Society s) {

        String soctyName = s.toString();
        soctyToBldgnMap.get(s).forEach((b,map)->soctyName + visit(b)) + "\n";

        for()
    }

    @Override
    public Object visit(Building b) {
        String s;


    }
}
