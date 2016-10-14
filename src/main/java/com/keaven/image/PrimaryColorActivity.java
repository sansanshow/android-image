package com.keaven.image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by HX-MG01 on 2016/10/14.
 */
public class PrimaryColorActivity extends Activity implements SeekBar.OnSeekBarChangeListener {
    private ImageView mImageView;
    private SeekBar mSeekBarHue, mSeekBarSaturation, mSeekBarLum;
    private static int MAX_VALUE = 255;
    private static int MID_VALUE = 127;
    private float mHue, mSatuation, mLum;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primary_color);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test1);
        // 获取实例
        mImageView = (ImageView) findViewById(R.id.iv_photo);
        mSeekBarHue = (SeekBar) findViewById(R.id.seekBarHue);
        mSeekBarSaturation = (SeekBar) findViewById(R.id.seekBarSatuation);
        mSeekBarLum = (SeekBar) findViewById(R.id.seekBarLum);
        // 设置监听
        mSeekBarHue.setOnSeekBarChangeListener(this);
        mSeekBarSaturation.setOnSeekBarChangeListener(this);
        mSeekBarLum.setOnSeekBarChangeListener(this);
        // 设置拖动条最大值
        mSeekBarHue.setMax(MAX_VALUE);
        mSeekBarSaturation.setMax(MAX_VALUE);
        mSeekBarLum.setMax(MAX_VALUE);
        // 设置拖动条默认值
        mSeekBarHue.setProgress(MID_VALUE);
        mSeekBarSaturation.setProgress(MID_VALUE);
        mSeekBarLum.setProgress(MID_VALUE);
        mImageView.setImageBitmap(mBitmap);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.i("asdf", "1111111111");
        switch (seekBar.getId()) {
            case R.id.seekBarHue:
                mHue = (progress - MID_VALUE) * 1.0F / MID_VALUE * 180;
                break;
            case R.id.seekBarSatuation:
                mSatuation = progress * 1.0F / MID_VALUE;
                break;
            case R.id.seekBarLum:
                mLum = progress * 1.0F / MID_VALUE;
                break;
            default:
                break;
        }
        mImageView.setImageBitmap(ImageHelper.handleImageEffect(mBitmap, mHue, mSatuation, mLum));
    }

    public void resetDefault(View view) {
        // 设置拖动条默认值
        mSeekBarHue.setProgress(MID_VALUE);
        mSeekBarSaturation.setProgress(MID_VALUE);
        mSeekBarLum.setProgress(MID_VALUE);
        mImageView.setImageBitmap(ImageHelper.handleImageEffect(mBitmap, 0, 1.0F, 1.0F));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
