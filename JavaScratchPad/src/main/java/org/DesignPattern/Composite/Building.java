package org.DesignPattern.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Building implements Residence{

    private String buildingName;
    private int yrOfConstruction;
    private List<Residence> flats = new ArrayList<>();
    public Building(String buildingName,List<Residence> flats,int yrOfConstruction) {
        this.buildingName = buildingName;
        this.flats = flats;
        this.yrOfConstruction = yrOfConstruction;
    }

    @Override
    public String getName() {

        String fullQualifiedName ="";

        for(Residence flt : flats){

            fullQualifiedName += this.buildingName + ":" + flt.getName();
        }

        return fullQualifiedName;
    }

    public int getTotalNoOfFlats(){
        return flats.size();
    }
}
