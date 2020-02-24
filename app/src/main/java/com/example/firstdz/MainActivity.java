package com.example.firstdz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.BoringLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.firstdz.R.id.speedWindBox;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLog";
    private boolean isTwoActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTextOnMainActivity();

        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);

        isTwoActivity = saveInstanceState.getBoolean("isTwoActivity");

        if (isTwoActivity) {
            setContentView(R.layout.activity_customize);

            Boolean isSpeedWind = saveInstanceState.getBoolean("speedWindBox");
            Boolean isPressure = saveInstanceState.getBoolean("pressureBox");
            String editTownString = saveInstanceState.getString("edit_town");

            // скорость ветра
            CheckBox speedWindBox = findViewById(R.id.speedWindBox);
            // давление
            CheckBox pressureBox = findViewById(R.id.pressureBox);

            // город
            EditText edit_town = findViewById(R.id.edit_town);

            speedWindBox.setChecked(isSpeedWind);
            pressureBox.setChecked(isPressure);
            edit_town.setText(editTownString);

        }

        /////////////////////////////
        Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);


        if (isTwoActivity) {
            CheckBox speedWindBox = findViewById(R.id.speedWindBox);
            CheckBox pressureBox = findViewById(R.id.pressureBox);
             EditText edit_town = findViewById(R.id.edit_town);

            saveInstanceState.putBoolean("speedWindBox", speedWindBox.isChecked());
            saveInstanceState.putBoolean("pressureBox", pressureBox.isChecked());
            saveInstanceState.putString("edit_town", edit_town.getText().toString());
        }

        saveInstanceState.putBoolean("isTwoActivity", isTwoActivity);

        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
    }


    public void setTextOnMainActivity() {
        TextView town = findViewById(R.id.town);
        town.setText(R.string.town);

        TextView weather = findViewById(R.id.weather);
        weather.setText("weather");

    }

    public void bCustomizationOnClick(View view){
        Toast.makeText(this, "b_cusomization on click event!",
        Toast.LENGTH_SHORT);

        setContentView(R.layout.activity_customize);
        isTwoActivity = true;

    }

    public void backup_onClick(View view) {

        setContentView(R.layout.activity_main);
        setTextOnMainActivity();
        isTwoActivity = false;

    }



}
