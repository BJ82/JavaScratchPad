package org.designpattern.visitor;

import org.designpattern.Composite.Building;
import org.designpattern.Composite.Flat;
import org.designpattern.Composite.Society;

import java.lang.reflect.Field;


public class TotalFlatCalc implements Visitor{

    @Override
    public Object visit(Society s) {

        int totalFlats=0;
        try{
            Class<?> soctyObj = Class.forName("org.designpattern.Composite.Society");
            Field buildings = soctyObj.getDeclaredField("buildings");
            buildings.setAccessible(true);
            java.util.List<Building> listOfBldgn = (java.util.List) buildings.get(s);
            for(Building b:listOfBldgn){
                totalFlats += (int)visit(b);
            }

        }
        catch(ClassNotFoundException | NoSuchFieldException | IllegalAccessException e){
            System.out.println(e.getMessage());
        }
        return totalFlats;
    }

    @Override
    public Object visit(Building b) {

        java.util.List<Flat> listOfFlats = null;
        try{
            Class<?> bldngObj = null;
            bldngObj = Class.forName("org.designpattern.Composite.Building");
            Field flats = null;
            flats = bldngObj.getDeclaredField("flats");
            flats.setAccessible(true);
            listOfFlats = (java.util.List) flats.get(b);
            return listOfFlats.size();

        }
        catch(ClassNotFoundException | NoSuchFieldException | IllegalAccessException e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}
