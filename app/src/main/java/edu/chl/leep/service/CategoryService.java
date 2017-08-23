package edu.chl.leep.service;

import edu.chl.leep.model.Category;
import edu.chl.leep.model.LeepModel;

/**
 * Created by linneabark on 2017-08-22.
 */

public class CategoryService {

    private Category cat = new Category();

    public void checkCategoryStatus() {
        if ((LeepModel.getCategory1().equals("")) && (LeepModel.getCategory2().equals(""))
                && (LeepModel.getCategory3().equals(""))) {

            LeepModel.setCategory1(cat.getCategory1());
            LeepModel.setCategory2(cat.getCategory2());
            LeepModel.setCategory3(cat.getCategory3());
        }
    }
}
