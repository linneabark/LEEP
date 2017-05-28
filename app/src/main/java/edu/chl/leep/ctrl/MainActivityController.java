
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
import edu.chl.leep.model.LeepModel;
import edu.chl.leep.model.MainActivityModel;
import edu.chl.leep.service.FileService;
import edu.chl.leep.service.SaveActivity;

/**
 * MainActivityController is the controller class which handles the fragment and menu, as well as popups
 */
public class MainActivityController extends AppCompatActivity {

    public static LeepModel leep;
    private Context mContext;
    private SettingsController settings;
    private MainActivityModel mainActivityModel;
    private FileService fileService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        mainActivityModel = new MainActivityModel();
        fileService = new FileService();
        leep = new LeepModel();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        changeFragment(R.id.timelog_id);

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    private boolean changeFragment(int id){
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
                nextFrag = new TimeLogsController();
                break;
            case R.id.account_id:

                fileService.saveActivityRowListSharedPref(mContext, SaveActivity.activityRowList);
                SaveActivity.activityRowList.clear();

                mainActivityModel.logOutUser(mContext);
                Intent MainToLogin = new Intent(MainActivityController.this, LoginActivityController.class);
                startActivity(MainToLogin);

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
