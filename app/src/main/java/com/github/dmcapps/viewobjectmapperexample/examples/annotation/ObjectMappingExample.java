package com.github.dmcapps.viewobjectmapperexample.examples.annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapperexample.R;

import java.util.Date;

public class ObjectMappingExample extends AppCompatActivity {
    private static final String TAG = ObjectMappingExample.class.getSimpleName();

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_mapping_example);

        Date startTime = new Date();
        ViewObjectMapper.mapObjectToView(mViewHolder, findViewById(R.id.container));
        Date endTime = new Date();

        Log.d(TAG, String.format("Time to Map: %d", (endTime.getTime() - startTime.getTime())));
    }
}
