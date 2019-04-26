package com.example.test.tmapapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.skt.Tmap.TMapView;

public class MapSetup_Activity extends AppCompatActivity {

    TMapView tMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_setup_);

        LinearLayout linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey( "18e206f8-6efe-46df-9f9d-541ac010ab66" );
        linearLayoutTmap.addView( tMapView );

        Button buttonMove1 = (Button)findViewById(R.id.buttonMove1);
        Button buttonMove2 = (Button)findViewById(R.id.buttonMove2);
        Button buttonZoomIn = (Button)findViewById(R.id.buttonZoomIn);
        Button buttonZoomOut = (Button)findViewById(R.id.buttonZoomOut);
        Button buttonZoomLevel10 = (Button)findViewById(R.id.buttonZoomLevel10);

        // "N서울타워" 버튼 클릭
        buttonMove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3번째 파라미터 생략 == 지도 이동 Animation 사용안함
                tMapView.setCenterPoint(126.988205, 37.551135);
            }
        });

        // "경복궁" 버튼 클릭
        buttonMove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3번째 파라미터 true == 지도 이동 Animation 사용
                tMapView.setCenterPoint(126.976998, 37.579600, true);
            }
        });

        // "확대" 버튼 클릭
        buttonZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tMapView.MapZoomIn();
            }
        });

        // "축소" 버튼 클릭
        buttonZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tMapView.MapZoomOut();
            }
        });

        // "ZoomLevel=10" 버튼 클릭
        buttonZoomLevel10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tMapView.setZoomLevel(10);
            }
        });
    }
}
