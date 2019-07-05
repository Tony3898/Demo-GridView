package com.android.tony.imagegrid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    Context context;
    List<GridViewClass> gridViewClassList;
    @Override
    public int getCount() {
        return gridViewClassList.size();
    }

    @Override
    public Object getItem(int position) {
        return gridViewClassList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    GridViewAdapter(Context context, List<GridViewClass> gridViewClasses)
    {
        this.gridViewClassList = gridViewClasses;
        this.context = context;
    }


    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_grid_view,parent,false);

        GridViewClass gridViewClass = (GridViewClass) getItem(position);
        ImageView imageView = convertView.findViewById(R.id.imageViewgrid);
        TextView textView = convertView.findViewById(R.id.textViewgrid);

        imageView.setImageBitmap(gridViewClass.getBitmap());
        textView.setText(gridViewClass.getTime());
        return convertView;
    }
}
