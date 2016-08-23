package com.github.dmcapps.viewobjectmapperexample.examples.resIdMap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.dmcapps.viewobjectmapper.core.ViewObjectMapper;
import com.github.dmcapps.viewobjectmapper.core.annotations.ViewResourceId;
import com.github.dmcapps.viewobjectmapperexample.R;

import java.util.Date;

public class MapWithResourceIdExample extends AppCompatActivity {
    private static final String TAG = MapWithResourceIdExample.class.getSimpleName();

    @ViewResourceId(R.id.test_text_view)
    private TextView mTextView;
    @ViewResourceId(R.id.test_edit_text)
    private EditText mEditText;
    @ViewResourceId(R.id.test_radio_group)
    private RadioGroup mRadioGroup;
    @ViewResourceId(R.id.test_radio_button_1)
    private RadioButton mRadioButton1;
    @ViewResourceId(R.id.test_radio_button_2)
    private RadioButton mRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_with_resource_id_example);

        Date startTime = new Date();
        ViewObjectMapper.mapObjectToView(this, this, findViewById(R.id.automap_container));
        Date endTime = new Date();

        Log.i(TAG, "Time to map: " + (endTime.getTime() - startTime.getTime()));
    }
}
