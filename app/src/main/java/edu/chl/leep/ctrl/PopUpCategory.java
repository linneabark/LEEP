package edu.chl.leep.ctrl;

import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.example.linneabark.test.R;

import edu.chl.leep.ctrl.MainActivity;

/**
 * Created by linneabark on 2017-05-22.
 */

public class PopUpCategory extends Fragment {
    MainActivity mA = new MainActivity();

    public PopUpCategory(){


    }

    public void showPopUpCategory(){
        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(mA.getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View categoryLayout =  inflater.inflate(R.layout.pop_up_window_category, null);

        helpBuilder.setView(categoryLayout);

        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
}
