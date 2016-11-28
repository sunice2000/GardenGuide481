package com.kysuther.gardenguide;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rose);

        final Button addRoseButton = (Button) findViewById(R.id.addRose);
        addRoseButton.setTag(0);
        addRoseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int status = (Integer) view.getTag();
                if(status == 0) {
                    Snackbar.make(view, "Rose has been added to your plants.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    addRoseButton.setText("View in My Plants");
                    view.setTag(1);
                }else{
                    Intent intent2 = new Intent(Rose.this, myPlants2.class);
                    startActivity(intent2);
                }
            }
        });
    }
}
