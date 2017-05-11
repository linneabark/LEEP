package com.example.linneabark.test;

import android.graphics.Color;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Evelina on 2017-05-05.
 */

public class Category {
    private String categoryName;
    private int color;

    public Category (String categoryName, int color) {
        this.categoryName = categoryName;
        this.color = color;
    }

    // HashSet declaration    //Hashset. för att lagra categorierna. accepterar bara en av en sort.
    public HashSet<Category> categoryList = new HashSet<Category>();




    public void addFirstCategory () {
        // Adding elements to the HashSet
        categoryList.add(new Category("Föreläsning", Color.BLUE));
        categoryList.add(new Category("Studier", Color.RED));
        categoryList.add(new Category("Lagar mat", Color.GREEN));
        categoryList.add(new Category("Serier", Color.CYAN));
        categoryList.add(new Category("Kollektivtrafik", Color.DKGRAY));
        categoryList.add(new Category("Prokastinering", Color.GRAY));
        categoryList.add(new Category("Övrigt", Color.YELLOW));
    }

    public void addCategory(Category newCateogry) {
        //Om inget namn står i rutan för att lägag till en kategori så skall det ej gå att lägga till en tom..
        /*if (textField.getText().equals("")) {
            System.out.println("Inget namn för kategorin är vald");
            errorField.setText("Inget namn för kategorin är vald");
        }
        */
        categoryList.add(newCateogry);
    }
    public String getCategoryName() {return categoryName;}

    public int getColor(){return color;}
}
