package com.example.linneabark.test.unused;

import android.graphics.Color;

import java.util.HashMap;

/**
 * Created by Eli on 2017-05-11.
 */

public class CategoryHashMap {


    private HashMap<Integer, String> nameMap = new HashMap<Integer, String>();

    {
        nameMap.put(0, "Linjär algebra");
        nameMap.put(1, "Träning");
        nameMap.put(2, "Grundläggande programmering");
        nameMap.put(3, "Objektorienterad programmering");
        nameMap.put(4, "Prokrastinering");
        nameMap.put(5, "Lunch");
    }

    private HashMap<Integer, Integer> colorMap = new HashMap<Integer, Integer>();

    {
        colorMap.put(0, Color.BLUE);
        colorMap.put(1, Color.CYAN);
        colorMap.put(2, Color.GREEN);
        colorMap.put(3, Color.MAGENTA);
        colorMap.put(4, Color.BLACK);
        colorMap.put(5, Color.YELLOW);
    }


    public String getName(int x) {
        String y = nameMap.get(x);
        System.out.println("Name of category???: " + y);
        return y;
    }

    public int getColor(int x) {
        int y = colorMap.get(x);
        return y;
    }


}

