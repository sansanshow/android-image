package com.keaven.image;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void primary(View v) {
        Intent primary = new Intent(this, PrimaryColorActivity.class);
        startActivity(primary);
    }

    public void colorMatrix(View v) {
        Intent matrix = new Intent(this, ColorMatrixActivity.class);
        startActivity(matrix);
    }

    public void doPixelsEffect(View v) {
        Intent pixels = new Intent(this, PixelsEffect.class);
        startActivity(pixels);
    }

}
