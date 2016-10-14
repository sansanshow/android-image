package com.keaven.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * 图像处理帮助类
 * Created by HX-MG01 on 2016/10/14.
 */
public class ImageHelper {
    /**
     * 图像特效处理
     * @param bm 图像的Bitmap
     * @param hue 色调
     * @param saturation 饱和度
     * @param lum 亮度
     * @return 处理后的Bitmap
     */
    public static Bitmap handleImageEffect(Bitmap bm, float hue, float saturation, float lum) {
        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888); // Bitmap.Config.ARGB_8888 => 32位RGB位图
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // *********************** 图像的调整--start **************************
        // 色调
        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0, hue);//R修改
        hueMatrix.setRotate(1, hue);//G修改
        hueMatrix.setRotate(2, hue);//B修改

        // 饱和度
        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        // 亮度
        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum, lum, lum, 1);

        //
        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);
        //将调整添加到画布
        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));

        canvas.drawBitmap(bitmap, 0, 0, paint);// 将图像添加到画布
        // *********************** 图像的调整--end **************************
        return bitmap;
    }
}
