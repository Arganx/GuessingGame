package com.example.qwerty.firstandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private Boolean started = false;
    private Integer number;
    private EditText insertion;
    private TextView textView;
    private static Integer tries=0;

    public static Integer getTries() {
        return tries;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start);
        insertion = (EditText) findViewById(R.id.guess);
        textView = (TextView) findViewById(R.id.information);
        insertion.setEnabled(false);
        textView.setText("Dzialnie aplikacji: Po nacisnieciu przycisku start losowana jest liczba. Twoim zadaniem jest zgadniecie tej liczby. Po kazdej probie dowiesz sie czy liczba, ktora wpisales jest wieksza czy mniejsza niz wylosowana. Jak trafisz to czeka cie niespodzianka :)");
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(started==false)
                {
                    started=true;
                    start.setText("Zatwierdz");
                    number = ThreadLocalRandom.current().nextInt(0, 100 + 1);
                    insertion.setEnabled(true);
                }
                else if(!insertion.getText().toString().equals(""))
                {
                    tries++;
                    if (Integer.parseInt(insertion.getText().toString()) < number) {
                        textView.setText("Szukana liczba jest wieksza");
                    } else if (Integer.parseInt(insertion.getText().toString()) > number) {
                        textView.setText("Szukana liczba jest mniejsza");
                    }
                    else if(Integer.parseInt(insertion.getText().toString()) == number)
                    {
                        started=false;
                        Intent myIntent = new Intent(MainActivity.this,SecondActivity.class);
                        startActivity(myIntent);
                    }
                }

            }
        });
    }
}
