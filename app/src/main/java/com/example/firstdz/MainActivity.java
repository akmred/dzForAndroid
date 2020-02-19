package com.example.firstdz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTextOnMainActivity();

        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()",
                Toast.LENGTH_SHORT).show();

        Log.d(LOG_TAG, "onCreate");

    }

        @Override
        protected void onStart() {
            super.onStart();
            Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "onStart");

        }

        // восстановление
        @Override
        protected void onRestoreInstanceState(Bundle saveInstanceState){
            super.onRestoreInstanceState(saveInstanceState);
            Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "onRestoreInstanceState");
            saveInstanceState.putBoolean("");
        }


        @Override
        protected void onResume() {
            super.onResume();
            Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "onResume");
        }


        @Override
        protected void onPause() {
            super.onPause();
            Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "onPause");
        }

        // сохранение
        @Override
        protected void onSaveInstanceState(Bundle saveInstanceState){
            super.onSaveInstanceState(saveInstanceState);
            Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "onSaveInstanceState");
        }

        @Override
        protected void onStop() {
            super.onStop();
            Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "onStop");
        }

        @Override
        protected void onRestart() {
            super.onRestart();
            Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "onRestart");
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "onDestroy");
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
