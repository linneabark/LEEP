package edu.chl.leep.ctrl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.linneabark.test.R;

/**
 * Created by linneabark on 2017-05-22.
 */

public class PopUpCategory extends Fragment {
    //TODO PopUpCategoryCtrl
    MainActivity mA = new MainActivity();

    Context mcontext;

    public PopUpCategory (){

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mcontext = getActivity();

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(mcontext);
        LayoutInflater inf = getActivity().getLayoutInflater();

        View categoryLayout =  inf.inflate(R.layout.pop_up_category, null);


        helpBuilder.setView(categoryLayout);

        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();

        return categoryLayout;
    }

    /*
    public void showPopUpCategory(){
        System.out.println("Context: " + mA.getContext());

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View categoryLayout =  inflater.inflate(R.layout.pop_up_category, null);

        helpBuilder.setView(categoryLayout);

        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }*/
}
