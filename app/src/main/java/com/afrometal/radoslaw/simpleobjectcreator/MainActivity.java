package com.afrometal.radoslaw.simpleobjectcreator;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startCreating(View view) {
        Intent i = new Intent(MainActivity.this, CreatorActivity.class);
        MainActivity.this.startActivity(i);
    }
}
