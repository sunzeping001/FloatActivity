package com.go.sunzeping.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

import com.go.sunzeping.myapplication.server.FxService;

public class MainActivity extends Activity {
    private Button btn;
    private Button btn_close;
    Button mFloatView;


    private static final String TAG = "szp";
    WindowManager mWindowManager;
    WindowManager.LayoutParams wmParams;
    LinearLayout mFloatLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, CaupatureActivity.class));
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, FxService.class);
//                startService(intent);
                createFloatView();
            }
        });
        btn_close = (Button) findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FxService.class);
                //终止FxService
//                stopService(intent);
                mWindowManager.removeView(mFloatLayout);
                finish();
            }
        });
    }

    private void createFloatView() {
        //获取LayoutParams对象
        wmParams = new WindowManager.LayoutParams();

        //获取的是LocalWindowManager对象
        mWindowManager = this.getWindowManager();
        Log.e(TAG, "mWindowManager1--->" + this.getWindowManager());
        //mWindowManager = getWindow().getWindowManager();
        Log.e(TAG, "mWindowManager2--->" + getWindow().getWindowManager());

        //获取的是CompatModeWrapper对象
        //mWindowManager = (WindowManager) getApplication().getSystemService(Context.WINDOW_SERVICE);
        Log.e(TAG, "mWindowManager3--->" + mWindowManager);
        wmParams.type = LayoutParams.TYPE_PHONE;
        wmParams.format = PixelFormat.RGBA_8888;
        wmParams.flags = LayoutParams.FLAG_NOT_FOCUSABLE;
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
        wmParams.x = 0;
        wmParams.y = 0;
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        LayoutInflater inflater = this.getLayoutInflater();//LayoutInflater.from(getApplication());

        mFloatLayout = (LinearLayout) inflater.inflate(R.layout.activity_test2, null);
        mWindowManager.addView(mFloatLayout, wmParams);
        //setContentView(R.layout.main);
        mFloatView = (Button) mFloatLayout.findViewById(R.id.float_id);

        Log.e(TAG, "mFloatView" + mFloatView);
        Log.e(TAG, "mFloatView--parent-->" + mFloatView.getParent());
        Log.e(TAG, "mFloatView--parent--parent-->" + mFloatView.getParent().getParent());
        //绑定触摸移动监听
        mFloatView.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                wmParams.x = (int) event.getRawX() - mFloatLayout.getWidth() / 2;
                //25为状态栏高度
                wmParams.y = (int) event.getRawY() - mFloatLayout.getHeight() / 2 - 40;
                mWindowManager.updateViewLayout(mFloatLayout, wmParams);
                return false;
            }
        });

        //绑定点击监听
        mFloatView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.e("szp","点击了悬浮窗");
            }
        });
    }

}
