package edu.chl.leep.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RadioButton;

import java.util.List;

import edu.chl.leep.model.ActivityRowModel;

/**
 * Created by Eli on 2017-06-16.
 */

interface IFileService {

    void saveActivityRowListSharedPref(Context context, List<ActivityRowModel> saveSharedList);

    List<ActivityRowModel> loadActivityRowListSharedPref(Context context);

    void putTheValuesInActivityRowList (Context context);

    void setUSER(String input);

    String getUSER();

    SharedPreferences getPrefPreviousUser(Context context);

    String getPreviousUser(Context context);

    void setPreviousUser(Context context, String input);

    String getUsername(Context context);

    String getPassword(Context context);

    String getEmail(Context context);

    String getCategory(Context context, int x);

    String getCategory1(Context context);

    String getCategory2(Context context);

    String getCategory3(Context context);

    String getQuote1(Context context);

    String getQuote2(Context context);

    String getQuote3(Context context);

    void setQuote1(Context context, String input);

    void setQuote2(Context context, String input);

    void setQuote3(Context context, String input);

    void setCategory1(Context context, String input);

    void setCategory2(Context context, String input);

    void setCategory3(Context context, String input);

    void setUsername(Context context, String input);

    void setEmail(Context context, String input);

    void setPassword(Context context, String input);

    void setKeepLoginStateToZero(Context context);

    void setKeepLoginState(Context context, RadioButton input);

    int getKeepLoginState(Context context);
}
