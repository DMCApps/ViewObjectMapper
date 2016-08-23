package com.github.dmcapps.viewobjectmapperexample.examples.resIdMap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.annotations.ViewResourceId;
import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapperexample.R;

import java.util.Date;

public class BasicMappingExample extends AppCompatActivity {
    private static final String TAG = BasicMappingExample.class.getSimpleName();

    private TextView mTextView;
    private EditText mEditText;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_mapping_example);

        Date startTime = new Date();
        ViewObjectMapper.mapObjectToView(this, this, findViewById(R.id.automap_container));
        Date endTime = new Date();

        Log.i(TAG, "Time to map: " + (endTime.getTime() - startTime.getTime()));
    }
}
