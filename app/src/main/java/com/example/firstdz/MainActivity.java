package com.example.firstdz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTextOnMainActivity();

//        Button b_cuztomization = findViewById(R.id.customization);
//        b_cuztomization.setText("Настройка");

    }

    public void setTextOnMainActivity() {
        TextView town = findViewById(R.id.town);
        town.setText(R.string.town);

        TextView weather = findViewById(R.id.weather);
        weather.setText("weather");

    }

    public void b_customization_onClick(View view){
        Toast.makeText(this, "b_cusomization on click event!",
        Toast.LENGTH_SHORT);

        setContentView(R.layout.activity_customize);

    }

    public void backup_onClick(View view) {

        setContentView(R.layout.activity_main);
        setTextOnMainActivity();

    }



}
