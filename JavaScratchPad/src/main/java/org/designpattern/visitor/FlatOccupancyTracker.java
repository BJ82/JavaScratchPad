package org.designpattern.visitor;

import org.designpattern.Composite.Building;
import org.designpattern.Composite.Flat;
import org.designpattern.Composite.Society;

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

        StringBuilder flatStatusInfo = new StringBuilder();

        Set<Flat> flats;
        Set<Building> buildings;
        Set<Society> societies = soctyToBldgnMap.keySet();

        for(Society socty:societies){

            if(socty.equals(s)){
                buildings = soctyToBldgnMap.get(s).keySet();

                for(Building b:buildings){
                    flats = soctyToBldgnMap.get(s).get(b).keySet();

                    for(Flat f:flats){
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

        StringBuilder flatStatusInfo = new StringBuilder();

        Set<Flat> flats;
        Set<Building> buildings;
        Set<Society> societies;
        societies =  soctyToBldgnMap.keySet();

        for(Society socty:societies){

                buildings = soctyToBldgnMap.get(socty).keySet();

                for(Building b:buildings){
                    if(b.equals(bldng) && b == bldng){
                        flats = soctyToBldgnMap.get(socty).get(b).keySet();

                        for(Flat f:flats){
                            String status = soctyToBldgnMap.get(socty).get(b).get(f);
                            flatStatusInfo.append(b.toString()).append(" ").append(f.toString()).append(" ").append(status).append("\n");                        }
                    }

                }


        }
        return flatStatusInfo.toString();

    }
}
