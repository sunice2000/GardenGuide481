package com.kysuther.gardenguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Rose2 extends AppCompatActivity {

    private ListView drawerNavList2;
    private ArrayAdapter<String> drawerAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rose2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button addRoseButton = (Button) findViewById(R.id.removeRose);
        addRoseButton.setTag(0);
        addRoseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int status = (Integer) view.getTag();
                if(status == 0) {
                    //Snackbar.make(view, "Rose has been added to your plants.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    addRoseButton.setText("Click once more to confirm");
                    view.setTag(1);
                }else{
                    Intent intent2 = new Intent(Rose2.this, MyPlantsNEW.class);
                    startActivity(intent2);
                }
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
                        Intent intent = new Intent(Rose2.this, MainActivity2.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(Rose2.this, Browse.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(Rose2.this, myPlants2.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent4 = new Intent(Rose2.this, Tasks2.class);
                        startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5 = new Intent(Rose2.this, SettingsNEW2.class);
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
        getMenuInflater().inflate(R.menu.main, menu);
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
