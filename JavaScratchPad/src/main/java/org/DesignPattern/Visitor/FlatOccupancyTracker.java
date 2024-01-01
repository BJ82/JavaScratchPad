package org.DesignPattern.Visitor;

import org.DesignPattern.Composite.Building;
import org.DesignPattern.Composite.Flat;
import org.DesignPattern.Composite.Society;

import java.util.*;

public class FlatOccupancyTracker implements Visitor{

    private Map<Society, Map<Building, Map<Flat, String>>> soctyToBldgnMap = new LinkedHashMap<>();
    public void track(Society s,Building b,Flat f,String status){

        if(soctyToBldgnMap.get(s) == null){
            Map<Flat,String> flatStatus = new LinkedHashMap<>();
            flatStatus.put(f,status);

            Map<Building,Map<Flat,String>> bldgnToFlatMap = new LinkedHashMap<>();
            bldgnToFlatMap.put(b,flatStatus);

            soctyToBldgnMap.put(s,bldgnToFlatMap);

        }
        else {
            Map<Building,Map<Flat,String>> bldgnToFlatMap = soctyToBldgnMap.get(s);
            Map<Flat,String> flatStatus = bldgnToFlatMap.get(b);
            if(flatStatus == null)
                flatStatus = new LinkedHashMap<>();
            flatStatus.put(f,status);
            bldgnToFlatMap.put(b,flatStatus);
            soctyToBldgnMap.put(s,bldgnToFlatMap);
        }
    }
    @Override
    public Object visit(Society s) {

        Set<Society> keys = new LinkedHashSet<>();
        keys =  soctyToBldgnMap.keySet();

        Set<Building> bldngKeys = new LinkedHashSet<>();
        Set<Flat> flatKeys = new LinkedHashSet<>();

        StringBuilder flatStatusInfo = new StringBuilder();
        for(Society skey:keys){
            if(skey.equals(s)){
                bldngKeys = soctyToBldgnMap.get(s).keySet();
                for(Building b:bldngKeys){
                    flatKeys = soctyToBldgnMap.get(s).get(b).keySet();
                    for(Flat f:flatKeys){
                        String status = soctyToBldgnMap.get(s).get(b).get(f);
                        flatStatusInfo.append(s.toString()).append(" ").append(b.toString()).append(" ").append(f.toString()).append(" ").append(status).append("\n");
                    }

                }
            }

        }
        return flatStatusInfo.toString();
    }

    @Override
    public Object visit(Building bldng) {
        Set<Society> keys = new LinkedHashSet<>();
        keys =  soctyToBldgnMap.keySet();

        Set<Building> bldngKeys = new LinkedHashSet<>();
        Set<Flat> flatKeys = new LinkedHashSet<>();
        StringBuilder flatStatusInfo = new StringBuilder();
        for(Society s:keys){
                bldngKeys = soctyToBldgnMap.get(s).keySet();
                for(Building b:bldngKeys){
                    if(b.equals(bldng)){
                        flatKeys = soctyToBldgnMap.get(s).get(b).keySet();
                        for(Flat f:flatKeys){
                            String status = soctyToBldgnMap.get(s).get(b).get(f);
                            flatStatusInfo.append(b.toString()).append(" ").append(f.toString()).append(" ").append(status).append("\n");
                        }
                    }
                }


        }
        return flatStatusInfo.toString();

    }
}
