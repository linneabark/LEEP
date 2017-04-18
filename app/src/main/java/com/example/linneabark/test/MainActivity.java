package com.example.linneabark.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings_id:
                setContentView(R.layout.settings_view);
                return true;
            case R.id.statistics_id:
                setContentView(R.layout.statistics_view);
                return true;
            case R.id.timelog_id:
                setContentView(R.layout.activity_main);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void testMethod(){
        int i = 6;

    }
}
