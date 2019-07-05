package com.android.tony.imagegrid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.util.LocaleData;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    Bundle bundle;
    Bitmap bitmap;
    GridView gridView;
    List<GridViewClass> gridViewClassList;
    GridViewAdapter gridViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.girdview);
        gridViewClassList = new ArrayList<>();
        gridViewAdapter = new GridViewAdapter(getApplicationContext(),gridViewClassList);
        gridView.setAdapter(gridViewAdapter);
        floatingActionButton = findViewById(R.id.camfloatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ImageShowActivity.class);
                intent.putExtra("ImageBitmap",gridViewClassList.get(position).getBitmap());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data!=null)
        {
            bundle = data.getExtras();
            bitmap = (Bitmap) bundle.get("data");
            gridViewClassList.add(new GridViewClass(bitmap,String.valueOf(new Date())));
            gridViewAdapter.notifyDataSetChanged();
        }
    }
}
