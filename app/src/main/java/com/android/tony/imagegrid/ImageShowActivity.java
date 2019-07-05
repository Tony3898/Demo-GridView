package com.android.tony.imagegrid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Bitmap bitmap = (Bitmap) bundle.get("ImageBitmap");

        ImageView imageView = findViewById(R.id.gridimage);
        imageView.setImageBitmap(bitmap);

    }
}
