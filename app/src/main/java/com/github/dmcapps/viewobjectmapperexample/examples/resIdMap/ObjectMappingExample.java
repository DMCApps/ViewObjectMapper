package com.github.dmcapps.viewobjectmapperexample.examples.resIdMap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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
        ViewObjectMapper.mapObjectToView(this, mViewHolder, findViewById(R.id.automap_container));
        Date endTime = new Date();

        Log.i(TAG, "Time to map: " + (endTime.getTime() - startTime.getTime()));

        assert(mViewHolder.mTextView == null
                || mViewHolder.mEditText == null
                || mViewHolder.mRadioGroup == null
                || mViewHolder.mRadioButton1 == null
                || mViewHolder.mRadioButton2 == null);
    }
}
