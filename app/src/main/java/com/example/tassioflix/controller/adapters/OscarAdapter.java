package com.example.tassioflix.controller.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tassioflix.R;
import com.example.tassioflix.model.entity.Oscar;

import java.util.List;

public class OscarAdapter extends BaseAdapter {

    private final List<Oscar> oscarList;

    public OscarAdapter(List<Oscar> oscarList) {
        this.oscarList = oscarList;
    }

    @Override
    public int getCount() {
        return this.oscarList.size();
    }
    @Override
    public Object getItem(int position) {
        return this.oscarList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return this.oscarList.get(position).getId();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.oscar_item, parent, false);
        }

        Oscar oscar = (Oscar) getItem(position);
        TextView movieName = convertView.findViewById(R.id.movieName);
        TextView movieSloganTagline = convertView.findViewById(R.id.movieSloganTagline);

        movieName.setText(oscar.getName());
        movieSloganTagline.setText(oscar.getSloganTagline());

        return convertView;
    }
}
