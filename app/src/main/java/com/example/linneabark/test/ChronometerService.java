package com.example.linneabark.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Eli on 2017-04-27.
 */

public class ChronometerService extends Service {
    @Nullable
    @Override

    public startService(){

    }
    public IBinder onBind(Intent intent) {
        return null;
    }
}
