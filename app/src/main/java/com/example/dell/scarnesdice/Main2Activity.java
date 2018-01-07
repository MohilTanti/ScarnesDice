package com.example.dell.scarnesdice;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    FloatingActionButton fb,fb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fb=(FloatingActionButton)findViewById(R.id.floatingActionButton);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent("com.example.dell.scarnesdice.MainActivity");
                startActivity(in);
            }
        });
        fb1=(FloatingActionButton)findViewById(R.id.floatingActionButton3);
        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent("com.example.dell.scarnesdice.Main3Activity");
                startActivity(in);
            }
        });

    }
}
