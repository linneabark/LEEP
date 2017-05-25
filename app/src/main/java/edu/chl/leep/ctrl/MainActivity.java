
package edu.chl.leep.ctrl;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.linneabark.test.R;

import edu.chl.leep.model.Leep;
import edu.chl.leep.model.MainActivityModel;

public class MainActivity extends AppCompatActivity {
//TODO name to xCtrl, maybe

    //private AccountController account = new AccountController();

    public static Leep leep;
    private Context mContext;
    private SettingsController settings;

    MainActivityModel mainActivityModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        mainActivityModel = new MainActivityModel();

        System.out.println("this.mContext: " + mContext);

        leep = new Leep();

        //if the value is 0 start login in again

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment nextFrag = new Fragment();
        settings = new SettingsController();
        switch (item.getItemId()) {
            case R.id.settings_id:
                nextFrag = settings;
                break;
            case R.id.statistics_id:
                nextFrag = new Statistics();
                break;
            case R.id.timelog_id:
                nextFrag = new TimeLog();
                break;
            case R.id.account_id:

                mainActivityModel.logOutUser(mContext);
                Intent MainToLogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(MainToLogin);

        }
        transaction.add(R.id.fragment_container, nextFrag);
        transaction.commit();
        return true;
    }


    public void showPopUp(View v){
        settings.choosePopUp(v);
    }

    public Context getContext(){
        return mContext;
    }


}
