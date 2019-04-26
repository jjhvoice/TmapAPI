package com.example.test.tmapapi;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

public class ReverseGeocoding_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse_geocoding_);

        LinearLayout linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        TMapView tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey( "18e206f8-6efe-46df-9f9d-541ac010ab66" );
        linearLayoutTmap.addView( tMapView );

        TMapPoint tMapPoint = new TMapPoint(37.570841, 126.985302); // SKT타워

        TMapData tmapdata = new TMapData();
        Handler handler = new Handler();

        try {
            final String address = tmapdata.convertGpsToAddress(tMapPoint.getLatitude(), tMapPoint.getLongitude());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(ReverseGeocoding_Activity.this, address, Toast.LENGTH_SHORT).show();
                }
            });
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
