package com.kysuther.gardenguide;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class myPlants2 extends AppCompatActivity {

    private ListView drawerNavList2;
    private ArrayAdapter<String> drawerAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plants2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myPlants2.this, Browse.class);
                startActivity(intent);
            }
        });

        ImageButton roseButton = (ImageButton) findViewById(R.id.rosePlantButton);
        roseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myPlants2.this, Rose2.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawerNavList2 = (ListView)findViewById(R.id.navList);
        addDrawerItems();
    }

    private void addDrawerItems(){
        String[] menuArr = { "Home", "Browse", "My Plants", "Tasks", "Settings" };
        drawerAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuArr);
        drawerNavList2.setAdapter(drawerAdapter2);

        drawerNavList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: //Log History
                        Intent intent = new Intent(myPlants2.this, MainActivity2.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(myPlants2.this, Browse2.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(myPlants2.this, myPlants2.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent4 = new Intent(myPlants2.this, Tasks2.class);
                        startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5 = new Intent(myPlants2.this, SettingsNEW2.class);
                        startActivity(intent5);
                        break;

//            default:
//                throw new InvalidArgumentException("unknown position");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_plants2, menu);
        return true;
    }

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
