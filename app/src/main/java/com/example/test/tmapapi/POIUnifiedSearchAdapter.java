package com.example.test.tmapapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class POIUnifiedSearchAdapter extends BaseAdapter {

    private ArrayList<POIUnifiedSearchListViewItem> items = new ArrayList<>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public POIUnifiedSearchListViewItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_poiunified_search_listview_item, parent, false);
        }

        TextView textview_name = (TextView) convertView.findViewById(R.id.textview_name);
        TextView textview_address = (TextView) convertView.findViewById(R.id.textview_address);
        TextView textview_point = (TextView) convertView.findViewById(R.id.textview_point);

        POIUnifiedSearchListViewItem item = getItem(position);

        textview_name.setText(item.getName());
        textview_address.setText(item.getAddress());
        textview_point.setText(item.getPoint());

        return convertView;
    }

    public void addItem(String name, String address, String point) {
        POIUnifiedSearchListViewItem item = new POIUnifiedSearchListViewItem();

        item.setName(name);
        item.setAddress(address);
        item.setPoint(point);

        items.add(item);
    }
}
