package org.DesignPattern.Composite;

import org.Utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Society implements Residence{

    private String societyName;
    private int yrOfEstblmnt;
    private List<Residence> buildings = new ArrayList<>();
    public Society(String societyName,List<Residence> buildings,int yrOfEstblmnt) {
        this.societyName = societyName;
        this.buildings = buildings;
        this.yrOfEstblmnt = yrOfEstblmnt;
    }


    @Override
    public String getName() {

        String fullQualifiedName ="";

        for(Residence bldg : buildings){

            fullQualifiedName += preFixSocietyName(bldg.getName());
        }

        return fullQualifiedName;
    }
    private String preFixSocietyName(String bldgNameFullQualified){


        char arry [] = new char [bldgNameFullQualified.indexOf(":")+1];
        for(int i=0 ; i<=bldgNameFullQualified.indexOf(":"); i++){
            arry[i] = bldgNameFullQualified.charAt(i);
        }
        String building = String.valueOf(arry);

        String flat[] = new String[bldgNameFullQualified.length()];
        flat = bldgNameFullQualified.split(building);

        String updatedStr="";
        for(int j=0; j<flat.length; j++){
            if(flat[j] != null){
                updatedStr += this.societyName + ":" + building + flat[j] + "\n";
            }
        }

        return updatedStr;


    }
}
