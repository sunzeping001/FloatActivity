package com.go.sunzeping.myapplication.utils;

import android.content.Context;
import android.hardware.camera2.CameraDevice;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by sunzeping on 2016/7/13.
 */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private CameraDevice camera = null;
    private SurfaceHolder surfaceHolder = null;

    public CameraPreview(Context context) {
        super(context);
    }

    public CameraPreview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
