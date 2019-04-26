package com.example.test.tmapapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String[] activities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.main_list);

        String[] functions = getResources().getStringArray(R.array.function);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, functions);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

        activities = getResources().getStringArray(R.array.activity);
    }

    public void nextActivity(int position) {
        try {
            Intent intent = new Intent(MainActivity.this, Class.forName(activities[position]));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        nextActivity(position);
    }
}
