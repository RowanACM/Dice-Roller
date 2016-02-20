package com.example.diceroller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

/**
 * The Main Activity (screen) of the app. You can only have one activity on screen at a time.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * When the activity is first created
     * You should never need to call this method
     * @param savedInstanceState The saved instance if the app was recently closed and reopened
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout of the activity to  activity_main in xml (res/layout/activity_main.xml)
        setContentView(R.layout.activity_main);

        // Add the toolbar to the screen (the main bar on top of the screen)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // The fab is the button on the bottom right of the screen. It is above all other views in
        // the app and typically stays when your user switches parts of the app.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You have pressed the fab", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Create the ... button on the right of the toolbar.
     * By default it only displays settings when tapped.
     * You should never need to call this method
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * When an item on the options menu is tapped, perform an action
     * You should never need to call this method
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
