package com.go.sunzeping.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Test2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("szp","Test2");
    }
}
