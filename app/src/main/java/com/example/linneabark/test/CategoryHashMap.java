package com.example.linneabark.test;

import android.graphics.Color;

import java.util.HashMap;

/**
 * Created by Eli on 2017-05-11.
 */

public class CategoryHashMap {

    private HashMap<Integer, String> nameMap = new HashMap<Integer, String>();

    {
        nameMap.put(0, "Matte");
        nameMap.put(1, "Föreläsning");
    }

    private HashMap<Integer, Integer> colorMap = new HashMap<Integer, Integer>();

    {
        colorMap.put(0, Color.BLUE);
        colorMap.put(1, Color.CYAN);
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

