package com.example.user.practical4;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    CheckBox checkBoxEN;
    TextView textViewName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxEN = (CheckBox) findViewById(R.id.checkBoxEN);
        textViewName = (TextView) findViewById(R.id.textViewName);
        loadPref();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SetPreferenceActivity.class);
        startActivityForResult(intent, 0);
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        loadPref( );
    }
    private void loadPref() {
        SharedPreferences mySharedPreferences =
                PreferenceManager. getDefaultSharedPreferences(this);
        boolean my_checkbox_preference = mySharedPreferences.getBoolean("en", false);
        checkBoxEN.setChecked(my_checkbox_preference);
        String my_edittext_preference = mySharedPreferences.getString("name", "");
        textViewName.setText(my_edittext_preference);
    }

    public void loadTest(View view){

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SetPreferenceActivity.class);
        startActivityForResult(intent, 0);

    }

}