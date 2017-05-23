package edu.chl.leep.model;

import android.content.Context;
import android.widget.TextView;

import edu.chl.leep.service.AccountDetails;

/**
 * Created by Eli on 2017-05-23.
 */

public class TimeLogModel {

    public boolean CheckCategoryStatus(Context mContext, String cat1, String cat2, String cat3){

        if((AccountDetails.getCategory1(mContext).equals("")) && (AccountDetails.getCategory2(mContext).equals(""))
                && (AccountDetails.getCategory3(mContext).equals(""))) {

            AccountDetails.setCategory1(mContext, cat1);
            AccountDetails.setCategory2(mContext, cat2);
            AccountDetails.setCategory3(mContext, cat3);

            return true;

        }
        return false;

    }


}
