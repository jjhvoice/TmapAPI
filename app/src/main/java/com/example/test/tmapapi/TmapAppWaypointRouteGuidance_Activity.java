package com.example.test.tmapapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.skt.Tmap.TMapTapi;

import java.util.HashMap;

public class TmapAppWaypointRouteGuidance_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmap_app_waypoint_route_guidance_);

        Button button = (Button)findViewById(R.id.buttonAppWaypointRouteGuidance);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TMapTapi tMapTapi = new TMapTapi(TmapAppWaypointRouteGuidance_Activity.this);
                tMapTapi.setSKTMapAuthentication ( "18e206f8-6efe-46df-9f9d-541ac010ab66" );
                boolean isTmapApp = tMapTapi.isTmapApplicationInstalled();

                //티맵 App 설치 유무를 판단
                if(isTmapApp == true) {
                    HashMap pathInfo = new HashMap();
                    pathInfo.put("rStName", "출발지");
                    pathInfo.put("rStX", "126.926252");
                    pathInfo.put("rStY", "37.557607");

                    pathInfo.put("rV1Name", "경유지1");
                    pathInfo.put("rV1X", "126.976867");
                    pathInfo.put("rV1Y", "37.576016");

                    pathInfo.put("rV2Name", "T타워(경유지2)");
                    pathInfo.put("rV2X", "126.985302");
                    pathInfo.put("rV2Y", "37.570841");

                    pathInfo.put("rGoName", "집(목적지)");
                    pathInfo.put("rGoX", "126.934721");
                    pathInfo.put("rGoY", "37.487673");
                    tMapTapi.invokeRoute(pathInfo);
                }
            }
        });
    }
}
