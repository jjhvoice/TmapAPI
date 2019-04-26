package com.example.test.tmapapi;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolygon;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;

public class PolygonDraw_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polygon_draw_);

        LinearLayout linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        TMapView tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey( "18e206f8-6efe-46df-9f9d-541ac010ab66" );
        linearLayoutTmap.addView( tMapView );

        ArrayList<TMapPoint> alTMapPoint = new ArrayList<TMapPoint>();
        alTMapPoint.add( new TMapPoint(37.570841, 126.985302) ); // SKT타워
        alTMapPoint.add( new TMapPoint(37.551135, 126.988205) ); // N서울타워
        alTMapPoint.add( new TMapPoint(37.579600, 126.976998) ); // 경복궁

        TMapPolygon tMapPolygon = new TMapPolygon();
        tMapPolygon.setLineColor(Color.BLUE);
        tMapPolygon.setPolygonWidth(2);
        tMapPolygon.setAreaColor(Color.GRAY);
        tMapPolygon.setAreaAlpha(100);
        for( int i=0; i<alTMapPoint.size(); i++ ) {
            tMapPolygon.addPolygonPoint( alTMapPoint.get(i) );
        }
        tMapView.addTMapPolygon("Line1", tMapPolygon);
    }
}
