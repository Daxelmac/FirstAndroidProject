package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SampleActivity";
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    public int counter = 0;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** saved Instance for rotation, so  that it doesnt get lost **/
        if(savedInstanceState == null){
            //it is the first time the fragment is being called
            counter = 0;
        }else{
            //not the first time so we will check SavedInstanceState bundle
            counter = savedInstanceState.getInt("value",0); //here zero is the default value
        }

        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.counter_text);
        txt.setText(String.valueOf(counter));
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v(TAG, "++ ON START ++");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.v(TAG, "+ ON RESUME +");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.v(TAG, "- ON PAUSE -");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.v(TAG, "-- ON STOP --");
    }


    /** Save counter state when screen rotate */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("value",counter);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void clickButton(View view){
        counter++;
        txt.setText(String.valueOf(counter));
    }

    public void resetButton(View view){
        counter = 0;
        txt.setText(String.valueOf(counter));
    }
}
