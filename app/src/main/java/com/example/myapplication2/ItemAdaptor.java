package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ItemAdaptor extends BaseAdapter{

    LayoutInflater mInflater;
    String[] items;
    String[] prices;
    String[] descriptions;

    public ItemAdaptor(Context context, String[] i, String[] p, String[] d){
        items =i;
        prices = p;
        descriptions = d;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public ItemAdaptor(Context context, String i, String p, String d){
        String[] auxI = new String[1];
        String[] auxP = new String[1];
        String[] auxD = new String[1];
        auxI[0] = i;
        auxP[0]= p;
        auxD[0] = d;
        items = auxI;
        prices = auxP;
        descriptions = auxD;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override

    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTextView = v.findViewById(R.id.mainTextView);
        TextView pricesTextView = v.findViewById(R.id.priceTextView);

        String name = items[i];
        String price = prices[i];

        nameTextView.setText(name);
        pricesTextView.setText(price);
        return v;
    }
}
