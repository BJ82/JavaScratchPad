package org.designpattern.Composite;

import org.designpattern.visitor.Visitable;
import org.designpattern.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;


public class Society implements Residence, Visitable {

    private final String societyName;
    private List<Residence> buildings = new ArrayList<>();
    public Society(String societyName,List<Residence> buildings) {
        this.societyName = societyName;
        this.buildings = buildings;
    }

    public int getTotalNoOfBuildings(){return buildings.size();}

    @Override
    public String toString() {
        return "societyName:" + societyName;

    }

    @Override
    public String getName() {

        StringBuilder fullQualifiedName = new StringBuilder();

        for(Residence bldg : buildings){

            fullQualifiedName.append(preFixSocietyName(bldg.getName()));
        }

        return fullQualifiedName.toString();
    }
    private String preFixSocietyName(String bldgNameFullQualified){

        String building  = getBuildingName(bldgNameFullQualified);

        String[] flats = bldgNameFullQualified.split(building);

        StringBuilder updatedStr = new StringBuilder(this.societyName + ":" + building);
        for (String flt : flats) {
            if (flt != null) {
                updatedStr.append(flt).append("\n");
            }
        }

        return updatedStr.toString();


    }
    private String getBuildingName(String bldgNameFullQualified){

        StringBuilder bldgName = new StringBuilder();
        for(int i=0 ; i<=bldgNameFullQualified.indexOf(":"); i++){
            bldgName.append(bldgNameFullQualified.charAt(i));
        }
        return bldgName.toString();
    }
    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
