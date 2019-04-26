package com.example.test.tmapapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.skt.Tmap.TMapTapi;

public class TmapAppUnifiedSearch_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmap_app_unified_search_);

        Button button = (Button)findViewById(R.id.buttonAppUnifiedSearch);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TMapTapi tMapTapi = new TMapTapi(TmapAppUnifiedSearch_Activity.this);
                tMapTapi.setSKTMapAuthentication ( "18e206f8-6efe-46df-9f9d-541ac010ab66" );
                boolean isTmapApp = tMapTapi.isTmapApplicationInstalled();

                //티맵 App 설치 유무를 판단
                if(isTmapApp == true) {
                    tMapTapi.invokeSearchPortal("SKT타워");
                }
            }
        });
    }
}
