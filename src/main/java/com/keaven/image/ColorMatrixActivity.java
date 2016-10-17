package com.keaven.image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

/**
 * 图像矩阵案例
 * Created by HX-MG01 on 2016/10/14.
 */
public class ColorMatrixActivity extends Activity {
    private ImageView mImageView;
    private GridLayout mGroup;
    private Bitmap bitmap;
    private int mEtWidth, mEtHeight;
    private EditText[] mEts = new EditText[20];
    private float[] mColorMatrix = new float[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_matrix);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test1);
        mImageView = (ImageView) findViewById(R.id.iv_image);
        mImageView.setImageBitmap(bitmap);
        mGroup = (GridLayout) findViewById(R.id.group);
        mGroup.post(new Runnable() {
            @Override
            public void run() {
                mEtWidth = mGroup.getWidth() / 5;
                mEtHeight = mGroup.getHeight() / 4;
                addEts();
                initMatrix();
            }
        });
    }


    public void changeMatrix(View view) {
        getMatrix();
        setImageMatrix();
    }

    public void resetMatrix(View view) {
        initMatrix();
        getMatrix();
        setImageMatrix();
    }

    /**
     * 从矩阵编辑框中获取值
     */
    private void getMatrix() {
        System.out.println("------mColorMatrix------");
        for (int i = 0; i < 20; i++) {
            mColorMatrix[i] = Float.valueOf(mEts[i].getText().toString());
            System.out.println("---" + i + "--" + mColorMatrix[i]);
        }


    }

    /**
     * 给图片设置颜色矩阵
     */
    private void setImageMatrix() {
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(mColorMatrix);/*颜色矩阵以数组的形式传递给ColorMatrix*/
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);/*设置抗锯齿*/
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);/* 用画笔Paint 画笔重新画*/
        mImageView.setImageBitmap(bmp);
    }

    /**
     * 初始化矩阵UI
     */
    private void addEts() {
        for (int i = 0; i < 20; i++) {
            EditText editText = new EditText(this);
            mEts[i] = editText;
            mGroup.addView(editText, mEtWidth, mEtHeight);
        }
    }

    /**
     * 初始化矩阵数据
     */
    private void initMatrix() {
        for (int i = 0; i < 20; i++) {
            if (i % 6 == 0) {
                mEts[i].setText(String.valueOf(1));
            } else {
                mEts[i].setText(String.valueOf(0));
            }
        }
    }
}
