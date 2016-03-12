package com.example.arjun.nhacks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class GroupsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void exit(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void group1(View view){
        Intent intent = new Intent(this, ListFacesActivity.class);
        startActivity(intent);
    }

    public void group2(View view){
        Intent intent = new Intent(this, ListFacesActivity.class);
        startActivity(intent);
    }

}
