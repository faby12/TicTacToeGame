package com.example.firdaus.tictactoegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Interface2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface2);
    }

    public void open_3_by_3_ano(View view) {
        Intent m=new Intent(this, Single_Player.class);
        startActivity(m);

    }

    public void open_5_by_5_ano(View view) {
        Intent n=new Intent(this, Single_player_5by5.class);
        startActivity(n);
    }
}
