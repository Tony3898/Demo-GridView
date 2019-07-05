package com.android.tony.imagegrid;

import android.graphics.Bitmap;

public class GridViewClass {
    Bitmap bitmap;
    String time;

    GridViewClass(Bitmap bitmap,String time)
    {
        this.bitmap = bitmap;
        this.time = time;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getTime() {
        return time;
    }
}
