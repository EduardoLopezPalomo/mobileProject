package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String item;
    Boolean itemNotSearched;
    String[] prices;
    String cost;
    String[] descriptions;
    String description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        itemNotSearched = true;
        SearchView search = findViewById(R.id.SearchView);
        TextView text = findViewById(R.id.textView2);
        Context context = this;


        Resources res = getResources();
        myListView = findViewById(R.id.myListView);
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        ItemAdaptor itemAdaptor = new ItemAdaptor(context, items,prices,descriptions);
        myListView.setAdapter(itemAdaptor);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(itemNotSearched) {
                    Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                    showDetailActivity.putExtra("com.example.myapplication2.Item", items[i]);
                    showDetailActivity.putExtra("com.example.myapplication2.Price",prices[i]);
                    showDetailActivity.putExtra("com.example.myapplication2.Desc",descriptions[i]);
                    startActivity(showDetailActivity);
                }else {
                    Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                    showDetailActivity.putExtra("com.example.myapplication2.Item", item);
                    showDetailActivity.putExtra("com.example.myapplication2.Price",cost);
                    showDetailActivity.putExtra("com.example.myapplication2.Desc",description);
                    startActivity(showDetailActivity);
                }
            }
        });

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                for (int i = 0; i < items.length; i++) {
                    if (items[i].equals(s)) {
                        setVariables(i);
                        ItemAdaptor itemAdaptor = new ItemAdaptor(context, item, cost, description);
                        myListView.setAdapter(itemAdaptor);
                        text.setText("");
                        i = items.length;
                    }else {
                        itemNotSearched = true;
                        ItemAdaptor itemAdaptor = new ItemAdaptor(context, items, prices, descriptions);
                        myListView.setAdapter(itemAdaptor);
                        text.setText("There is no Item");
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    private void setVariables(int i){
        item = items[i];
        cost = prices[i];
        description = descriptions[i];
        itemNotSearched = false;
    }
}