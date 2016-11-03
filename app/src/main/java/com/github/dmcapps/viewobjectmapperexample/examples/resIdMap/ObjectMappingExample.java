package com.github.dmcapps.viewobjectmapperexample.examples.resIdMap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapperexample.R;

import java.util.Date;

public class ObjectMappingExample extends AppCompatActivity {
    private static final String TAG = ObjectMappingExample.class.getSimpleName();

    ViewHolderUsingResourceId mViewHolder = new ViewHolderUsingResourceId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_mapping_example);

        new ViewObjectMapper.Builder(this)
                .setObjectToMap(mViewHolder)
                .setViewToMap(findViewById(R.id.automap_container))
                .build()
                .map();

        if (mViewHolder.mTextView == null
                || mViewHolder.mEditText == null
                || mViewHolder.mRadioGroup == null
                || mViewHolder.mRadioButton1 == null
                || mViewHolder.mRadioButton2 == null) {
            throw new RuntimeException(TAG + ": Failed to map object");
        }
    }
}
