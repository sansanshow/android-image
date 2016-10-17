package com.keaven.image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * 图像效果处理
 * 1：底片效果
 * 2：老照片效果
 * 3：浮雕效果
 * Created by san on 2016/10/17.
 */

public class PixelsEffect extends Activity {
    private ImageView mImageView1;
    private ImageView mImageView2;
    private ImageView mImageView3;
    private ImageView mImageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pixels_effect);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test2);
        mImageView1 = (ImageView) findViewById(R.id.iv_photo1);
        mImageView2 = (ImageView) findViewById(R.id.iv_photo2);
        mImageView3 = (ImageView) findViewById(R.id.iv_photo3);
        mImageView4 = (ImageView) findViewById(R.id.iv_photo4);

        mImageView1.setImageBitmap(bitmap);//原图
        mImageView2.setImageBitmap(ImageHelper.handleImageNegative(bitmap));//底片效果
        mImageView3.setImageBitmap(ImageHelper.handleImageOldPhoto(bitmap));//怀旧效果
        mImageView4.setImageBitmap(ImageHelper.handleImageRelief(bitmap));//浮雕效果
    }
}
