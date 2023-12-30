package org.DesignPattern.Visitor;

import org.DesignPattern.Composite.Building;
import org.DesignPattern.Composite.Society;

import java.lang.reflect.Field;


public class TotalFlatCalc implements Visitor{

    @Override
    public int visit(Society s) {

        int totalFlats=0;
        try{
            Class soctyObj = null;
            soctyObj = Class.forName("org.DesignPattern.Composite.Society");
            Field buildings = null;
            buildings = soctyObj.getDeclaredField("buildings");
            buildings.setAccessible(true);
            java.util.List listOfBldgn = null;
            listOfBldgn = (java.util.List) buildings.get(s);
            for(Object b:listOfBldgn){
                totalFlats += visit((Building) b);
            }

        }
        catch(ClassNotFoundException | NoSuchFieldException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
        return totalFlats;
    }

    @Override
    public int visit(Building b) {

        java.util.List listOfFlats = null;
        try{
            Class bldngObj = null;
            bldngObj = Class.forName("org.DesignPattern.Composite.Building");
            Field flats = null;
            flats = bldngObj.getDeclaredField("flats");
            flats.setAccessible(true);
            listOfFlats = (java.util.List) flats.get(b);

        }
        catch(ClassNotFoundException | NoSuchFieldException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
        return listOfFlats.size();
    }
}
