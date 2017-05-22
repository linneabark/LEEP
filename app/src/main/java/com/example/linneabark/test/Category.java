package com.example.linneabark.test;

import android.content.Context;
import android.graphics.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evelina on 2017-05-05.
 */

public class Category implements Serializable {
    private String categoryName;
    public MainActivity mA;
    List<String> categoryList = new ArrayList<>();


    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(){
        mA = new MainActivity();
        addDefaultCategories(mA.getContext());


    }

    public void getCategory(){
    }

    // HashSet declaration    //Hashset. för att lagra categorierna. accepterar bara en av en sort.
    //public HashSet<Category> categoryList = new HashSet<Category>();



    public void addDefaultCategories(Context mContext) {
        // Adding elements to the list

        categoryList.add(AccountDetails.getCategory1(mContext));
        categoryList.add(AccountDetails.getCategory2(mContext));
        categoryList.add(AccountDetails.getCategory3(mContext));

    }

    public void addCategory(String newCateogry) {
        //Om inget namn står i rutan för att lägag till en kategori så skall det ej gå att lägga till en tom..
        /*if (textField.getText().equals("")) {
            System.out.println("Inget namn för kategorin är vald");
            errorField.setText("Inget namn för kategorin är vald");
        }
        */
        categoryList.add(newCateogry);
    }

    public String getCategoryName() {
        return categoryName;
    }

}
