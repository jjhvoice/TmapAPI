package com.example.test.tmapapi;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

public class RouteGuidance_Activity extends AppCompatActivity {

    TMapView tMapView;
    TMapPoint tMapPointStart;
    TMapPoint tMapPointEnd;
    TMapPolyLine tMapPolyLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_guidance_);

        LinearLayout linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey( "18e206f8-6efe-46df-9f9d-541ac010ab66" );
        linearLayoutTmap.addView( tMapView );

        tMapPointStart = new TMapPoint(37.570841, 126.985302); // SKT타워(출발지)
        tMapPointEnd = new TMapPoint(37.551135, 126.988205); // N서울타워(목적지)

        TmapThread runnable = new TmapThread();
        Thread thread = new Thread(runnable);
        thread.start();
    }

    Handler handler = new Handler();

    public class UIUpdate implements Runnable {
        @Override
        public void run() {
            tMapView.addTMapPolyLine("Line1", tMapPolyLine);
        }
    }

    public class TmapThread implements Runnable {
        @Override
        public void run() {
            try {
                tMapPolyLine = new TMapData().findPathData(tMapPointStart, tMapPointEnd);
                tMapPolyLine.setLineColor(Color.BLUE);
                tMapPolyLine.setLineWidth(2);
                handler.post(new UIUpdate());

            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
