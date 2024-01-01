package org.DesignPattern.Composite;

import org.DesignPattern.Visitor.Visitable;
import org.DesignPattern.Visitor.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Building implements Residence, Visitable {

    private String buildingName;
    private int yrOfConstruction;

    @Override
    public String toString() {
        return
                "buildingName:" + buildingName;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return yrOfConstruction == building.yrOfConstruction && buildingName.equals(building.buildingName) && flats.equals(building.flats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildingName, yrOfConstruction, flats);
    }

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

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
