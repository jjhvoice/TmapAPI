package com.example.test.tmapapi;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapPOIItem;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;

public class POIUnifiedSearch_Activity extends AppCompatActivity {

    EditText editText;
    ListView listview;
    POIUnifiedSearchAdapter adapter;

    TMapData tmapdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poiunified_search_);

        TMapView tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey( "18e206f8-6efe-46df-9f9d-541ac010ab66" );

        editText = (EditText)findViewById(R.id.edittextInput);
        Button button = (Button)findViewById(R.id.buttonSearch);
        listview = (ListView)findViewById(R.id.listview);

        tmapdata = new TMapData();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strData = editText.getText().toString();
                adapter = new POIUnifiedSearchAdapter();

                tmapdata.findAllPOI(strData, new TMapData.FindAllPOIListenerCallback() {
                    @Override
                    public void onFindAllPOI(ArrayList poiItem) {
                        for(int i = 0; i < poiItem.size(); i++) {
                            TMapPOIItem  item = (TMapPOIItem) poiItem.get(i);
                            adapter.addItem(item.getPOIName().toString(), item.getPOIAddress().replace("null", ""), item.getPOIPoint().toString());
                        }

                        TmapThread thread = new TmapThread();
                        thread.start();
                    }
                });
            }
        });
    }

    Handler handler = new Handler();

    public class UIUpdate implements Runnable {
        @Override
        public void run() {
            listview.setAdapter(adapter);
        }
    }

    public class TmapThread extends Thread {
        @Override
        public void run() {
            handler.post(new UIUpdate());
        }
    }
}
