package com.example.qwerty.firstandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button back;
    private TextView view;
    private Integer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        back = (Button) findViewById(R.id.back);
        view = (TextView) findViewById(R.id.effects);
        counter = MainActivity.getTries();
        view.setText("Gratulacje\nUdalo ci sie zgadnac odpowiedz w: " +counter + " probach" );

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
