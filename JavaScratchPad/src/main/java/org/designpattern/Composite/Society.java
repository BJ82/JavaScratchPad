package org.designpattern.Composite;

import org.designpattern.visitor.Visitable;
import org.designpattern.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;


public class Society implements Residence, Visitable {

    private final String societyName;
    private final int yrOfEstblmnt;
    private List<Residence> buildings = new ArrayList<>();
    public Society(String societyName,List<Residence> buildings,int yrOfEstblmnt) {
        this.societyName = societyName;
        this.buildings = buildings;
        this.yrOfEstblmnt = yrOfEstblmnt;
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


        char[] arry = new char [bldgNameFullQualified.indexOf(":")+1];
        for(int i=0 ; i<=bldgNameFullQualified.indexOf(":"); i++){
            arry[i] = bldgNameFullQualified.charAt(i);
        }
        String building = String.valueOf(arry);

        String[] flat = bldgNameFullQualified.split(building);

        StringBuilder updatedStr = new StringBuilder(this.societyName + ":" + building);
        for (String flt : flat) {
            if (flt != null) {
                updatedStr.append(flt).append("\n");
            }
        }

        return updatedStr.toString();


    }

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
