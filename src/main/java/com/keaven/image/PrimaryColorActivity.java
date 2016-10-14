package com.keaven.image;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by HX-MG01 on 2016/10/14.
 */
public class PrimaryColorActivity extends Activity {
    private ImageView mImageView;
    private SeekBar mSeekBarHue,mSeekBarSaturation,mSeekBarLum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
