
package edu.chl.leep.ctrl;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.linneabark.test.R;

import edu.chl.leep.model.Leep;
import edu.chl.leep.service.AccountDetails;

public class MainActivity extends AppCompatActivity {

    //private AccountController account = new AccountController();


    public static Leep leep;
    private Context mContext;

    public Context getContext(){
        return mContext;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        leep = new Leep();
        //if the value is 0 start login in again

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);



        //MenuItem logOut = getItemId(R.id.account_id);


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
        switch (item.getItemId()) {
            case R.id.settings_id:
                nextFrag = new Settings();
                break;
            case R.id.statistics_id:
                nextFrag = new Statistics();
                break;
            case R.id.timelog_id:
                nextFrag = new TimeLog();
                break;
            case R.id.account_id:

                Leep.setKeepLoginStateToZero(mContext, 0);
                Toast.makeText(mContext, ("Logged out " + Leep.getUsername(mContext)+"!"),Toast.LENGTH_SHORT).show();


                Intent toy = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(toy);

        }
        transaction.add(R.id.fragment_container, nextFrag);
        transaction.commit();
        return true;
    }


    public void showCategoryPopUp(View v){


        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);


        LayoutInflater inflater = this.getLayoutInflater();

        //if() {
            View categoryLayout = inflater.inflate(R.layout.pop_up_window_category, null);
            helpBuilder.setView(categoryLayout);
       /* }else if() {

            View quotesLayout = inflater.inflate(R.layout.pop_up_window_quotes, null);
            helpBuilder.setView(quotesLayout);
        }else{
            View helpLayout = inflater.inflate(R.layout.pop_up_window_help, null);
            helpBuilder.setView(helpLayout);
        }
*/
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
    //method that adds headers and items in the expandablelistview

}
