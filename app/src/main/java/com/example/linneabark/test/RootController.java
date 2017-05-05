package com.example.linneabark.test;

import android.support.constraint.ConstraintLayout;
import android.widget.LinearLayout;

public class RootController {
    private ConstraintLayout register;
    private LinearLayout log;

    public void switchToRegister() {
        register.bringToFront();
    }

    public void switchToLog() {
        log.bringToFront();
    }

}