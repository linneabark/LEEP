
package edu.chl.leep.ctrl;

import android.content.Context;
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
import android.widget.Toast;

import com.example.linneabark.test.R;
import edu.chl.leep.model.LeepModel;
import edu.chl.leep.model.MainActivityModel;
import edu.chl.leep.utils.Contexts;
import edu.chl.leep.utils.Intents;

/**
 * MainActivityController is the controller class which handles the fragment and menu, as well as popups
 */
public class MainActivityController extends AppCompatActivity {

    public static LeepModel leep;
    private Context mContext;
    private SettingsController settings;
    private MainActivityModel mainActivityModel;
   // Fragments fragments = new Fragments();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this.getContext();
        Contexts.setContexts(mContext);

        mainActivityModel = new MainActivityModel();
        leep = new LeepModel();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //fragments.changeFragment(R.id.timelog_id);
        changeFragment(R.id.timelog_id);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    private boolean changeFragment(int id){ //kopplad till alla controllers, hur ändra?
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment nextFrag = new Fragment();
        settings = new SettingsController();

        switch (id) {
            case R.id.settings_id:
                nextFrag = settings;
                break;
            case R.id.statistics_id:
                nextFrag = new StatisticsController();
                break;
            case R.id.timelog_id:
                nextFrag = new TimeLogController();
                break;
            case R.id.account_id:
                mainActivityModel.logOutUser();
                startActivity(Intents.ToLogIn(mContext));
                Toast.makeText(Contexts.getContexts(), ("Logged out " + LeepModel.getUsername()+"!"),Toast.LENGTH_SHORT).show();



        }
        transaction.add(R.id.fragment_container, nextFrag);
        transaction.commit();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return changeFragment(item.getItemId());
    }

    public void showPopUp(View v){
        settings.choosePopUp(v);
    }

    public Context getContext(){
        return mContext;
    }
}
