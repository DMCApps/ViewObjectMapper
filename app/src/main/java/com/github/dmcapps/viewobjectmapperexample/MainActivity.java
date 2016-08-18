package com.github.dmcapps.viewobjectmapperexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.dmcapps.viewobjectmapper.core.annotations.ViewMapped;
import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapperexample.examples.annotation.BasicMappingExample;
import com.github.dmcapps.viewobjectmapperexample.examples.annotation.ObjectMappingExample;
import com.github.dmcapps.viewobjectmapperexample.examples.automapping.BasicAutoMapExample;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @ViewMapped(android.R.id.list)
    ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        ViewObjectMapper.mapObjectToView(this, viewGroup);

        ArrayList<String> items = new ArrayList<>();
        items.add("Basic Mapping Example");
        items.add("Custom Object Mapping Example");
        items.add("Basic Auto Map Example");

        mList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
        mList.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;

        if (position == 0) {
            intent = new Intent(this, BasicMappingExample.class);
        } else if (position == 1) {
            intent = new Intent(this, ObjectMappingExample.class);
        } else if (position == 2) {
            intent = new Intent(this, BasicAutoMapExample.class);
        }

        startActivity(intent);
    }
}
