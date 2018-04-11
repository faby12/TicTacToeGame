package com.example.firdaus.tictactoegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Interface extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
    }

    public void open_3_by_3(View view) {
        Intent k=new Intent(this, Single_player_3by3.class);
        startActivity(k);
    }


    public void open_5_by_5(View view) {
        Intent l=new Intent(this, Multiple_Player_5_by_5.class);
        startActivity(l);
    }
}
