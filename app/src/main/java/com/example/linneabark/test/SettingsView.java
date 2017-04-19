package com.example.linneabark.test;

import android.content.Context;

import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Eli on 2017-04-06.
 */

public class SettingsView extends View {

    public SettingsView(Context context) {
        super(context);
        init(null,0);
    }

    public SettingsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public SettingsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr){

    }
}
