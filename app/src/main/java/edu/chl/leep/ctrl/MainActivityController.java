
package edu.chl.leep.ctrl;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.linneabark.test.R;
import edu.chl.leep.model.LeepModel;
import edu.chl.leep.model.TimerModel;
import edu.chl.leep.service.TimerService;
import edu.chl.leep.service.UserLoggedInService;
import edu.chl.leep.service.UserStateService;
import edu.chl.leep.utils.Contexts;
import edu.chl.leep.utils.Fragments;
import edu.chl.leep.utils.Intents;

/**
 * MainActivityController is the controller class which handles the fragment and menu, as well as popups
 */
public class MainActivityController extends AppCompatActivity {

    private Context mContext;
    //private SettingsController settings;
    private TimerService ts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this.getApplicationContext();
        Contexts.setContexts(mContext);
        //settings = new SettingsController();

        Fragments.setFragmentManager(getSupportFragmentManager());

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //changeFragment(R.id.timelog_id);
        Fragments.changeFragment(R.id.timelog_id);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return Fragments.changeFragment(item.getItemId());
        //return fragments.changeFragment(item.getItemId());
    }

    public void showPopUp(View v){
        Fragments.showPopUps(v);
    }

    public void logOut(){
        ts = new TimerService();
        ts.cleanTimer();

        UserLoggedInService.setKeepLoginStateToFalse();

        Contexts.getContexts().startActivity(Intents.ToLogIn(Contexts.getContexts()));
        Toast.makeText(Contexts.getContexts(), ("Logged out " + LeepModel.getUsername()+"!"),Toast.LENGTH_SHORT).show();

    }
}
