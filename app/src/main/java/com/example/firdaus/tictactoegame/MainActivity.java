package com.example.firdaus.tictactoegame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}


    public void openSinglePlayer(View view) {
        Intent i=new Intent(this, Interface.class);
        startActivity(i);
    }

    public void openMultiplePlayer(View view) {
        Intent j=new Intent(this,Interface2.class);
        startActivity(j);
    }

    public void exit(View view) {
       System.exit(0);
    }






}
