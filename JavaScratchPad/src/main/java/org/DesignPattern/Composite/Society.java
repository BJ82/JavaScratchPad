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

            fullQualifiedName += Utils.updateStr(bldg.getName(), this.societyName);
        }

        return fullQualifiedName;
    }
}
