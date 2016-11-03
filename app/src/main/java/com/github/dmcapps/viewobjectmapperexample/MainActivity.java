package com.github.dmcapps.viewobjectmapperexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.dmcapps.viewobjectmapper.core.annotations.ViewResourceId;
import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapperexample.examples.automap.PrefixAutoMapExample;
import com.github.dmcapps.viewobjectmapperexample.examples.fragementmap.BasicMappingFragment;
import com.github.dmcapps.viewobjectmapperexample.examples.fragementmap.activity.FragmentExampleActivity;
import com.github.dmcapps.viewobjectmapperexample.examples.helpermethodsmap.BasicHelperMapExampleActivity;
import com.github.dmcapps.viewobjectmapperexample.examples.helpermethodsmap.ObjectHelperMapExample;
import com.github.dmcapps.viewobjectmapperexample.examples.resIdMap.BasicMappingExample;
import com.github.dmcapps.viewobjectmapperexample.examples.resIdMap.MapWithResourceIdExample;
import com.github.dmcapps.viewobjectmapperexample.examples.resIdMap.ObjectMappingExample;
import com.github.dmcapps.viewobjectmapperexample.examples.automap.BasicAutoMapExample;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @ViewResourceId(android.R.id.list)
    ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);

        new ViewObjectMapper.Builder(this)
                .setObjectToMap(this)
                .setViewToMap(viewGroup)
                .setListOnItemClickListener(this)
                .build()
                .map();

        ArrayList<String> items = new ArrayList<>();
        items.add("Basic Mapping Example");
        items.add("Map with @ViewResourceId annotation");
        items.add("Custom Object Mapping Example");
        items.add("Basic Auto Map Example");
        items.add("Prefix Res Id Auto Map Example");
        items.add("Basic Helper Method Map Example");
        items.add("Object Mapped With Helper Method Map Example");
        items.add("Basic Fragment Map Example");

        mList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;

        if (position == 0) {
            intent = new Intent(this, BasicMappingExample.class);
        } else if (position == 1) {
            intent = new Intent(this, MapWithResourceIdExample.class);
        } else if (position == 2) {
            intent = new Intent(this, ObjectMappingExample.class);
        } else if (position == 3) {
            intent = new Intent(this, BasicAutoMapExample.class);
        } else if (position == 4) {
            intent = new Intent(this, PrefixAutoMapExample.class);
        } else if (position == 5) {
            intent = new Intent(this, BasicHelperMapExampleActivity.class);
        } else if (position == 6) {
            intent = new Intent(this, ObjectHelperMapExample.class);
        } else if (position == 7) {
            intent = new Intent(this, FragmentExampleActivity.class);
            intent.putExtra(FragmentExampleActivity.EXTRA_CLASS_NAME, BasicMappingFragment.class.getName());
        }

        startActivity(intent);
    }
}
